package cs.upce.nnpia.todolist.repository;

import cs.upce.nnpia.todolist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
