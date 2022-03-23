package cs.upce.fei.todoapp.repository;

import cs.upce.fei.todoapp.entity.StateEnum;
import cs.upce.fei.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.todolist.id = :id")
    List<Task> findAllByIdTodo(Long id);

    //@Query("select t from Task t where t.state = :state and t.todolist = :id")
    //List<Task> getTasksByStateAndUserId(StateEnum state, Integer id);
}
