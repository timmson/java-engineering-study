package ru.timmson;

import jdk.jfr.Unsigned;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Inherited;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void returnArrange_whenFactorIsPrime() throws NegativeArraySizeException {
        int arrange = 2;

        int result = Calculator.getMinimalPrimeFactor(arrange);

        assertTrue(result == arrange);
    }

    @Test
    void returnLessThanArrange_whenFactorIsNotPrime() throws NegativeArraySizeException {
        int arrange = 6;

        int result = Calculator.getMinimalPrimeFactor(arrange);

        assertTrue(result < arrange);
    }

    @Test
    void returnPrimeFactorsAs2And2And3_whenArrangeIs12() throws NegativeInputNumberException {
        int arrange = 12;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{2, 2, 3}, result);
    }

    @Test
    void returnPrimeFactorsAs2And3_whenArrangeIs15() throws NegativeInputNumberException {
        int arrange = 15;

        int[] result = Calculator.getPrimeFactors(arrange);

        assertArrayEquals(new int[]{3, 5}, result);
    }
}
