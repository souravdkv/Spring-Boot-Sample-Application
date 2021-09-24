package com.example.image.service.impl;

import com.example.image.exception.model.ErrorCode;
import com.example.image.model.ImageModel;
import com.example.image.service.ImageService;
import com.example.image.util.ImageData;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImageServiceImpl implements ImageService {
    @Override
    public ImageModel getImageByHeadline(String headline) {
        ImageModel imageModel = null;
        if (StringUtils.equalsIgnoreCase(headline, ImageData.KKR_HEADLINE)) {
            imageModel = ImageModel.builder().imageUrl(ImageData.KKR_IMAGE_LINK).headline(ImageData.KKR_HEADLINE).build();
        } else if (StringUtils.equalsIgnoreCase(headline, ImageData.RCB_HEADLINE)) {
            imageModel = ImageModel.builder().imageUrl(ImageData.RCB_IMAGE_LINK).headline(ImageData.RCB_HEADLINE).build();
        } else if (StringUtils.equalsIgnoreCase(headline, ImageData.LEXION_HEADLINE)) {
            imageModel = ImageModel.builder().imageUrl(ImageData.LEXION_IMAGE_LINK).headline(ImageData.LEXION_HEADLINE).build();
        } else {
            throw ErrorCode.ERR_NOT_FOUND.getException("The Image not Found.");
        }

        return imageModel;
    }

    @Override
    public List<ImageModel> getAllImage() {
        List<ImageModel> imageModels = new ArrayList<>();
        imageModels.add(ImageModel.builder().imageUrl(ImageData.KKR_IMAGE_LINK).headline(ImageData.KKR_HEADLINE).build());
        imageModels.add(ImageModel.builder().imageUrl(ImageData.RCB_IMAGE_LINK).headline(ImageData.RCB_HEADLINE).build());
        imageModels.add(ImageModel.builder().imageUrl(ImageData.LEXION_IMAGE_LINK).headline(ImageData.LEXION_HEADLINE).build());
        return imageModels;
    }

    @Override
    public void testException(String errorCode) {
        if (StringUtils.equals(errorCode, ErrorCode.ERR_INPUT_VALIDATION.name())) {
            throw ErrorCode.ERR_INPUT_VALIDATION.getException("Please provide a valid Input.");
        } else if (StringUtils.equals(errorCode, ErrorCode.ERR_NOT_FOUND.name())) {
            throw ErrorCode.ERR_NOT_FOUND.getException("The Image not Found.");
        } else {
            throw ErrorCode.ERR_TECHNICINAL.getException("Something went wrong, Please contact the admin !!");
        }
    }
}
