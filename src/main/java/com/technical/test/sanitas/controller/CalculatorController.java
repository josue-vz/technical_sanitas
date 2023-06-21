package com.technical.test.sanitas.controller;

import com.technical.test.sanitas.factory.CalculatorFactory;
import com.technical.test.sanitas.payload.RequestArithmeticOperationsDTO;
import com.technical.test.sanitas.service.ICalculator;
import com.technical.test.sanitas.vo.GeneralResponseVO;
import com.technical.test.sanitas.vo.OperatorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping("/v1/arithmeticOperations")
    public ResponseEntity<GeneralResponseVO> arithmeticOperations(RequestArithmeticOperationsDTO requestArithmeticOperationsDTO) {
        LOGGER.info("REQUEST {}", requestArithmeticOperationsDTO);

        if (!requestArithmeticOperationsDTO.isValidOperator()) {
            LOGGER.info("OPERATOR NOT FOUND: {}", requestArithmeticOperationsDTO.getOperator());
            return new ResponseEntity<>(new GeneralResponseVO(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), 0.0), HttpStatus.BAD_REQUEST);
        }

        ICalculator calculator = CalculatorFactory.getCalculator(requestArithmeticOperationsDTO.getOperatorEnum());
        return new ResponseEntity<>(new GeneralResponseVO(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), calculator.calculate(requestArithmeticOperationsDTO.getFirstValue(), requestArithmeticOperationsDTO.getSecondValue())), HttpStatus.OK);
    }
}
