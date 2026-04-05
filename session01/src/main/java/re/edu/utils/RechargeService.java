package re.edu.utils;

public class RechargeService {
//    private PaymentGateway gateway;
//
//    public RechargeService() {
//        // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
//        this.gateway = new InternalPaymentGateway();
//    }
//
//    public void processRecharge(String username, double amount) {
//        gateway.pay(amount);
//        System.out.println("Nạp " + amount + " cho " + username);
//    }
}
// Vấn đề:
//Hard-code dependency → dính chặt RechargeService với InternalPaymentGateway
//Muốn thêm Momo, ZaloPay → sửa code class này → toang nguyên tắc mở rộng
// Vì sao sai theo IoC:
//Không có Inversion of Control → class tự control dependency của nó
//        Không có Dependency Injection → không inject từ bên ngoài vào
//→ mất loose coupling, thành tight coupling Hậu quả:
//Muốn thêm:
//MomoPaymentGateway
//        ZaloPayPaymentGateway
//→ phải sửa constructor → vi phạm Open/Closed Principle