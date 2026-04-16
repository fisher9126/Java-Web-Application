package re.manager.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import re.manager.model.dto.BookingDTO;
import re.manager.model.entity.Equipment;
import re.manager.service.BookingService;
import re.manager.service.EquipmentService;

@Controller
public class BookingController {

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private BookingService bookingService;


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("equipments", equipmentService.getAll());
        return "student/home";
    }

    //  form booking
    @GetMapping("/booking/{id}")
    public String form(@PathVariable("id") Long id, Model model) {

        Equipment eq = equipmentService.getById(id);

        BookingDTO dto = new BookingDTO();
        dto.setEquipmentId(id);

        // 🔥 nếu là lab → auto = 1
        if ("LAB".equals(eq.getType())) {
            dto.setQuantity(1);
        }

        model.addAttribute("equipment", eq);
        model.addAttribute("bookingDTO", dto);

        return "student/form";
    }

    //  submit
    @PostMapping("/booking")
    public String submit(
            @Valid @ModelAttribute("bookingDTO") BookingDTO dto,
            BindingResult result,
            Model model, // 🔥 thêm cái này
            RedirectAttributes redirect
    ) {

        if (result.hasErrors()) {

            // 🔥 add lại equipment
            model.addAttribute("equipment",
                    equipmentService.getById(dto.getEquipmentId()));

            return "student/form";
        }

        try {
            bookingService.create(dto);
        } catch (RuntimeException e) {

            model.addAttribute("equipment",
                    equipmentService.getById(dto.getEquipmentId()));

            result.rejectValue("quantity", null, e.getMessage());
            return "student/form";
        }

        redirect.addFlashAttribute("success", "Đăng ký thành công");
        return "redirect:/";
    }
}