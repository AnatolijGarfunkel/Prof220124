package lesson_12_functional_interfaces.field_dsl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FieldRuleSetBuilder<T> {

    private final List<FieldRule<T>> fieldRules = new ArrayList<>();

    private FieldRuleSetBuilder() {
        //
    }

    public static <T> FieldRuleSetBuilder<T> create() {
        return new FieldRuleSetBuilder<>();
    }

    public FieldRuleSetBuilder<T> field(String fieldName, Function<T, String> extractor, Consumer<FieldRuleBuilder<T>> config) {
        FieldRuleBuilder<T> builder = new FieldRuleBuilder<>(fieldName, extractor);
        config.accept(builder);
        FieldRule<T> fieldRule = builder.build();
        fieldRules.add(fieldRule);
        return this;
    }

    public FieldRuleSet<T> build() {
        FieldRuleSet<T> set = new FieldRuleSet<>();
        for (FieldRule<T> rule : fieldRules)
            set.addFieldRule(rule);
        return set;
    }
}
