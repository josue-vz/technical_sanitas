package com.technical.test.sanitas.service.impl;

import com.technical.test.sanitas.service.ICalculator;

import java.text.DecimalFormat;

public class Subtract implements ICalculator {
    @Override
    public double calculate(double firstValue, double secondValue) {
        return firstValue - secondValue;
    }
}
