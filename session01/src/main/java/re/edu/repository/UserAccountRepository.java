package re.edu.repository;

import org.springframework.stereotype.Repository;


public interface UserAccountRepository {
    double getBalance(String username);
    void deductBalance(String username, double amount);
}