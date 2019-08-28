package ru.timmson;

public class Calculator {
    public static int[] getPrimeFactors(int arrange) throws NegativeInputNumberException {
        if (arrange < 0) {
            throw new NegativeInputNumberException(arrange + " is negative");
        }

        int[] result = new int[0];

        for (int primeFactor = 2; primeFactor <= arrange / 2; primeFactor++) {
            if (arrange % primeFactor == 0) {

                boolean isPrimFactorSquareRootOfArrange = (primeFactor * primeFactor == arrange);

                int[] tmp = new int[result.length + (isPrimFactorSquareRootOfArrange ? 2 : 1)];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                result = tmp;

                if (isPrimFactorSquareRootOfArrange) {
                    result[result.length - 2] = primeFactor;
                }
                result[result.length - 1] = primeFactor;
            }
        }

        result = result.length == 0 ? new int[]{arrange} : result;

        return result;
    }

    public static boolean isFactorPrime(int arrange) {
        return arrange == 2;
    }
}
