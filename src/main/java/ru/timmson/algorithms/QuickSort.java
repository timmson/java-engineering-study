package ru.timmson.algorithms;

import java.util.Random;

public class QuickSort extends ArraySort {

    private static final QuickSort INSTANCE = new QuickSort();

    public static QuickSort getInstance() {
        return INSTANCE;
    }

    public void sort(int[] array) {
        if (array.length > 1) {
            int point = new Random().nextInt(array.length - 1);

            int[] left = new int[array.length];
            int[] right = new int[array.length];

            int l = 0;
            int r = 0;

            for (int i = 0; i < array.length; i++) {
                if (i != point) {
                    if (array[i] <= array[point]) {
                        left[l++] = array[i];
                    } else {
                        right[r++] = array[i];
                    }
                }
            }

            left = extract(left, 0, l);
            right = extract(right, 0, r);

            sort(left);
            sort(right);

            copy(concatenate(concatenate(left, array[point]), right), array);
        }
    }
}
