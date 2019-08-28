package ru.timmson;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorShould {

    @Test
    public void returnPrimeFactorsAs1_whenArrangeIs1() {
        int arrange = 1;

        int result = Calculator.getPrimeFactors(arrange);

        assertEquals(1, result);
    }

}
