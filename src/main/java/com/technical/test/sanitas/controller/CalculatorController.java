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
            LOGGER.info("OPERATOR {} NOT FOUND", requestArithmeticOperationsDTO.getOperator());
            return GeneralResponseVO.builder().status(HttpStatus.BAD_REQUEST.value()).message(HttpStatus.BAD_REQUEST.getReasonPhrase()).data(-1).build().badRequest();
        }

        ICalculator calculator = CalculatorFactory.getCalculator(requestArithmeticOperationsDTO.getOperatorEnum());
        double result = calculator.calculate(requestArithmeticOperationsDTO.getFirstValue(), requestArithmeticOperationsDTO.getSecondValue());

        return GeneralResponseVO.builder().status(HttpStatus.OK.value()).message(HttpStatus.OK.getReasonPhrase()).data(result).build().success();
    }
}
