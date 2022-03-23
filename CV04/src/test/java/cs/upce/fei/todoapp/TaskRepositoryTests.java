package cs.upce.fei.todoapp;

import cs.upce.fei.todoapp.entity.StateEnum;
import cs.upce.fei.todoapp.entity.Task;
import cs.upce.fei.todoapp.repository.TaskRepository;
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
class TaskRepositoryTests {

    @Autowired
    private TaskRepository taskRepository;

    //@Test
    //void getTasksByStateAndIdTodolist() {
    //    List<Task> list = taskRepository.getTasksByStateAndUserId(StateEnum.IMPORTANT, 2);
    //    Assertions.assertThat(list.size()).isEqualTo(2);
    // }

}
