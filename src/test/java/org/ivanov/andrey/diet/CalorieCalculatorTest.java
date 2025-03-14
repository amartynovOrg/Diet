package org.ivanov.andrey.diet;

import org.ivanov.andrey.diet.demain.calories.CalorieCalculator;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.ivanov.andrey.diet.demain.calories.Activity.EXTREME;
import static org.ivanov.andrey.diet.demain.calories.Activity.MINIMAL;
import static org.ivanov.andrey.diet.demain.calories.Sex.FEMALE;
import static org.ivanov.andrey.diet.demain.calories.Sex.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CalorieCalculatorTest {

    private final CalorieCalculator calculator = new CalorieCalculator();

    @Test
    void testCalculateCaloriesForMaleSedentary() {
        BigDecimal calories = calculator.calculateCalories(new BigDecimal("70"), 175, 30, MALE, MINIMAL);
        assertNotNull(calories);
        assertEquals(new BigDecimal("1978"), calories);
    }

    @Test
    void testCalculateCaloriesForFemaleActive() {
        BigDecimal calories = calculator.calculateCalories(new BigDecimal("50"), 165, 25, FEMALE, EXTREME);
        assertNotNull(calories);
        assertEquals(new BigDecimal("2365"), calories);
    }
}