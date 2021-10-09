package annotation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static annotation.AnnotationConstant.VALUE_CANNOT_BE_EMPTY;
import static annotation.AnnotationConstant.VALUE_CANNOT_BE_NULL_OR_EXCEED_MAX_LENGTH;

@NotBlank(message = VALUE_CANNOT_BE_EMPTY)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
public @interface CheckString {
    String message() default VALUE_CANNOT_BE_NULL_OR_EXCEED_MAX_LENGTH;

    Class<?>[] groups() default {};

    @OverridesAttribute(constraint = Size.class, name = "max") int max() default 1000;

    @OverridesAttribute(constraint = Size.class, name = "min") int min() default 0;
}
