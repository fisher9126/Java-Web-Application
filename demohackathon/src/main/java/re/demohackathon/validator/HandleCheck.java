package re.demohackathon.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import re.demohackathon.dto.ImgFile;

@Component
public class HandleCheck implements ConstraintValidator<CheckNumber, ImgFile> {

    @Override
    public boolean isValid(ImgFile value, ConstraintValidatorContext context) {
        return value.getA()<value.getB();
    }
}
