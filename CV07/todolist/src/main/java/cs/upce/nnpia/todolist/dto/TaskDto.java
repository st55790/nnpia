package cs.upce.nnpia.todolist.dto;

import lombok.Data;

@Data
public class  TaskDto {

    private Integer id;
    private String description;
    private Integer priority;
}
