package cs.upce.fei.todoapp.controller;

import cs.upce.fei.todoapp.dto.AddOrEditTodolistDto;
import cs.upce.fei.todoapp.entity.Todolist;
import cs.upce.fei.todoapp.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class ToDoListController {

    @Autowired
    private TodolistRepository todolistRepository;

    @GetMapping("/todo-lists")
    public String showToDoLists(Model model){
        model.addAttribute("lists", todolistRepository.findAll());
        return "todo-lists";
    }

    @GetMapping("/todo-lists/{id}")
    public String showToDoLists(@PathVariable Long id, Model model){
        model.addAttribute("lists", todolistRepository.findAllByUserToDoList(id));
        return "todo-lists";
    }

    @GetMapping(value = {"/todo-form", "/todo-form/{id}"})
    public String showTodoForm(@PathVariable(required = false) Long id, Model model){
        if(id != null){
            Todolist todoById = todolistRepository.findById(id).orElse(new Todolist());
            model.addAttribute("todolist", todoById);
        }else{
            model.addAttribute("todolist", new AddOrEditTodolistDto());
        }

        return "todo-form";
    }

    @PostMapping("/todo-form-process")
    public String taskFormProcess(AddOrEditTodolistDto addOrEditTodolistDto){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //LocalDateTime dateTime = LocalDateTime.parse(addTaskDto.getEndTime(), formatter);
        LocalDateTime dateTime = LocalDateTime.now();
        Todolist task = new Todolist();
        task.setName(addOrEditTodolistDto.getName());
        task.setDescription(addOrEditTodolistDto.getDescription());
        task.setId(addOrEditTodolistDto.getId());

        todolistRepository.save(task);
        return "redirect:/todo-lists";
    }
}
