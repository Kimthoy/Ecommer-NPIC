package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    Profile create(Profile profile);
    Profile update(Long id, Profile updateProfile);
    Profile getById(Long id);
    Profile delete(Long id);
    List<Profile> getAll();
}
