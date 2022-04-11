package cs.upce.nnpia.todolist.controller;

import cs.upce.nnpia.todolist.dto.CreateTaskDtoIn;
import cs.upce.nnpia.todolist.dto.TaskDto;
import cs.upce.nnpia.todolist.entity.Task;
import cs.upce.nnpia.todolist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/todos")
    public Page<Task> getAllTasks(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "id") String sortBy){
        return taskService.getTasks(page, sortBy);
    }

    @GetMapping("/todos/{id}")
    public Task getTask(@PathVariable Integer id){
        return taskService.getTask(id);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTask(@PathVariable Integer id){
        taskService.deleteTask(id);
    }

    @PostMapping("/todos")
    public TaskDto createTask(@RequestBody @Valid CreateTaskDtoIn createTaskDtoIn){
        return taskService.createTask(createTaskDtoIn);
    }
}
