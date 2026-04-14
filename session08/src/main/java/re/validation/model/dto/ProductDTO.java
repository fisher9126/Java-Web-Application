package re.validation.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductDTO {
    @NotBlank(message = "Haha")
    public String productName;
    @NotNull(message = "hihi")
    public double price;


    public ProductDTO() {
    }
}
