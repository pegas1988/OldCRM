package annotation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class AnnotationConstant {
    static final String PARAMETER_SHOULD_BE_INT_EQUAL_OR_GREATER_THAN = "Entered parameter should be int equal or greater than";
    static final String VALUE_CANNOT_BE_NULL_OR_EXCEED_MAX_LENGTH = "Value cannot be null or exceed max length";
    static final String VALUE_CANNOT_BE_EMPTY = "Value cannot be empty";
}
