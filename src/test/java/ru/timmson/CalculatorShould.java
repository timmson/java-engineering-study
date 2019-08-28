package ru.timmson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorShould {

    @Test
    void returnPrimeFactorsAs1_whenArrangeIs1() throws NegativeInputNumberException {
        int arrange = 1;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{1}, result);
    }

    @Test
    void returnException_whenArrangeIsNegative() {
        int arrange = -1;


        assertThrows(NegativeInputNumberException.class, () -> Calculator.getPrimeFactors(arrange));
    }

    @Test
    void returnPrimeFactorsAs2_whenArrangeIs2() throws NegativeInputNumberException {
        int arrange = 2;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{2}, result);
    }

    @Test
    void returnPrimeFactorsAs2And2_whenArrangeIs4() throws NegativeInputNumberException {
        int arrange = 4;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{2, 2}, result);
    }

    @Test
    void returnPrimeFactorsAs2And3_whenArrangeIs6() throws NegativeInputNumberException {
        int arrange = 6;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{2, 3}, result);
    }

}
