package re.edu.repository;

import org.springframework.stereotype.Repository;


public interface InventoryRepository {
    int getStock(String foodName);
    void decreaseStock(String foodName, int quantity);
}
