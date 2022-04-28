package com.invo.matchela.core.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import java.util.List;

public class MatchResponse {

    private static final String SUCCESS = "SUCCESS";


    public static ResponseEntity<RestResponseDto> successResponse(Object o) {
        RestResponseDto r = new RestResponseDto();
        r.setDetail(o);
        r.setMessage(SUCCESS);
        r.setCode(HttpStatus.OK.value());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    public static ResponseEntity<RestResponseDto> successResponseStatus(Object o, HttpStatus httpStatus) {
        RestResponseDto r = new RestResponseDto();
        r.setDetail(o);
        r.setMessage(SUCCESS);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }

    public static ResponseEntity<RestResponseDto> successResponseStatusWithMessage(Object o, String message, HttpStatus httpStatus) {
        RestResponseDto r = new RestResponseDto();
        r.setDetail(o);
        r.setMessage(message);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }

    public static ResponseEntity<RestResponseDto> validationFailed(List<ObjectError> errors) {
        RestResponseDto r = new RestResponseDto();
        r.setDetail(errors);
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<RestResponseDto> failResponseBadRequest(String message) {
        RestResponseDto r = new RestResponseDto();
        r.setMessage(message);
        r.setCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<RestResponseDto> failResponseWithStatus(HttpStatus httpStatus, String message) {
        RestResponseDto r = new RestResponseDto();
        r.setMessage(message);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }

    public static ResponseEntity<RestResponseDto> failResponseWithStatusAndBody(HttpStatus httpStatus, String message, Object body) {
        RestResponseDto r = new RestResponseDto();
        r.setMessage(message);
        r.setDetail(body);
        r.setCode(httpStatus.value());
        return new ResponseEntity<>(r, httpStatus);
    }
}
