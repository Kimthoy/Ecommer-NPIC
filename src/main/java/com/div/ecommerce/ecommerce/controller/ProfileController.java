package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.dto.ProfileDTO;
import com.div.ecommerce.ecommerce.mapper.ProfileMapper;
import com.div.ecommerce.ecommerce.model.Profile;
import com.div.ecommerce.ecommerce.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    @Autowired
    private final   ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @PostMapping
    private ResponseEntity<?>savedProfile(@RequestBody ProfileDTO profileDTO){
        Profile savedProfile= ProfileMapper.INSTANCE.toProfileEntity(profileDTO);
        profileService.create(savedProfile);
        return ResponseEntity.ok(ProfileMapper.INSTANCE.toProfileDTOEntity(savedProfile));
    }
    @GetMapping("/")
    private ResponseEntity<?>getAll(){

        return ResponseEntity.ok(profileService.getAll());
    }
    @GetMapping("{id}")
    private ResponseEntity<?>getById(@PathVariable("id") Long id){
        Profile getById=profileService.getById(id);
        return ResponseEntity.ok(getById);
    }

}
