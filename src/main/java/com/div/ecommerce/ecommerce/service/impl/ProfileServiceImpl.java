package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Brand;
import com.div.ecommerce.ecommerce.model.Profile;
import com.div.ecommerce.ecommerce.model.User;
import com.div.ecommerce.ecommerce.repository.ProfileRepository;
import com.div.ecommerce.ecommerce.repository.UserRepository;
import com.div.ecommerce.ecommerce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository,
                              UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Long id, Profile updateProfile) {
        Profile profile=profileRepository.getById(id);
        profile.setProfileName(updateProfile.getProfileName());
        profile.setProfileImage(updateProfile.getProfileImage());
        profile.setEmail(updateProfile.getEmail());
        profile.setPhoneNumber(updateProfile.getPhoneNumber());
        profile.setAddress(updateProfile.getAddress());
        if (profile.getUser() != null && profile.getUser().getId() != null) {
            User user = userRepository.findById(profile.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("Brand not found with id " + profile.getUser().getId()));
            profile.setUser(user);
        }
        return profileRepository.save(profile);
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElseThrow(()->new RuntimeException("Profile ID not found"+id));
    }

    @Override
    public Profile delete(Long id) {
        Profile deleteProfile=profileRepository.getById(id);
        profileRepository.delete(deleteProfile);
        return deleteProfile;
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }
}
