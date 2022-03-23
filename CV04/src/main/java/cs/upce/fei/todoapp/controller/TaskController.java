package cs.upce.fei.todoapp.controller;

import cs.upce.fei.todoapp.dto.AddOrEditTaskDto;
import cs.upce.fei.todoapp.entity.Task;
import cs.upce.fei.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @ExceptionHandler(RuntimeException.class)
    public String handleException(){
        return "error";
    }

    @GetMapping("/remove-task/{id}")
    public String removeTask(@PathVariable Long id, Model model){
        taskRepository.deleteById(id);
        model.addAttribute("taskList", taskRepository.findAll());
        return "redirect:/task-list";
    }

    @GetMapping("/tasks")
    public String showTask(Model model){
        model.addAttribute("taskList", taskRepository.findAll());
        return "task-list";
    }

    @GetMapping("/tasks/{id}")
    public String showTasks(@PathVariable Long id, Model model){
        model.addAttribute("taskList", taskRepository.findAllByIdTodo(id));
        return "task-list";
    }

    @GetMapping("/task/{id}")
    public String showTask(@PathVariable(required = false) Long id, Model model){
        model.addAttribute("task", taskRepository.findById(id).get());
        return "task";
    }

    @GetMapping(value = {"/task-form", "/task-form/{id}"})
    public String showTaskForm(@PathVariable(required = false) Long id, Model model){
        if(id != null){
            Task taskById = taskRepository.findById(id).orElse(new Task());
            model.addAttribute("task", taskById);
        }else{
            model.addAttribute("task", new AddOrEditTaskDto());
        }

        return "task-form";
    }

    @PostMapping("/task-form-process")
    public String taskFormProcess(AddOrEditTaskDto addOrEditTaskDto){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //LocalDateTime dateTime = LocalDateTime.parse(addTaskDto.getEndTime(), formatter);
        LocalDateTime dateTime = LocalDateTime.now();
        Task task = new Task();
        task.setName(addOrEditTaskDto.getName());
        task.setDescription(addOrEditTaskDto.getDescription());
        task.setEndTime(dateTime);
        task.setState(addOrEditTaskDto.getState());
        task.setId(addOrEditTaskDto.getId());

        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
