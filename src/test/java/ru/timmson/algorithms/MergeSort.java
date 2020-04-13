package ru.timmson.algorithms;

import static java.lang.System.arraycopy;

public class MergeSort {
    public static void sort(int[] n) {
        if (n.length > 1) {
            final var middle = n.length / 2;

            int[] left = copy(n, 0, middle);
            int[] right = copy(n, middle, n.length - middle);

            sort(left);
            sort(right);

            int r = 0;
            int l = 0;

            for (int i = 0; i < n.length; i++) {
                if (l < left.length) {
                    if (r < right.length) {
                        if (left[l] <= right[r]) {
                            n[i] = left[l++];
                        } else {
                            n[i] = right[r++];
                        }
                    } else {
                        n[i] = left[l++];
                    }
                } else {
                    n[i] = right[r++];
                }
            }

        }

    }

    private static int[] copy(int[] n, int start, int length) {
        int[] tmp = new int[length];
        arraycopy(n, start, tmp, 0, length);
        return tmp;
    }

    private static void swap(int[] n, int i1, int i2) {
        var tmp = n[i2];
        n[i2] = n[i1];
        n[i1] = tmp;
    }
}
