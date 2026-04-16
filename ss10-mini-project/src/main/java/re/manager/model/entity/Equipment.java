package re.manager.model.entity;

import org.springframework.web.multipart.MultipartFile;

public class Equipment {

        private Long id;
        private String name;
        private String description;
        private int quantity;
        private String imageUrl;

        private String type; // "DEVICE" | "LAB"

    public Equipment() {
    }

    public Equipment(Long id, String name, String description, int quantity, String imageUrl, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

