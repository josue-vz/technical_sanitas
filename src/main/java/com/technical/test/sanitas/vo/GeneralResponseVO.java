package com.technical.test.sanitas.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
public class GeneralResponseVO {
    private int status;
    private String message;
    private double data;
}
