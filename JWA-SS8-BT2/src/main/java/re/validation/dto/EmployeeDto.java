package re.validation.dto;

import jakarta.validation.constraints.NotBlank;

public class EmployeeDto {
    @NotBlank(message = "Không được trống")
    private String id;
    @NotBlank(message = "Không được trống")
    private String firstName;

    public EmployeeDto() {
    }

    public EmployeeDto(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
