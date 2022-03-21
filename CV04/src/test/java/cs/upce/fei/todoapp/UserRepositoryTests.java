package cs.upce.fei.todoapp;

import cs.upce.fei.todoapp.entity.User;
import cs.upce.fei.todoapp.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = new User("pepanovak", "password", "pepanova@email.com");
        userRepository.save(user);
    }

    @Test
    void getUser(){
        User user = userRepository.getById(8L); //Admin user
        Assertions.assertThat(user.getUsername()).isEqualTo("admin");
    }

    @Test
    void updateUser(){
        String newEmail = "email@email.com";
        User user = userRepository.getById(9L);
        user.setEmail(newEmail);

        user = userRepository.getById(9L);
        Assertions.assertThat(user.getEmail()).isEqualTo(newEmail);
    }

    @Test
    void getUsersWithWeakPassword(){
        List<User> users = userRepository.findUserByPasswordIsLessThan(6);
        Assertions.assertThat(users.size()).isEqualTo(3);
    }

}
