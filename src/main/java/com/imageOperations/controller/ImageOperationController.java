package com.imageOperations.controller;

import com.imageOperations.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class ImageOperationController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Long imageId = imageService.uploadImage(file);
            return ResponseEntity.ok("Image uploaded successfully with ID: " + imageId);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload the image: " + e.getMessage());
        }
    }

    @GetMapping("/resize/{id}")
    public ResponseEntity<String> resizeImage(@PathVariable Long id, @RequestParam int width, @RequestParam int height) {
        try {
            imageService.resizeImage(id, width, height);
            return ResponseEntity.ok("Image resized successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to resize the image: " + e.getMessage());
        }
    }

    @GetMapping("/crop/{id}")
    public ResponseEntity<String> cropImage(@PathVariable Long id,
                                            @RequestParam int x, @RequestParam int y,
                                            @RequestParam int width, @RequestParam int height) {
        imageService.cropImage(id, x, y, width, height);
        return ResponseEntity.ok("Image cropped successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        try {
            byte[] imageData = imageService.getImageById(id);
            return ResponseEntity.ok(imageData);
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

}
