package re.orm_hibernate.service;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.orm_hibernate.model.entity.Product;
import re.orm_hibernate.repository.ProductRepository;

import java.awt.*;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product addProduct(Product product) {
        productRepository.addProduct(product);
        return product;
    }
    public List<Product> getALl() {
        return productRepository.getALl();
    }

}
