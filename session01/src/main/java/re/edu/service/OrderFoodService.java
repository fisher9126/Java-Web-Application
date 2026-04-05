package re.edu.service;

import org.springframework.stereotype.Service;
import re.edu.repository.UserAccountRepository;

@Service
public class OrderFoodService {

    private InventoryRepository inventoryRepo;
    private UserAccountRepository userRepo;

    // DI qua constructor
    public OrderFoodService(InventoryRepository inventoryRepo, UserAccountRepository userRepo) {
        this.inventoryRepo = inventoryRepo;
        this.userRepo = userRepo;
    }

    public  String orderFood(String username, String foodName, int quantity) {

        int stock = inventoryRepo.getStock(foodName);
        if (stock <= 0 || stock < quantity) {
            return "Món này hết rồi";
        }

        double price = getPrice(foodName) * quantity;
        double balance = userRepo.getBalance(username);

        if (balance < price) {
            return "Không đủ tiền bro";
        }

        // xử lý chính
        userRepo.deductBalance(username, price);
        inventoryRepo.decreaseStock(foodName, quantity);

        return "Order thành công";
    }

    private double getPrice(String foodName) {
        return 20000; // demo
    }
}
