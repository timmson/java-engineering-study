package ru.timmson.load;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;
import static ru.timmson.load.Converter.convert;

public class ConvertShould {

    private static Stream<Arguments> values() {
        return Stream.of(
                of(1, "I"),
                of(2, "II"),
                of(4, "IV"),
                of(5, "V"),
                of(6, "VI"),
                of(9, "IX"),
                of(10, "X"),
                of(11, "XI"),
                of(34, "XXXIV"),
                of(39, "XXXIX"),
                of(40, "XL"),
                of(41, "XLI"),
                of(45, "XLV"),
                of(49, "XLIX"),
                of(50, "L"),
                of(51, "LI")
        );
    }

    @ParameterizedTest
    @MethodSource("values")
    @DisplayName("return a when b is given")
    void return_a_when_b(Integer arrange, String expected) {
        var result = convert(arrange);

        assertEquals(expected, result);
    }

    @Test
    void throw_IndexOutOfBoundsException_when_101() {
        var arrange = 101;

        assertThrows(IndexOutOfBoundsException.class, () -> convert(arrange));

    }


}
