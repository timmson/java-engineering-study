package ru.timmson.load;

import java.util.function.Function;

import static java.util.Optional.ofNullable;
import static ru.timmson.load.Converter.checkIfValidNumber;
import static ru.timmson.load.Converter.convert;

class RomanNumber {

    public static RomanNumber ZERO = new RomanNumber("");

    int number;

    public RomanNumber(int number) {
        checkIfValidNumber(number);
        this.number = number;
    }

    public RomanNumber(String number) {
        this.number = 0;//convert(number);
    }

    private int getNumber() {
        return number;
    }

    protected RomanNumber f(String number, Function<Integer, RomanNumber> f) {
        return f(ofNullable(number).map(RomanNumber::new).orElse(ZERO), f);
    }

    protected RomanNumber f(RomanNumber number, Function<Integer, RomanNumber> f) {
        return ofNullable(number).map(RomanNumber::getNumber).map(f).orElse(this);
    }

    public RomanNumber add(int number) {
        return new RomanNumber(this.number + number);
    }

    public RomanNumber add(String number) {
        return f(number, this::add);
    }

    public RomanNumber add(RomanNumber number) {
        return f(number, this::add);
    }

    public RomanNumber subtract(int number) {
        return new RomanNumber(this.number - number);
    }

    public RomanNumber subtract(String number) {
        return f(number, this::subtract);
    }

    public RomanNumber subtract(RomanNumber number) {
        return f(number, this::subtract);
    }

    @Override
    public String toString() {
        return convert(number);
    }
}
