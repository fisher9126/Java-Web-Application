package re.homework.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {


    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") String productId,
                            HttpSession session) {

        List<String> cart = (List<String>) session.getAttribute("myCart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        cart.add(productId);

        session.setAttribute("myCart", cart);

        return "redirect:/checkout";
    }


    @GetMapping("/checkout")
    public String viewCheckout(HttpSession session, Model model) {

        List<String> cart = (List<String>) session.getAttribute("myCart");

        if (cart == null || cart.isEmpty()) {
            model.addAttribute("message", "Giỏ hàng của bạn đang trống!");
        } else {
            model.addAttribute("message", "Bạn có " + cart.size() + " sản phẩm.");
        }

        return "checkout-page";
    }
}
//Đoạn code trên gây ra hiện tượng “mất trí nhớ” của giỏ hàng do sử dụng HttpServletRequest để lưu dữ liệu trong khi lại dùng redirect giữa các request.
//
//Cụ thể, trong phương thức /add-to-cart, giỏ hàng được lưu bằng:
//
//request.setAttribute("myCart", cart);
//
//Tuy nhiên, HttpServletRequest chỉ có phạm vi tồn tại trong một request duy nhất.
//
//Sau đó, chương trình thực hiện:
//
//return "redirect:/checkout";
//
//Lệnh redirect sẽ gửi về trình duyệt một phản hồi HTTP 302, yêu cầu trình duyệt tạo một request mới hoàn toàn đến /checkout. Khi đó:
//
//Request cũ (chứa myCart) đã bị hủy
//Request mới không còn dữ liệu trước đó
//
//Vì vậy, khi vào /checkout, lệnh:
//
//request.getAttribute("myCart");
//
//luôn trả về null, dẫn đến giỏ hàng bị rỗng.
//
//Kết luận
//
//Lỗi không nằm ở logic xử lý danh sách, mà do sử dụng sai phạm vi lưu trữ dữ liệu:
//
//HttpServletRequest không phù hợp để lưu dữ liệu cần tồn tại qua nhiều request
//Kết hợp với redirect khiến dữ liệu bị mất hoàn toàn