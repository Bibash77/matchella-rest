package com.invo.matchela.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;*/
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestResponseDto {

    private String message;

    private Object detail;

    private final LocalDateTime timestamp = LocalDateTime.now();

    private int code;




}
