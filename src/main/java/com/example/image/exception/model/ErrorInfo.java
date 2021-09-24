package com.example.image.exception.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorInfo {
    private HttpStatus status;
    private String errorCode;
    private String errorMessage;
    private Date timeStamp;
}