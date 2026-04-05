package re.edu.repository;


import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    @Override
    public int getStock(String foodName) {
        return 10;
    }

    @Override
    public void decreaseStock(String foodName, int quantity) {
        System.out.println("Đã trừ kho: " + foodName);
    }

    public double getPrice(String foodName) {
        return 20000;
    }

    public boolean exists(String foodName) {
        return true;
    }
}
