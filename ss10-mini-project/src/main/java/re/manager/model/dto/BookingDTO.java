package re.manager.model.dto;

import jakarta.validation.constraints.*;
import re.manager.validator.ValidDateRange;

import java.time.LocalDate;
@ValidDateRange
public class BookingDTO {

    @NotBlank(message = "Không được để trống")
    private String studentName;

    @Pattern(regexp = "^[A-Z]{2}\\d+$", message = "Mã SV sai format")
    private String studentCode;

    @Email(message = "Email không hợp lệ")
    private String email;

    @Min(value = 1, message = "Số lượng phải > 0")
    private int quantity;

    @Future(message = "Ngày mượn phải là tương lai")
    private LocalDate borrowDate;

    @NotNull(message = "Không được để trống")
    private LocalDate returnDate;

    @NotBlank(message = "Phải nhập lý do")
    private String reason;

    private Long equipmentId;

    public BookingDTO() {
    }

    public BookingDTO(String studentName, String studentCode, String email, int quantity, LocalDate borrowDate, LocalDate returnDate, String reason, Long equipmentId) {
        this.studentName = studentName;
        this.studentCode = studentCode;
        this.email = email;
        this.quantity = quantity;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.reason = reason;
        this.equipmentId = equipmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }
}
