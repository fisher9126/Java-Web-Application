package re.edu.config.service;

import org.springframework.stereotype.Service;
import re.edu.model.Product;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {
    private static List<Product> products;
    static {
        products= new ArrayList<>();
        products.add(new Product("1","huy","haha",10000));
        products.add(new Product("2","huy2","huhu",20000));
        products.add(new Product("3","huy3","hihi",30000));
        products.add(new Product("4","huy4","hehe",40000));
    }
    public List<Product> getProducts(){
        return products;
    }

}
