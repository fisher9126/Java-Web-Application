package re.demohkt.repository;

import org.springframework.stereotype.Repository;
import re.demohkt.model.entity.Product;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
    private List<Product> products;

    public ProductRepository() {
       products = new ArrayList<>();
       products.add(new Product("1","Sách","Sách oki lắm","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSUCEUJtsnT0unxgI0Q48FC2l5fDqAmgvaoA&s"));
       products.add(new Product("2","vở","Sách oki lắm","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSUCEUJtsnT0unxgI0Q48FC2l5fDqAmgvaoA&s"));
       products.add(new Product("3","bút","Sách oki lắm","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSUCEUJtsnT0unxgI0Q48FC2l5fDqAmgvaoA&s"));
       products.add(new Product("4","đèn","Sách oki lắm","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSUCEUJtsnT0unxgI0Q48FC2l5fDqAmgvaoA&s"));
    }
    public List<Product> getProducts() {
        return products;
    }
    public Product findById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(String id) {

    }
    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                products.set(i, product);
                return;
            }
        }
//          Product old = products.stream()
//            .filter(p -> p.getId().equals(product.getId()))
//            .findFirst()
//            .orElse(null);
//
//    if (old != null) {
//        int index = products.indexOf(old);
//        products.set(index, product);
//    }
    }

}
