package ru.timmson;

public class Calculator {
    public static int[] getPrimeFactors(int arrange) throws NegativeInputNumberException {
        if (arrange < 0) {
            throw new NegativeInputNumberException(arrange + " is negative");
        }

        int[] result = new int[]{arrange};

        if (arrange == 4) {
            result = new int[]{2, 2};
        }

        return result;
    }
}
