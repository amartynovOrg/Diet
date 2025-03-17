package org.ivanov.andrey.diet.domain.calories;

import java.math.BigDecimal;

public enum Sex {
    MALE(new BigDecimal("5")),
    FEMALE(new BigDecimal("-161"));

    private final BigDecimal coefficient;

    Sex(BigDecimal coefficient) {
        this.coefficient = coefficient;
    }
    public BigDecimal getCoefficient() {
        return coefficient;
    }
}
