package com.imageOperations.service;

import com.imageOperations.entity.ImageEntity;
import com.imageOperations.exception.RequestFailedException;
import com.imageOperations.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Long uploadImage(MultipartFile file) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageName(file.getOriginalFilename());
        imageEntity.setImageData(file.getBytes());
        imageRepository.save(imageEntity);
        return imageEntity.getId();
    }

    public void resizeImage(Long id, int width, int height) throws IOException {
        Optional<Object> imageEntity = imageRepository.findById(id);

        //image resizing logic
    }

    public void cropImage(Long id, int x, int y, int width, int height){
        Optional<Object> imageEntity = imageRepository.findById(id);

        //image cropping logic
    }

    public byte[] getImageById(Long id) {
        ImageEntity imageEntity = (ImageEntity) imageRepository.findById(id)
                .orElseThrow(() -> new RequestFailedException("Image not found with ID: " + id));

        return imageEntity.getImageData();
    }
}
