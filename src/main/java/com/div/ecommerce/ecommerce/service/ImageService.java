package com.div.ecommerce.ecommerce.service;

import com.div.ecommerce.ecommerce.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImageService {
    int saveImage(MultipartFile file) throws IOException;
    Image getImage(Long id);
}
