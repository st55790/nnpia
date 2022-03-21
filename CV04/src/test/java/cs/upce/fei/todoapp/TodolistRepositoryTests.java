package cs.upce.fei.todoapp;

import cs.upce.fei.todoapp.entity.Todolist;
import cs.upce.fei.todoapp.repository.TodolistRepository;
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
class TodolistRepositoryTests {

    @Autowired
    private TodolistRepository todolistRepository;

    @Test
    void saveToDoList() {
        Todolist todolist = new Todolist("My todo list", "lorem ipsum..");
        todolistRepository.save(todolist);
    }

    @Test
    void getToDoListById(){
        List<Todolist> todolists = todolistRepository.findByNameIsContaining("a");
        Assertions.assertThat(todolists.size()).isEqualTo(2);
    }
}
