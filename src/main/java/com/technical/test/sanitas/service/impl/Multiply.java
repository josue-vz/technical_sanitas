package com.technical.test.sanitas.service.impl;

import com.technical.test.sanitas.service.ICalculator;

public class Multiply implements ICalculator {
    @Override
    public double calculate(double firstValue, double secondValue) {
        return firstValue * secondValue;
    }
}
