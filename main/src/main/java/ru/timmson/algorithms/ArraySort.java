package ru.timmson.algorithms;

import static java.lang.System.arraycopy;

public abstract class ArraySort implements Sort {

    protected void copy(int[] arraySrc, int[] arrayDst) {
        arraycopy(arraySrc, 0, arrayDst, 0, arraySrc.length);
    }

    protected int[] extract(int[] array, int start, int length) {
        int[] tmp = new int[length];
        arraycopy(array, start, tmp, 0, length);
        return tmp;
    }

    protected int[] concatenate(int[] array, int... values) {
        int[] tmp = new int[array.length + values.length];
        arraycopy(array, 0, tmp, 0, array.length);
        arraycopy(values, 0, tmp, array.length, values.length);
        return tmp;
    }

    protected void swap(int[] n, int i1, int i2) {
        var tmp = n[i2];
        n[i2] = n[i1];
        n[i1] = tmp;
    }
}
