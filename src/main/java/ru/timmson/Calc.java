package ru.timmson;

class Calc {
    public static double convert(double amount, double interestRate, int years) {
        return amount * Math.pow(1 + interestRate, years);
    }
}
