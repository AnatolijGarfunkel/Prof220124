package field_validator.records;

import records_validator.obect_validator.person_rules.PersonFieldRules;

import java.util.function.Predicate;

public record PersonRules(Predicate<PersonFieldRules> rule, String message) {
}
