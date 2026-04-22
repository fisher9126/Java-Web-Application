package re.orm_hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import re.orm_hibernate.model.entity.Product;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public Product addProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.persist(product);
        return product;

    }

    public List<Product> getALl() {
        Session session =sessionFactory.openSession();
       return session.createQuery("from Product ",Product.class).list();
    }
}
