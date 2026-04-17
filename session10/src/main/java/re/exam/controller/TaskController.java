package re.exam.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import re.exam.model.dto.TaskItemDTO;
import re.exam.model.entity.TaskItem;
import re.exam.repository.TaskItemRepository;

import java.util.List;

@Controller

public class TaskController {
    private TaskItemRepository taskItemRepository;

    public TaskController(TaskItemRepository taskItemRepository) {
        this.taskItemRepository = taskItemRepository;
    }

    @GetMapping("/")
    public String task(Model model) {
        List<TaskItem> taskList=taskItemRepository.getTaskItems();
        model.addAttribute("taskList", taskList);
        return "task-list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("task", new TaskItemDTO());
        return "form";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("task") TaskItemDTO taskItem, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        TaskItem newTask = new TaskItem();
        newTask.setId("");
        newTask.setTitle(taskItem.getTitle());
        newTask.setDeadline(taskItem.getDeadline());
        newTask.setPriority(taskItem.getPriority());
        System.out.println(newTask.getPriority());
        taskItemRepository.addTask(newTask);
        return "redirect:/";

    }
}
