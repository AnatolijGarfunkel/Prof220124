package field_validator.object_field_validator;

import field_validator.string_validator_function.StringValidator;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class AutoObjectFieldValidatorSetBuilder<T> {

    private record FieldInfo(String field, Method accessor) {}

    private final List<FieldInfo> fieldInfos = new ArrayList<>();

    private final List<StringValidatorBuilder> stringValidatorBuilders = new ArrayList<>();

    private final ObjectFieldValidatorSet<T> objectFieldValidatorsSet = new ObjectFieldValidatorSet<>();

    private AutoObjectFieldValidatorSetBuilder(Class<T> tClass) {
        RecordComponent[] components = tClass.getRecordComponents();
        for (RecordComponent component : components) {
            if (component.getType() == String.class) {
                String field = component.getName();
                Method accessor = component.getAccessor();
                fieldInfos.add(new FieldInfo(field, accessor));
            }
        }
    }

    public static <T> AutoObjectFieldValidatorSetBuilder<T> forClass(Class<T> tClass) {
        return new AutoObjectFieldValidatorSetBuilder<>(tClass);
    }

    public AutoObjectFieldValidatorSetBuilder<T> allStringFields(Consumer<StringValidatorBuilder> config) {
        for (int i = 0; i < fieldInfos.size(); i++) {
            StringValidatorBuilder stringValidatorBuilder = StringValidatorBuilder.create();
            config.accept(stringValidatorBuilder);
            stringValidatorBuilders.add(stringValidatorBuilder);
        }
        return this;
    }

    public AutoObjectFieldValidatorSetBuilder<T> field(String field, Consumer<StringValidatorBuilder> config) {
        int index = 0;
        for (FieldInfo fieldInfo : fieldInfos) {
            if (fieldInfo.field().equals(field)) {
                StringValidatorBuilder stringValidatorBuilder = stringValidatorBuilders.get(index);
                config.accept(stringValidatorBuilder);
            }
            index++;
        }
        return this;
    }

    public ObjectFieldValidatorSet<T> build() {
        for (int i = 0; i < fieldInfos.size(); i++) {
            FieldInfo fieldInfo = fieldInfos.get(i);
            String field = fieldInfo.field();
            Function<T, String> extractor = object -> {
                try {
                    Object value = fieldInfo.accessor().invoke(object);
                    return value != null ? value.toString() : null;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            };
            StringValidatorBuilder stringValidatorBuilder = stringValidatorBuilders.get(i);
            StringValidator stringValidator = stringValidatorBuilder.build();
            ObjectFieldValidator<T> objectFieldValidator = new ObjectFieldValidator<>(field, extractor, stringValidator);
            objectFieldValidatorsSet.addObjectFieldValidator(objectFieldValidator);
        }
        return objectFieldValidatorsSet;
    }
}
















































