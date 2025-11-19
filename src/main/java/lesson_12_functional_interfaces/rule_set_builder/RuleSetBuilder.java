package lesson_12_functional_interfaces.rule_set_builder;

import java.util.ArrayList;
import java.util.List;

public class RuleSetBuilder<T> {

    private final List<Rule<T>> rules = new ArrayList<>();

    private RuleSetBuilder() {
        //
    }

    public static <T> RuleSetBuilder<T> create() {
        return new RuleSetBuilder<T>();
    }

    public RuleSetBuilder<T> addRule(Rule<T> rule) {
        rules.add(rule);
        return this;
    }

    public RuleSet<T> build() {
        RuleSet<T> ruleSet = new RuleSet<>();

        for (Rule<T> rule : rules)
            ruleSet.addRule(rule);

        return ruleSet;
    }
}
