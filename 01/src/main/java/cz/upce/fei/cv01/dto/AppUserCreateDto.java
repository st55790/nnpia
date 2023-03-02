package cz.upce.fei.cv01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserCreateDto {

    private String username;

    private String password;

    private Boolean active;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
