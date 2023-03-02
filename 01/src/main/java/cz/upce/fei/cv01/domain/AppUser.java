package cz.upce.fei.cv01.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import cz.upce.fei.cv01.dto.AppUserDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//validdate, create, create-drop, update, none
@NoArgsConstructor
@Data
@Entity
public class AppUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Task> tasks = Collections.emptyList();

    @JsonIgnore
    @ManyToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Role> roles = Collections.emptyList();

    public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public AppUser(Long id, String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
