package org.ivanov.andrey.diet.demain.calories;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.RoundingMode.FLOOR;

@Component
public class CalorieCalculator {

    private static final BigDecimal WEIGHT_COEFFICIENT = new BigDecimal("10");
    private static final BigDecimal HEIGHT_COEFFICIENT = new BigDecimal("6.25");
    private static final BigDecimal AGE_COEFFICIENT = new BigDecimal("5");

    public BigDecimal calculateCalories(BigDecimal weight, Integer height, Integer age, Sex sex, Activity activity) {

        BigDecimal cWaight = weight.multiply(WEIGHT_COEFFICIENT);
        BigDecimal cHeight = BigDecimal.valueOf(height).multiply(HEIGHT_COEFFICIENT);
        BigDecimal cAge = BigDecimal.valueOf(age).multiply(AGE_COEFFICIENT);

        return cWaight.add(cHeight).subtract(cAge)
                .add(sex.getCoefficient())
                .multiply(activity.getFactor()).setScale(0, FLOOR);
    }
}