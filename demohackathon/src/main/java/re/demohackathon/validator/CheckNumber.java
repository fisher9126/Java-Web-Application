package re.demohackathon.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HandleCheck.class)
public @interface CheckNumber {
    String message() default "a phải bé hơn b";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
