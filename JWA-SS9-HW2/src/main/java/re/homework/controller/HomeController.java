package re.homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(
            @CookieValue(value = "guest_name", defaultValue = "Khách lạ") String guestName,
            Model model
    ) {
        model.addAttribute("message", "Chào mừng " + guestName + "!");
        return "home";
    }
}
//Đoạn if (guestName == null) không bao giờ được thực thi vì Spring Boot mặc định coi @CookieValue("guest_name") là bắt buộc (required = true).
//
//Khi khách truy cập lần đầu, trình duyệt chưa có cookie guest_name, Spring sẽ ném exception MissingRequestCookieException và trả về lỗi 400 ngay lập tức. Do đó, method không được gọi và chương trình không chạy đến phần kiểm tra if.
//
// Kết luận: Lỗi không nằm ở câu lệnh if, mà do cấu hình @CookieValue khiến request bị chặn trước khi vào hàm.