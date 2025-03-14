package org.ivanov.andrey.diet.demain.calories;

import java.math.BigDecimal;

public enum Activity {
    MINIMAL(new BigDecimal("1.2")),
    WEAK(new BigDecimal("1.375")),
    MEDIUM(new BigDecimal("1.55")),
    HIGH(new BigDecimal("1.725")),
    EXTREME(new BigDecimal("1.9"));

    private final BigDecimal factor;

    Activity(BigDecimal factor) {
        this.factor = factor;
    }

    public BigDecimal getFactor() {
        return factor;
    }
}