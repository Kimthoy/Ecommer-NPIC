package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.UserDTO;
import com.div.ecommerce.ecommerce.model.User;
import com.div.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private  UserService userService;
//    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/roles/{roleId}")
    private User assignRoleToUser(@PathVariable Long userId, @PathVariable Long roleId) {
        return userService.assignRoleToUser(userId, roleId);
    }
    @PostMapping
    private ResponseEntity<?> createUser(@RequestBody User user) {

        return ResponseEntity.ok( userService.create(user));
    }
    // Get all users
    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
      return userService.getAllUser();
    }

    // Get user by ID
    @GetMapping("{id}")
    private ResponseEntity<?> getUserById(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }

    // Update user
    @PutMapping("{id}")
    private ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.update(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete user
    @DeleteMapping("{id}")
    private ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok( userService.delete(id));
    }

}
