package re.validation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleOfTenThousand {

    String message() default "Withdraw amount must be >= 50,000 and multiple of 10,000";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
