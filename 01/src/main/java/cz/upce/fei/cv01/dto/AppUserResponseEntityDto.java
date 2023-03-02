package cz.upce.fei.cv01.dto;

import liquibase.datatype.DataTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserResponseEntityDto {

    @NotNull
    @NotBlank
    @Size(max = 256)
    private String username;

    private String password;

    private Boolean active;

    private LocalDateTime creationDate;

    private LocalDateTime updateDate;
}
