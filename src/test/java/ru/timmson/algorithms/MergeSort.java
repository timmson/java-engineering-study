package ru.timmson.algorithms;

import static java.lang.System.arraycopy;

public class MergeSort {
    public static void sort(int[] n) {
        if (n.length > 1) {
            if (n.length == 2) {
                if (n[0] > n[1]) {
                    swap(n, 0, 1);
                }
            } else {
                int[] left = copy(n, 0, n.length / 2);
                int[] right = copy(n, (n.length / 2) + 1, n.length - 1);

                sort(left);
                sort(right);

                int r = 0;
                int l = 0;

                for (int i = 0; i < n.length; i++) {
                    if (l < left.length) {
                        if (r < right.length) {
                            if (left[l] <= right[r]) {
                                n[i] = left[l];
                                l++;
                            } else {
                                n[i] = right[r];
                                r++;
                            }
                        } else {
                            n[i] = left[l];
                            l++;
                        }
                    } else {
                        n[i] = right[r];
                        l++;
                    }
                }

            }

        }
    }

    private static int[] copy(int[] n, int start, int end) {
        int[] tmp = new int[end - start + 1];
        arraycopy(n, start, tmp, 0, end - start + 1);
        return tmp;
    }

    private static void swap(int[] n, int i1, int i2) {
        var tmp = n[i2];
        n[i2] = n[i1];
        n[i1] = tmp;
    }
}
