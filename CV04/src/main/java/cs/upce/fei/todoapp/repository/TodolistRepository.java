package cs.upce.fei.todoapp.repository;

import cs.upce.fei.todoapp.entity.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodolistRepository extends JpaRepository<Todolist, Long> {

    @Query("select t from Todolist t where t.name like %:str%")
    List<Todolist> findByNameIsContaining(String str);

    @Query("select t from Todolist t where t.userToDoList.id = :id")
    List<Todolist> findAllByUserToDoList(Long id);
}
