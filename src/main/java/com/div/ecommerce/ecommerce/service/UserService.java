package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.dto.UserDTO;
import com.div.ecommerce.ecommerce.model.Model;
import com.div.ecommerce.ecommerce.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);
    User update(Long id,User user);
    User delete(Long id);
    User getById(Long id);
    User assignRoleToUser(Long userId, Long roleId);
    List<UserDTO> getAllUser();
}
