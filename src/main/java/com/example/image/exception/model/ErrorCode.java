package com.example.image.exception.model;

public enum ErrorCode {
    ERR_TECHNICINAL,
    ERR_NOT_FOUND,
    ERR_INPUT_VALIDATION;

    private String getCode() {
        return name();
    }

    public ImageException getException(String message) {
        return new ImageException(message, getCode());
    }
}