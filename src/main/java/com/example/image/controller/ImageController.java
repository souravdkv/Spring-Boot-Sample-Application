package com.example.image.controller;

import com.example.image.model.ImageModel;
import com.example.image.model.ImageRequest;
import com.example.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public ResponseEntity<ImageModel> getImageByHeadline(@RequestBody ImageRequest imageRequest) {
        return new ResponseEntity<>(imageService.getImageByHeadline(imageRequest.getHeadline()), HttpStatus.OK);
    }

    @GetMapping("/image")
    public ResponseEntity<List<ImageModel>> getAllImage() {
        return new ResponseEntity<>(imageService.getAllImage(), HttpStatus.OK);
    }

    @GetMapping("/image/exception")
    public ResponseEntity<Void> testException(@RequestParam String errorCode) {
        imageService.testException(errorCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}