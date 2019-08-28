package ru.timmson;

public class Calculator {
    public static int[] getPrimeFactors(int arrange) throws NegativeInputNumberException {
        if (arrange < 0) {
            throw new NegativeInputNumberException(arrange + " is negative");
        }

        int remainder = arrange;
        int minimalPrimeFactor = getMinimalPrimeFactor(remainder);
        int[] result = pushValue(new int[]{}, minimalPrimeFactor);

        while (minimalPrimeFactor < remainder) {
            remainder = remainder / minimalPrimeFactor;
            minimalPrimeFactor = getMinimalPrimeFactor(remainder);
            result = pushValue(result, minimalPrimeFactor);
        }

        return result;
    }

    private static int[] pushValue(int[] array, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = value;
        return newArray;
    }

    public static int getMinimalPrimeFactor(int arrange) {
        for (int i = 2; i < arrange; i++) {
            if (arrange % i == 0) {
                return i;
            }
        }
        return arrange;
    }
}
