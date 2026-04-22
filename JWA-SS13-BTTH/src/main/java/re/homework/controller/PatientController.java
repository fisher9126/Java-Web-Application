package re.homework.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import re.homework.model.entity.Doctor;
import re.homework.model.entity.Patient;
import re.homework.service.PatientService;


@Controller
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("patients", service.findAllPatients());
        model.addAttribute("total", service.countTotalPatients());
        return "patient-list";
    }

    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("patient", new Patient());
        return "patient-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Patient patient) {

        Doctor d = new Doctor();
        d.setId(1L);

        patient.setDoctor(d);

        service.save(patient);
        return "redirect:/patients";
    }
}