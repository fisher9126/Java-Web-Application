package re.validation.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Product {
    private List<Product> products;

    public Product() {
    }
}
