package ru.timmson.algorithms;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergerSortShould {

    @Test
    void sortIntArrayOfOneNumbers() {
        var n = new int[]{1};

        MergeSort.sort(n);

        assertArrayEquals(new int[]{1}, n);
    }

    @Test
    void sortIntArrayOfTwoNumbers() {
        var n = new int[]{2, 1};

        MergeSort.sort(n);

        assertArrayEquals(new int[]{1, 2}, n);
    }

    @Test
    void sortIntArrayOfThreeNumbers() {
        var n = new int[]{2, 3, 1};

        MergeSort.sort(n);

        assertArrayEquals(new int[]{1, 2, 3}, n);
    }

    @Test
    void sortIntArrayOfFiveNumbers() {
        var n = new int[]{2, 3, 1, 2, 1};

        MergeSort.sort(n);

        assertArrayEquals(new int[]{1, 1, 2, 2, 3}, n, IntStream.of(n).boxed().collect(toList()).toString());
    }

    @Test
    void sortIntArrayOfTwentyNumbers() {
        var n = new int[]{35, 30, 45, 26, 3, 35, 1, 45, 35, 35, 1, 27, 29, 22, 11, 17, 13, 21, 18, 7};

        MergeSort.sort(n);

        assertArrayEquals(new int[]{1, 1, 3, 7, 11, 13, 17, 18, 21, 22, 26, 27, 29, 30, 35, 35, 35, 35, 45, 45}, n, IntStream.of(n).boxed().collect(toList()).toString());
    }
}
