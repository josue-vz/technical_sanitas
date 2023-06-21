package com.technical.test.sanitas.vo;

import com.technical.test.sanitas.service.ICalculator;
import com.technical.test.sanitas.service.impl.Add;
import com.technical.test.sanitas.service.impl.Divide;
import com.technical.test.sanitas.service.impl.Multiply;
import com.technical.test.sanitas.service.impl.Subtract;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

public class OperatorFactory {

    private static OperatorFactory operatorFactory = null;

    private static Map<OperatorEnum, ICalculator> calculatorMap = Map.of(
            OperatorEnum.ADD, new Add(),
            OperatorEnum.SUBTRACT, new Subtract(),
            OperatorEnum.MULTIPLY, new Multiply(),
            OperatorEnum.DIVIDE, new Divide()
    );

    public static synchronized OperatorFactory getInstance() {
        return operatorFactory == null ? new OperatorFactory(): operatorFactory;
    }

    public ICalculator getOperatorMethod(OperatorEnum operatorEnum) {
        return calculatorMap.get(operatorEnum);
    }
}
