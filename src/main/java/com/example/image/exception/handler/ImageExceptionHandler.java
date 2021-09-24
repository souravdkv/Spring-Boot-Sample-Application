package com.example.image.exception.handler;

import com.example.image.exception.model.ErrorCode;
import com.example.image.exception.model.ErrorInfo;
import com.example.image.exception.model.ImageException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ImageExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleImageException(Exception e) {

        if (e instanceof ImageException) {
            ImageException imageException = (ImageException) e;
            if (StringUtils.equals(imageException.getErrorCode(), ErrorCode.ERR_INPUT_VALIDATION.name())) {
                return new ResponseEntity<>(ErrorInfo.builder()
                        .status(HttpStatus.BAD_REQUEST)
                        .errorCode(ErrorCode.ERR_INPUT_VALIDATION.name())
                        .errorMessage(imageException.getMessage())
                        .timeStamp(new Date())
                        .build()
                        , HttpStatus.BAD_REQUEST);
            } else if (StringUtils.equals(imageException.getErrorCode(), ErrorCode.ERR_NOT_FOUND.name())) {
                return new ResponseEntity<>(ErrorInfo.builder()
                        .status(HttpStatus.NOT_FOUND)
                        .errorCode(ErrorCode.ERR_NOT_FOUND.name())
                        .errorMessage(imageException.getMessage())
                        .timeStamp(new Date())
                        .build()
                        , HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(ErrorInfo.builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorCode(ErrorCode.ERR_TECHNICINAL.name())
                        .errorMessage("Something went wrong, Please contact the admin !!")
                        .timeStamp(new Date())
                        .build()
                        , HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(ErrorInfo.builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .errorCode(ErrorCode.ERR_TECHNICINAL.name())
                    .errorMessage("Something went wrong, Please contact the admin !!")
                    .timeStamp(new Date())
                    .build()
                    , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}