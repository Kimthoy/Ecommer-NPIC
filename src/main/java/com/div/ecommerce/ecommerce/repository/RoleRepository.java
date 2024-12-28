package com.div.ecommerce.ecommerce.repository;

import com.div.ecommerce.ecommerce.model.Role;
import com.div.ecommerce.ecommerce.model.User;
import com.div.ecommerce.ecommerce.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r JOIN FETCH r.users")
    List<Role> findAllWithRoles();

}
