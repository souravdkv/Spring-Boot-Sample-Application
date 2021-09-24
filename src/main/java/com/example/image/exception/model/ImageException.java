package com.example.image.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageException extends RuntimeException {
    private final String message;
    private final String errorCode;
}