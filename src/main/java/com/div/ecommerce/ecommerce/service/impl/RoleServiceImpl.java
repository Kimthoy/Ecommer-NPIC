package com.div.ecommerce.ecommerce.service.impl;


import com.div.ecommerce.ecommerce.model.Role;
import com.div.ecommerce.ecommerce.model.User;
import com.div.ecommerce.ecommerce.repository.RoleRepository;
import com.div.ecommerce.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Long id, Role role) {
        Role updateRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found for this id :: " + id));
        updateRole.setRole_name(role.getRole_name());
        return roleRepository.save(updateRole);

    }


    @Override
    public Map<String, Boolean> delete(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found for this id :: " + id));
        roleRepository.delete(role);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public Role getById(Long id) {
        Role getRole=roleRepository.findById(id).orElseThrow(()->new RuntimeException("ID not found!"+id));
        return getRole;
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAllWithRoles();
    }

    @Override
    public Role getRoleDTOById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("ID not found !"+id));
    }


}
