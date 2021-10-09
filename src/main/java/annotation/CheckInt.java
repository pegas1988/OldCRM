package annotation;

import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static annotation.AnnotationConstant.PARAMETER_SHOULD_BE_INT_EQUAL_OR_GREATER_THAN;
import static annotation.AnnotationConstant.VALUE_CANNOT_BE_EMPTY;

@NotBlank(message = VALUE_CANNOT_BE_EMPTY)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CheckInt {
    String message() default PARAMETER_SHOULD_BE_INT_EQUAL_OR_GREATER_THAN;

    Class<?>[] groups() default {};

    int min() default 0;
}
