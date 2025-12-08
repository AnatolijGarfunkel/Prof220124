package field_validator.records;

import records_validator.person_validator.PersonFieldRules;

import java.util.function.Predicate;

public record PersonRules(Predicate<PersonFieldRules> rule, String message) {
}
