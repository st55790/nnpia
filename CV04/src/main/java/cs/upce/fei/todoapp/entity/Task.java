package cs.upce.fei.todoapp.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private StateEnum state;

    private LocalDateTime endTime;

    @ManyToOne //Maybe @ManyToOne
    private Todolist todolist;

    public Task() {
    }

    public Task(String name, String description, StateEnum state, LocalDateTime endTime) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.endTime = endTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Todolist getTodolist() {
        return todolist;
    }

    public void setTodolist(Todolist todolist) {
        this.todolist = todolist;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
