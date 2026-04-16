package re.validation.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import re.validation.dto.AddressDto;
@Controller

public class UserController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("address", new AddressDto());
        return "form";
    }
    @PostMapping("/update")
    public String updateAddress(@Valid @ModelAttribute("address") AddressDto address, BindingResult bindingResult, Model model) {

         if(bindingResult.hasErrors()) {

             return "form";
         }
         return "success";
    }
}
// Phần 1 – Vì sao code hiện tại bị lỗi?
// (1) Lọt khoảng trắng vào DB
//@NotNull
//Nhưng @NotNull chỉ check ≠ null, chứ:

//" " (toàn space) → vẫn là String hợp lệ
//" " ≠ null → PASS
//=> Hệ thống cho qua → lưu DB → địa chỉ trắng tinh
// (2) Không chặn request từ Postman → văng 500

//2 vấn đề chính:
// Thiếu @Valid
//public ResponseEntity<String> updateAddress(@RequestBody AddressDto addressDto)
// Không có @Valid ⇒ Bean Validation KHÔNG chạy
//=> Request từ Postman gửi lên:
//
//null
//""
//" "
//
// đều lọt qua → xuống service / DB → có thể:
//
//lỗi null
//lỗi logic
//→  500 Internal Server Error
//⚠ Không handle exception validation
//
//Kể cả có validation mà không handle thì:
//
//Spring ném MethodArgumentNotValidException
//Không bắt → vẫn trả 500