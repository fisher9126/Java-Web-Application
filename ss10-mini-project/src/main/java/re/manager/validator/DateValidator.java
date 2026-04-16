package re.manager.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import re.manager.model.dto.BookingDTO;

public class DateValidator implements ConstraintValidator<ValidDateRange, BookingDTO> {

    @Override
    public boolean isValid(BookingDTO dto, ConstraintValidatorContext context) {

        // Nếu null thì bỏ qua (để @NotNull xử lý)
        if (dto.getBorrowDate() == null || dto.getReturnDate() == null) {
            return true;
        }

        // Nếu ngày trả sau ngày mượn → OK
        if (dto.getReturnDate().isAfter(dto.getBorrowDate())) {
            return true;
        }

        //  Sai → custom lỗi gắn vào field returnDate
        context.disableDefaultConstraintViolation();

        context.buildConstraintViolationWithTemplate("Ngày trả phải sau ngày mượn")
                .addPropertyNode("returnDate")
                .addConstraintViolation();

        return false;
    }
}