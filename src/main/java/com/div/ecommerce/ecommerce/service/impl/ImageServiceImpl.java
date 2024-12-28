package com.div.ecommerce.ecommerce.service.impl;

import com.div.ecommerce.ecommerce.model.Image;
import com.div.ecommerce.ecommerce.repository.ImageRepository;
import com.div.ecommerce.ecommerce.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    private static final Logger logger = LoggerFactory.getLogger(ImageServiceImpl.class);

    @Override
    public int saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setData(file.getBytes());
        // return imageRepository.save(image);
        imageRepository.insertImage(image.getName(), image.getData());
        return 0;
    }

    @Override
    public Image getImage(Long id) {
        Image image = imageRepository.findImageById(id);
        logger.info("Retrieved image: {}", image.getName());
        return image;
    }
}


