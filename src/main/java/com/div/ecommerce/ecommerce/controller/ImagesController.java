package com.div.ecommerce.ecommerce.controller;

import com.div.ecommerce.ecommerce.model.ApiResponse;
import com.div.ecommerce.ecommerce.model.Images;
import com.div.ecommerce.ecommerce.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/images")
public class ImagesController {
    @Autowired
    private final ImagesService imagesService;

    public ImagesController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,@RequestParam("product_id") Long id) throws IOException {
        System.out.println("Product id:"+id);
        Images image = imagesService.saveImage(file);
        return new ResponseEntity<>("Image saved with ID: " + image.getId(), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadImages(@PathVariable Long id) {
        return imagesService.getImage(id)
                .map(image -> {
                    Path imagePath = Paths.get(image.getFilePath());
                    byte[] imageBytes;
                    try {
                        imageBytes = Files.readAllBytes(imagePath);
                    } catch (IOException e) {
                        return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
                    }

                    HttpHeaders headers = new HttpHeaders();
                    headers.add(HttpHeaders.CONTENT_TYPE, "image/" + image.getFileExtension());
                    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"");
                    return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getImage(@PathVariable Long id) {
        return imagesService.getImage(id)
                .map(image -> {
                    Path imagePath = Paths.get(image.getFilePath());
                    byte[] imageBytes;
                    try {
                        imageBytes = Files.readAllBytes(imagePath);
                    } catch (IOException e) {
                        return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
                    }

                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                    Map<String, Object> response = new HashMap<>();
                    response.put("id", image.getId());
                    response.put("name", image.getFileName());
                    response.put("extension", image.getFileExtension());
                    response.put("image", base64Image);

                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update image metadata and content
    @PutMapping("/{id}")
    public ResponseEntity<String> updateImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            Images updatedImage = imagesService.updateImage(id, file);
            return new ResponseEntity<>("Image updated with ID: " + updatedImage.getId(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Could not update image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Delete image by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable Long id) {
        try {
            imagesService.deleteImage(id);
            return new ResponseEntity<>("Image deleted with ID: " + id, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Could not delete image: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getAllImages() {
        try {
            List<Images> images = imagesService.getAllImages();
            if (images.isEmpty()) {
                return new ResponseEntity<>(new ApiResponse(false, "No images found", null), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new ApiResponse(true, "Images retrieved successfully", images), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, "Error retrieving images: " + e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
