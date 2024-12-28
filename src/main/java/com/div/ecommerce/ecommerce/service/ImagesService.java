package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Images;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface ImagesService {
    Images saveImage(MultipartFile file) throws IOException;
    Images updateImage(Long id, MultipartFile file) throws IOException;
    void deleteImage(Long id) throws IOException;
    Optional<Images> getImage(Long id);
    Object getImageMetadataAndContent(Images image) throws IOException;
    List<Images> getAllImages();
    List<Object> getAllImagesWithMetadataAndContent() throws IOException;
}
