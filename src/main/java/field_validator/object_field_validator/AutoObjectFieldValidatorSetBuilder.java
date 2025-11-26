package field_validator.object_field_validator;

import field_validator.string_validator_function.StringValidator;
import field_validator.string_validator_function.StringValidatorBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.RecordComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class AutoObjectFieldValidatorSetBuilder<T> {

    private record FieldInfo(String field, Method accessor) {}

    private final Map<FieldInfo, StringValidatorBuilder> perFieldBuilders = new LinkedHashMap<>();

    private AutoObjectFieldValidatorSetBuilder(Class<T> tClass) {
        initStringComponents(tClass);
    }

    private void initStringComponents(Class<T> tClass) {
        RecordComponent[] components = tClass.getRecordComponents();
        for (RecordComponent component : components) {
            if (component.getType() == String.class) {
                String field = component.getName();
                Method accessor = component.getAccessor();
                perFieldBuilders.put(new FieldInfo(field, accessor), StringValidatorBuilder.create());
            }
        }

    }

    public static <T> AutoObjectFieldValidatorSetBuilder<T> forRecord(Class<T> tClass) {
        return new AutoObjectFieldValidatorSetBuilder<>(tClass);
    }

    public AutoObjectFieldValidatorSetBuilder<T> allStringFields(Consumer<StringValidatorBuilder> config) {
        for(StringValidatorBuilder builder : perFieldBuilders.values())
            config.accept(builder);
        return this;
    }

    public AutoObjectFieldValidatorSetBuilder<T> field(String field, Consumer<StringValidatorBuilder> config) {
        for (Map.Entry<FieldInfo, StringValidatorBuilder> pair : perFieldBuilders.entrySet())
            if (pair.getKey().field().equals(field))
                config.accept(pair.getValue());
        return this;
    }

    public ObjectFieldValidatorSet<T> build() {
        ObjectFieldValidatorSet<T> objectFieldValidatorSet = new ObjectFieldValidatorSet<>();
        for (Map.Entry<FieldInfo, StringValidatorBuilder> pair : perFieldBuilders.entrySet()) {
            String field = pair.getKey().field();
            Function<T, String> extractor = object -> {
                try {
                    Object value = pair.getKey().accessor().invoke(object);
                    return value != null ? value.toString() : null;
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            };
            StringValidatorBuilder stringValidatorBuilder = pair.getValue();
            StringValidator stringValidator = stringValidatorBuilder.build();
            objectFieldValidatorSet.addObjectFieldValidator(new ObjectFieldValidator<>(field, extractor, stringValidator));
        }
        return objectFieldValidatorSet;
    }
}
















































