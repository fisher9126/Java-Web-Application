package re.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.manager.model.entity.Equipment;
import re.manager.service.EquipmentService;

@Controller
@RequestMapping("/admin/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //  list
    @GetMapping
    public String list(Model model) {
        model.addAttribute("list", equipmentService.getAll());
        return "admin/equipment-list";
    }

    //  form add
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("equipment", new Equipment());
        return "admin/equipment-form";
    }

    //  save
    @PostMapping("/save")
    public String save(@ModelAttribute Equipment e) {

        if ("LAB".equals(e.getType())) {
            e.setQuantity(1); //  ép luôn
        }

        equipmentService.add(e);
        return "redirect:/admin/equipment";
    }

    //  delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        equipmentService.delete(id);
        return "redirect:/admin/equipment";
    }
}