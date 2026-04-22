package re.demohkt.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HandleCheckName.class)
public @interface CheckName {
    String message() default "tên phải hơn 5 kí tự";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
