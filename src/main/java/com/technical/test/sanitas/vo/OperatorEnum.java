package com.technical.test.sanitas.vo;

import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
public enum OperatorEnum {
    ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);

    private final int value;

    OperatorEnum(int value) {
        this.value = value;
    }

    public static Optional<OperatorEnum> findValue(int value) {
        return Arrays.stream(values())
                .filter(operatorEnum -> operatorEnum.value == value)
                .findFirst();
    }
}
