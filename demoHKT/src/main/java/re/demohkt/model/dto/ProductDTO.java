package re.demohkt.model.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
import re.demohkt.validator.CheckName;

@CheckName
public class ProductDTO {
    private String id;
    @NotBlank

    private String name;
    @NotBlank
    private String description;
    private MultipartFile url;


    public ProductDTO() {
    }

    public ProductDTO(String id, String name, String description, MultipartFile url) {
        this.id = id;

        this.name = name;

        this.description = description;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getUrl() {
        return url;
    }

    public void setUrl(MultipartFile url) {
        this.url = url;
    }
}
