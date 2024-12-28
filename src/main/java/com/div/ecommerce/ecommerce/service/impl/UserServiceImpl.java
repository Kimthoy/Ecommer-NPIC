package com.div.ecommerce.ecommerce.service.impl;


import com.div.ecommerce.ecommerce.configuration.PasswordEncoderConfig;
import com.div.ecommerce.ecommerce.dto.RoleDTO;
import com.div.ecommerce.ecommerce.dto.UserDTO;
import com.div.ecommerce.ecommerce.exception.ResourceNotFoundException;
import com.div.ecommerce.ecommerce.model.Role;
import com.div.ecommerce.ecommerce.model.User;
import com.div.ecommerce.ecommerce.repository.RoleRepository;
import com.div.ecommerce.ecommerce.repository.UserRepository;
import com.div.ecommerce.ecommerce.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final RoleRepository roleRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    public User authenticateUser(String name, String rawPassword) {
        User user = userRepository.findByUsername(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Compare the raw password with the stored hashed password
        if (passwordEncoder.matches(rawPassword, user.getPassword())) {
            return user; // Password is valid
        } else {
            throw new BadCredentialsException("Invalid password");
        }
    }


    public User create(User user) {
        // Encrypt password before saving
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        return userRepository.save(user);
    }


    @Override
    public User update(Long id, User user) {
        User updateUser = getById(id);

        updateUser.setName(user.getName());
        updateUser.setPhone(user.getPhone());
        updateUser.setAddress(user.getAddress());
        updateUser.setIs_active(user.getIs_active());
        updateUser.setCreate_at(user.getCreate_at());
        updateUser.setRoles(user.getRoles());

        // Encode the password only if it has been provided
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(user.getPassword());
            updateUser.setPassword(encodedPassword);
        }

        return userRepository.save(updateUser);
    }


    private String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);  // Encoding the password using BCrypt
    }

    @Override
    public User delete(Long id) {
        User deleteUser=getById(id);
        userRepository.delete(deleteUser);
        return deleteUser;
    }

    @Override
    public User getById(Long id) {
        User getUser=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("ID not found!"));
        return getUser;
    }

    @Override
    public User assignRoleToUser(Long userId, Long roleId) {
        // Retrieve the user and role entities
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found for this id :: " + userId));
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found for this id :: " + roleId));

        // Initialize the roles collection if it is lazy-loaded
        user.getRoles().size(); // Ensure roles are loaded

        // Check if the role is already assigned to avoid redundant operations
        if (!user.getRoles().contains(role)) {
            user.getRoles().add(role); // Add the role
        }

        // Save the user entity
        return userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUser() {
        return userRepository.findAllWithRoles().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private UserDTO convertToDTO(User user) {
        // Create a new UserDTO object
        UserDTO userDTO = new UserDTO();

        // Map basic fields from User to UserDTO
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());
        userDTO.setIs_active(user.getIs_active());
        userDTO.setCreate_at(user.getCreate_at());


        // Create a defensive copy of roles to avoid ConcurrentModificationException
        Set<Role> roles = new HashSet<>(user.getRoles());
        Set<String> roleNames = roles.stream()
                .map(Role::getRole_name) // Extract role names
                .collect(Collectors.toSet());
        userDTO.setRoles(roleNames);
        return userDTO;
    }








}
