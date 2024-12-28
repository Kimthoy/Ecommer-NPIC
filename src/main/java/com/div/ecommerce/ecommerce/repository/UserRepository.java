package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT a FROM User a LEFT JOIN FETCH a.roles")
    List<User> findAllWithRoles();


    @Query("SELECT u FROM User u WHERE u.name =:name")
    Optional<User> findByUsername(String name);
}
