package re.edu.utils;

import org.springframework.stereotype.Component;

@Component
public class PlaySession {
    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }
}
//Điều gì đang xảy ra?
//PlaySession chỉ được tạo DUY NHẤT 1 INSTANCE
//Tất cả máy trạm (user login) đều dùng chung object này
//
//→ nghĩa là:
//
//Máy 01 addTime(10)
//Máy 02 addTime(5)
//
// thực chất là:
//
//        1 object playTime = 15
//        => tiền bị trừ chung → bug đúng kiểu "chia tiền không ai muốn"
//
//         Vì sao Singleton gây lỗi?
//Singleton = 1 object duy nhất trong toàn hệ thống
//Trong khi nghiệp vụ cần:
//mỗi user → 1 session riêng
//mỗi máy → 1 bộ đếm riêng
//
// nhưng mày lại cho tất cả share chung → sai business logic
