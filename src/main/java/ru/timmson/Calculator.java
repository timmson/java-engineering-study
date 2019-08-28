package ru.timmson;

public class Calculator {
    public static int[] getPrimeFactors(int arrange) throws NegativeInputNumberException {
        if (arrange < 0) {
            throw new NegativeInputNumberException(arrange + " is negative");
        }
        return new int[]{arrange};
    }
}
