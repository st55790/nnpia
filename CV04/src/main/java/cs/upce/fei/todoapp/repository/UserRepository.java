package cs.upce.fei.todoapp.repository;

import cs.upce.fei.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where length(u.password) < ?1")
    List<User> findUserByPasswordIsLessThan(Integer length);

    @Query("select u from User u where u.username like :username and u.password like :password")
    User findUserByUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.username like :username")
    User findUserByName(String username);
}
