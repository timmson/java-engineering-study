package ru.timmson.load;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RCalcShould {

    @Test
    @DisplayName("return `III` when three forms are given")
    void return_III_when_three_forms() {
        var result = new RomanNumber(1).add("I").add(1);

        assertEquals("III", result.toString());
    }

    @Test
    @DisplayName("return `II` when three forms are given")
    void return_II_when_three_forms() {
        var result = new RomanNumber("IV").subtract("I").subtract(1);

        assertEquals("II", result.toString());
    }

    @Test
    @DisplayName("return `` when `I` and `I` are given")
    void return___when_I_and_I() {
        var a = new RomanNumber(1);
        var b = new RomanNumber(1);

        var result = a.subtract(b);

        assertEquals("", result.toString());
    }

    @Test
    @DisplayName("return `XXV` when `XI` and `XIV` are given")
    void return_XXV_when_XI_and_XIV() {
        var a = new RomanNumber(11);
        var b = new RomanNumber(14);

        var result = a.add(b);

        assertEquals("XXV", result.toString());
    }

    @Test
    @DisplayName("return `XXV` when `XI` and `XIV` are given")
    void return_XXV1_when_XI_and_XIV() {
        var a = new RomanNumber("XXXXX");
        var b = new RomanNumber(14);

        var result = a.add(b);

        assertEquals("XXV", result.toString());
    }

}
