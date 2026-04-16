package re.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator
        implements ConstraintValidator<MultipleOfTenThousand, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {


        if (value == null) {
            return false;
        }

        if (value < 50_000) {
            return false;
        }

        if (value % 10_000 != 0) {
            return false;
        }

        return true;
    }
}