package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.model.Image;
import com.div.ecommerce.ecommerce.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Autowired
    private final ImageService imageService;
    private static final Logger log = LoggerFactory.getLogger(ImageController.class);

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            log.info("Received file: {}", file.getOriginalFilename()); // Log the file name
            int image = imageService.saveImage(file); // Debug this method
            return new ResponseEntity<>("Image uploaded successfully: " + image, HttpStatus.OK);
        } catch (IOException e) {
            log.error("Error uploading image", e); // Log the full error
            return new ResponseEntity<>("An error occurred while uploading the image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getImage/{id}")
    public Image getImageById(@PathVariable("id") Long id) {
        return imageService.getImage(id);
    }

}
