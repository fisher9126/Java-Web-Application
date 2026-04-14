package re.hw.controller;


//Trong mã nguồn hiện tại, việc lặp lại đoạn code:
//
//model.addAttribute("categories", ...);
//
//ở nhiều phương thức xử lý request trong cùng một Controller đã vi phạm nguyên tắc Don't Repeat Yourself trong lập trình.
//
//Nguyên tắc này nhấn mạnh rằng mỗi phần logic chỉ nên được định nghĩa một lần duy nhất nhằm tránh sự dư thừa và tăng khả năng tái sử dụng.
//
// Vấn đề cụ thể
//
//Trong trường hợp này, danh sách "Nhóm món ăn" (categories) là một dữ liệu dùng chung cho nhiều giao diện như:
//
//Trang thêm món
//Trang sửa món
//Trang tìm kiếm
//
//Tuy nhiên, việc lặp lại cùng một đoạn code để đưa dữ liệu này vào Model ở từng phương thức GET dẫn đến:
//
//Mã nguồn bị trùng lặp
//Controller trở nên cồng kềnh
//Khó kiểm soát và khó mở rộng
//️ Rủi ro khi mở rộng hệ thống
//
//Nếu trong tương lai hệ thống phát triển thêm nhiều trang (ví dụ 20 trang đều cần danh sách categories), thì việc lặp code sẽ gây ra các vấn đề nghiêm trọng:
//
//Khi thay đổi logic (ví dụ: lấy dữ liệu từ database thay vì hardcode), phải sửa ở nhiều vị trí khác nhau
//Dễ xảy ra lỗi do quên cập nhật đồng bộ giữa các nơi
//Tăng chi phí bảo trì và thời gian phát triển
//Làm giảm tính nhất quán của hệ thống
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller

public class DishController {

    @ModelAttribute("categories")
    public List<String> getCategories() {
        return Arrays.asList(
                "Món chính",
                "Đồ uống",
                "Tráng miệng",
                "Topping"
        );
    }
    @GetMapping("/dish/add")
    public String addDish() {
        return "add-dish";
    }
    @GetMapping("/dish/edit")
    public String editDish() {
        return "edit-dish";
    }

    @GetMapping("/dish/search")
    public String searchDish() {
        return "search-dish";
    }
}
