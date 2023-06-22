package com.technical.test.sanitas.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@Builder
public class GeneralResponseVO {
    private int status;
    private String message;
    private double data;

    public ResponseEntity<GeneralResponseVO> success() {
        return new ResponseEntity<>(this, HttpStatus.OK);
    }

    public ResponseEntity<GeneralResponseVO> badRequest() {
        return new ResponseEntity<>(this, HttpStatus.BAD_REQUEST);
    }
}
