package ru.timmson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorShould {

    @Test
    void returnPrimeFactorsAs1_whenArrangeIs1() throws NegativeInputNumberException {
        int arrange = 1;

        int result = Calculator.getPrimeFactors(arrange);

        assertEquals(1, result);
    }

    @Test
    void returnException_whenArrangeIsNegative() {
        int arrange = -1;


        assertThrows(NegativeInputNumberException.class, () -> Calculator.getPrimeFactors(arrange));
    }

    @Test
    void returnPrimeFactorsAs2_whenArrangeIs2() throws NegativeInputNumberException {
        int arrange = 2;

        int result = Calculator.getPrimeFactors(arrange);

        assertEquals(2, result);
    }
}
