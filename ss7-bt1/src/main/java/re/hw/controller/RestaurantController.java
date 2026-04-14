package re.hw.controller;
//Phần 1: Phân tích logic (dạng text)
//
//Trong cơ chế Data Binding của Spring MVC, dữ liệu từ form HTML sẽ được ánh xạ (map) vào object Java thông qua tên thuộc tính (property name) tương ứng với các getter/setter.
//
//Lỗi 1: Tên cửa hàng bị null
//
//Nguyên nhân là do tên thuộc tính trong form HTML không trùng với tên field trong class RestaurantProfile.
//
//Trong HTML: name="restaurantName"
//Trong Java: private String name;
//
//Spring sẽ tìm method setRestaurantName() để bind dữ liệu, nhưng trong class chỉ có setName(). Do không tìm thấy setter phù hợp nên dữ liệu không được gán → kết quả name = null.
//
//Lỗi 2: Checkbox active không hoạt động đúng
//
//Có 2 vấn đề chính:
//
//Sai giá trị value của checkbox
//
//HTML đang dùng:
//
//value="MỞ_CỬA"
//
//Trong khi field Java là:
//
//boolean active;
//
//Spring chỉ có thể convert các giá trị như "true", "false" hoặc "on" sang boolean. Giá trị "MỞ_CỬA" không hợp lệ nên binding bị lỗi.
//
//Checkbox không gửi dữ liệu khi không được tick
//
//Theo cơ chế HTML:
//
//Nếu checkbox được tick → gửi dữ liệu lên server
//Nếu không tick → không gửi gì cả
//
//Điều này khiến backend không nhận được giá trị active, dễ dẫn đến sai logic nếu không xử lý đúng.
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import re.hw.model.RestaurantProfile;

@Controller
public class RestaurantController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("restaurantProfile", new RestaurantProfile());
        return "restaurant";
    }
    @PostMapping("/update-profile")
    public String updateProfile(RestaurantProfile profile) {
        System.out.println("Tên quán: " + profile.getName());
        System.out.println("SĐT: " + profile.getPhone());
        System.out.println("Trạng thái: " + profile.isActive());



        return "success";
    }
}
