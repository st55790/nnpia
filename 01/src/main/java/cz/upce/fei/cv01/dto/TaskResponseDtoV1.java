package cz.upce.fei.cv01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDtoV1 {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
}
