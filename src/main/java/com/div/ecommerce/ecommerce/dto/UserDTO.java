package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.Role;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private String phone;
    private String address;
    private Boolean is_active;  // Default value is true
    private Timestamp create_at;
    private Set<String> roles;

}
