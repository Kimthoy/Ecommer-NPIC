package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.dto.ImageResponse;
import com.div.ecommerce.ecommerce.model.Images;
import com.div.ecommerce.ecommerce.repository.ImagesRepository;
import com.div.ecommerce.ecommerce.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ImagesServiceImpl implements ImagesService {
    @Autowired
    private ImagesRepository imagesRepository;

    private final Path rootLocation = Paths.get("images");

    public ImagesServiceImpl() throws IOException {
        Files.createDirectories(rootLocation); // Create the directory if it doesn't exist
    }
    @Override
    public Images saveImage(MultipartFile file) throws IOException {
        String originalFileName = file.getOriginalFilename();
        String fileExtension = getFileExtension(originalFileName);
        String baseFileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'));

        // To overwrite the existing file
        // Path destinationFile = this.rootLocation.resolve(Paths.get(originalFileName)).normalize().toAbsolutePath();
        // Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

        // To rename the new file
        String newFileName = baseFileName + "-" + UUID.randomUUID().toString() + "." + fileExtension;
        Path destinationFile = this.rootLocation.resolve(Paths.get(newFileName)).normalize().toAbsolutePath();

        // To reject the upload if the file already exists
        // if (Files.exists(destinationFile)) {
        //     throw new IOException("File already exists");
        // }

        Files.copy(file.getInputStream(), destinationFile);

        Images image = new Images();
        // image.setFileName(fileName);
        image.setFileName(newFileName);
        image.setFileExtension(fileExtension);
        image.setFilePath(destinationFile.toString());
        return imagesRepository.save(image);
    }

    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return null;
        }
    }

    @Override
    public Images updateImage(Long id, MultipartFile file) throws IOException {
        Optional<Images> image = imagesRepository.findById(id);
        if (!image.isPresent()) {
            throw new IOException("Image not found");
        }

        Images existingImage = image.get();
        // Optional: delete the old file if you want to replace the image
        Files.deleteIfExists(Paths.get(existingImage.getFilePath()));
        String originalFileName = file.getOriginalFilename();
        String fileExtension = getFileExtension(originalFileName);
        String baseFileName = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
        String newFileName = baseFileName + "-" + UUID.randomUUID().toString() + "." + fileExtension;
        Path destinationFile = this.rootLocation.resolve(Paths.get(newFileName)).normalize().toAbsolutePath();
        Files.copy(file.getInputStream(), destinationFile);
        existingImage.setFileName(newFileName);
        existingImage.setFileExtension(fileExtension);
        existingImage.setFilePath(destinationFile.toString());

        return imagesRepository.save(existingImage);
    }

    @Override
    public void deleteImage(Long id) throws IOException {
        Optional<Images> image = imagesRepository.findById(id);
        if (!image.isPresent()) {
            throw new IOException("Image not found");
        }

        Images images = image.get();
        // Delete the image file from the file system
        Files.deleteIfExists(Paths.get(images.getFilePath()));
        // Delete the image metadata from the database
        imagesRepository.delete(images);
    }

    @Override
    public Optional<Images> getImage(Long id) {
        return imagesRepository.findById(id);
    }

    @Override
    public Object getImageMetadataAndContent(Images image) throws IOException {
        Path imagePath = Path.of(image.getFilePath());
        byte[] imageBytes = Files.readAllBytes(imagePath);
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);

        // Return metadata and base64 content
        return new ImageResponse(image.getId(), image.getFileName(), image.getFileExtension(), base64Image);
    }

    @Override
    public List<Images> getAllImages() {
        return imagesRepository.findAll();
    }

    @Override
    public List<Object> getAllImagesWithMetadataAndContent() throws IOException {
        List<Images> images = imagesRepository.findAll();

        return images.stream()
                .map(image -> {
                    try {
                        return getImageMetadataAndContent(image);
                    } catch (IOException e) {
                        throw new RuntimeException("Error encoding image", e);
                    }
                })
                .collect(Collectors.toList());
    }
}
