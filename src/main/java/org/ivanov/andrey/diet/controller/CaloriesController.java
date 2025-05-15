package org.ivanov.andrey.diet.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.validator.constraints.Range;
import org.ivanov.andrey.diet.domain.calories.Activity;
import org.ivanov.andrey.diet.domain.calories.CalorieCalculator;
import org.ivanov.andrey.diet.domain.calories.Sex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calories")
@Validated
public class CaloriesController {

    private final CalorieCalculator calorieCalculator;

    @Autowired
    public CaloriesController(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    @GetMapping
    public CaloriesResponse getCalories(
            @RequestParam @Range(min = 20, max = 200, message = "{app.calories.weight.range.message}")
            BigDecimal weight,
            @RequestParam @Range(min = 130, max = 230, message = "{app.calories.height.range.message}")
            Integer height,
            @RequestParam @Range(min = 10, max = 100, message = "{app.calories.age.range.message}")
            Integer age,
            @RequestParam Activity activity,
            @RequestParam Sex sex) {

        BigDecimal calories = calorieCalculator.calculateCalories(weight, height, age, sex, activity);
        return new CaloriesResponse(calories);
    }
}