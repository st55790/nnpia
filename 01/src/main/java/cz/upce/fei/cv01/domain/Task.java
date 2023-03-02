package cz.upce.fei.cv01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
public class Task {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime updateDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private AppUser author;
}
