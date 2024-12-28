package com.div.ecommerce.ecommerce.dto;

import com.div.ecommerce.ecommerce.model.User;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDTO {
    private Long id;
    private String role_name;
    private Set<UserDTO> users = new HashSet<>();


    public RoleDTO(Long id, String roleName) {
        this.id=id;
        this.role_name=roleName;
    }
}
