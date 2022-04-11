package cs.upce.nnpia.todolist.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateTaskDtoIn {

    @NotBlank(message = "Description is mandatory!")
    private String description;
    private Integer priority;
}
