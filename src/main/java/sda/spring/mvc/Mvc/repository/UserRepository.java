package sda.spring.mvc.Mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import sda.spring.mvc.Mvc.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    void deleteByLogin(@Param("login") String login);
}
