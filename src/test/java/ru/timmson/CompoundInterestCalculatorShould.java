package ru.timmson;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompoundInterestCalculatorShould {

    @Test
    void giveRevenueByOneYear() {
        final var amount = 1000.0;
        final var interestRate = 0.05;
        final var years = 1;

        final double revenue = Calc.convert(amount, interestRate, years);

        assertEquals(1050.0, revenue);
    }

    @Test
    void giveRevenueByTwoYear() {
        final var amount = 1000.0;
        final var interestRate = 0.05;
        final var years = 2;

        final double revenue = Calc.convert(amount, interestRate, years);

        assertEquals(1102.5, revenue);
    }

}
