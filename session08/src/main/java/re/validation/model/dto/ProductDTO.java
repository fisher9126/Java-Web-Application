package re.validation.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductDTO {
<<<<<<< HEAD
    @NotBlank(message = "Haha")
=======
    @NotBlank(message = "Name is not empty")
>>>>>>> 72b6359 (mini-project)
    public String productName;
    @NotNull(message = "hihi")
    public double price;


    public ProductDTO() {
    }
<<<<<<< HEAD
=======

    public ProductDTO(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
>>>>>>> 72b6359 (mini-project)
}
