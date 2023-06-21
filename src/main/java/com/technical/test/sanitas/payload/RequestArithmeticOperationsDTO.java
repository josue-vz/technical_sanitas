package com.technical.test.sanitas.payload;

import com.technical.test.sanitas.vo.OperatorEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Optional;

@Data
@NoArgsConstructor
@ToString
public class RequestArithmeticOperationsDTO {
    private double firstValue;
    private double secondValue;
    private int operator;

    public boolean isValidOperator() {
        Optional<OperatorEnum> optionalOperatorEnum = OperatorEnum.findValue(this.operator);
        return optionalOperatorEnum.isPresent();
    }

    public OperatorEnum getOperatorEnum() {
        return OperatorEnum.findValue(this.operator).get();
    }
}
