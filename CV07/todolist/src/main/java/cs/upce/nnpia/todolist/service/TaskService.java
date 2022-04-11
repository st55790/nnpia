package cs.upce.nnpia.todolist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs.upce.nnpia.todolist.dto.CreateTaskDtoIn;
import cs.upce.nnpia.todolist.dto.TaskDto;
import cs.upce.nnpia.todolist.entity.Task;
import cs.upce.nnpia.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;

    @Autowired
    private final ObjectMapper objectMapper;

    public TaskService(TaskRepository taskRepository, ObjectMapper objectMapper) {
        this.taskRepository = taskRepository;
        this.objectMapper = objectMapper;
    }

    public Page<Task> getTasks(Integer page, String sortBy) {
        PageRequest pageRequest = PageRequest.of(page, 2, Sort.Direction.ASC, sortBy);
        return taskRepository.findAll(pageRequest);
    }

    public TaskDto createTask(CreateTaskDtoIn createTaskDtoIn) {
        Task task = objectMapper.convertValue(createTaskDtoIn, Task.class);

        Task save = taskRepository.save(task);
        return objectMapper.convertValue(save, TaskDto.class);
    }

    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found!"));
    }

    public void deleteTask(Integer id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found!"));
        taskRepository.delete(task);
    }
}
