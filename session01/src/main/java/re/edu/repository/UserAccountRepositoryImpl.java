package re.edu.repository;



import org.springframework.stereotype.Repository;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    @Override
    public double getBalance(String username) {
        return 100000; // demo
    }

    @Override
    public void deductBalance(String username, double amount) {
        System.out.println("Đã trừ tiền: " + amount);
    }
}
