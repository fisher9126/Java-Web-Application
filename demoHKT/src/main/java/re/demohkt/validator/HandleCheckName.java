package re.demohkt.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import re.demohkt.model.dto.ProductDTO;

public class HandleCheckName implements ConstraintValidator<CheckName, ProductDTO> {
    @Override
    public boolean isValid(ProductDTO productDTO, ConstraintValidatorContext context) {
        if(productDTO.getName()==null || productDTO.getName().trim().equals("")){
            return true;
        }
        if(productDTO.getName().length()<5){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Phải hơn 5 kí tự").addPropertyNode("name").addConstraintViolation()
            ;
            return false;
        }
        return true;
    }
}
