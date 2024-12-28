package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RoleService {
    Role create(Role role);
    Role update(Long id, Role role);
    Map<String,Boolean> delete(Long id);
    Role getById(Long id);
    List<Role>getAll();
    Role getRoleDTOById(Long id);
}

