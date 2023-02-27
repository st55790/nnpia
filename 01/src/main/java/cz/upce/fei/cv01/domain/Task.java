package cz.upce.fei.cv01.domain;

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

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AppUser author;
}
