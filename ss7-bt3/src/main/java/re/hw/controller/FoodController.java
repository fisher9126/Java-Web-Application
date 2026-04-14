package re.hw.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import re.hw.model.Food;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodController {


    private static final List<Food> foodList = new ArrayList<>();
    @GetMapping("/")
    public String foodList(Model model){
        model.addAttribute("foodList", foodList);
        return "food";
    }
    @PostMapping("/food/add")
    public String addFood(
            @RequestParam("name") String name,
            @RequestParam("price") double price,
            @RequestParam("category") String category,
            @RequestParam("image") MultipartFile file
    ) throws IOException {


        if (file.isEmpty()) {
            System.out.println("Lỗi: Chưa chọn ảnh!");
            return "error";
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null ||
                !(fileName.endsWith(".jpg") || fileName.endsWith(".png") || fileName.endsWith(".jpeg"))) {
            System.out.println("Lỗi: File không hợp lệ!");
            return "error";
        }


        if (price < 0) {
            System.out.println("Lỗi: Giá phải >= 0!");
            return "error";
        }

        String uploadDir = "C:/RikkeiFood_Temp/";
        File dest = new File(uploadDir + fileName);
        file.transferTo(dest);
        Food food = new Food(name, price, category, dest.getAbsolutePath());
        foodList.add(food);
        System.out.println("Đã thêm món: " + name);
        System.out.println("Tổng số món: " + foodList.size());

        return "success";
    }
}
