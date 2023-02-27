package cz.upce.fei.cv01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

//validdate, create, create-drop, update, none
@NoArgsConstructor
@Data
@Entity
public class AppUser {

    @Id
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private Boolean active;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "author")
    private List<Task> tasks = Collections.emptyList();

    @JsonIgnore
    @ManyToMany(mappedBy = "users")
    private List<Role> roles = Collections.emptyList();
}
