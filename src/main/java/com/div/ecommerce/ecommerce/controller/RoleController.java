package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.RoleDTO;
import com.div.ecommerce.ecommerce.model.Role;
import com.div.ecommerce.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @PostMapping("/addRole")
    private ResponseEntity<?>createRole(@RequestBody Role role){
       roleService.create(role);
        return ResponseEntity.ok().body(role);
    }
    @PutMapping("/updateRole/{id}")
    private ResponseEntity<?>update(@PathVariable Long id,@RequestBody Role roleDetails){
        Role updatedRole=roleService.update(id,roleDetails);
        return ResponseEntity.ok().body(updatedRole);
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){
        return ResponseEntity.ok( roleService.getAll());
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable Long id){
        Role getRoleById=roleService.getById(id);
        return ResponseEntity.ok(getRoleById);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<Map<String, Boolean>>delete(@PathVariable Long id){
        Map<String, Boolean> response = roleService.delete(id);
        return ResponseEntity.ok(response);
    }

}
