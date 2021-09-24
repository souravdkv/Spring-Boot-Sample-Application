package com.example.image.service;

import com.example.image.model.ImageModel;

import java.util.List;

public interface ImageService {
    ImageModel getImageByHeadline(String headline);

    List<ImageModel> getAllImage();

    void testException(String errorCode);
}
