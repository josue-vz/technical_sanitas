package com.technical.test.sanitas.factory;

import com.technical.test.sanitas.service.ICalculator;
import com.technical.test.sanitas.vo.OperatorEnum;
import com.technical.test.sanitas.vo.OperatorFactory;

public class CalculatorFactory {

    public static ICalculator getCalculator(OperatorEnum operator) {
        return OperatorFactory.getInstance().getOperatorMethod(operator);
    }
}
