package re.demohkt.service;

import org.springframework.stereotype.Service;
import re.demohkt.model.entity.Product;
import re.demohkt.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private static int count=4;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll() {
        return productRepository.getProducts();
    }
    public Product findById(String id) {
        return productRepository.findById(id);
    }
    public void addProduct(Product product) {
        List<Product> products = productRepository.getProducts();
        product.setId(String.valueOf(++count));
        productRepository.addProduct(product);
    }
    public void deleteProduct(String id) {
        productRepository.removeProduct(id);
    }
    public void updateProduct(Product product) {
        productRepository.updateProduct(product);
    }
}
