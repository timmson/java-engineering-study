package ru.timmson.load;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public strictfp class DoSomething {

    private static Comparator<Integer> c;

    public static void main(String[] args) {
        int[] n = new Random().ints(10, 1, 20).toArray();
        System.out.println(IntStream.of(n).mapToObj(String::valueOf).collect(Collectors.joining(",")));

        //binaryHeap(n);
        //mergeSort(n);
        quickSort(n);

        System.out.println(IntStream.of(n).mapToObj(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void binaryHeap(int[] n) {
        for (int i = n.length - 1; i > 0; i--) {
            int iNew = promote(i, i, n);
            if (iNew == 0) {
                int t = n[iNew];
                n[iNew] = n[i];
                n[i] = t;
            }
            System.out.println(" Step " + i + ": " + IntStream.of(n).mapToObj(String::valueOf).collect(Collectors.joining(",")));
        }
    }

    private static int promote(int xI, int last, int[] n) {
        int zI = ((xI + 1) >> 1) - 1;
        int yI = Math.min(((zI + 1) << 2) + 1 - (xI + 1) - 1, last);

        int x = n[xI];
        int y = n[yI];
        int z = n[zI];

        if (x <= y && x <= z) {
            n[xI] = z;
            n[zI] = x;
            return promote(zI, last, n);
        }

        return xI;
    }

    public static void mergeSort(int[] array) {
        System.arraycopy(mergeSort(array, 0, array.length - 1), 0, array, 0, array.length);
    }

    public static int[] mergeSort(int[] array, int start, int end) {
        if (end == start) {
            return new int[]{array[start]};
        }

        int length = end - start + 1;
        int half = length / 2;
        int[] left = mergeSort(array, start, start + half - 1);
        int[] right = mergeSort(array, start + half, end);

        int l = 0;
        int r = 0;
        int[] tmp = new int[left.length + right.length];

        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                tmp[l + r] = left[l];
                l++;
            } else {
                tmp[l + r] = right[r];
                r++;
            }
        }

        while (l < left.length) {
            tmp[l + r] = left[l];
            l++;
        }
        while (r < right.length) {
            tmp[l + r] = right[r];
            r++;
        }

        return tmp;

    }

    public static void quickSort(int[] array) {
        int length = array.length;

        int point = length / 2;

        int[] left = new int[length];
        int[] right = new int[length];

        int l = 0;
        int r = 0;
        while ((r + l) < length) {

            if (array[r + l + (point == (r + l) ? 1 : 0)] <= array[point]) {
                left[l] = array[r + l];
                l++;
            } else {
                right[r] = array[r + l];
                r++;
            }
        }

        int[] leftReduced = new int[l];
        int[] rightReduced = new int[r];

        System.arraycopy(right, 0, rightReduced, 0, r);
        System.arraycopy(left, 0, leftReduced, 0, l);

        if (array.length > 2) {
            if (1 < l) {
                quickSort(leftReduced);
            }

            if (1 < r) {
                quickSort(rightReduced);
            }
        }

        System.arraycopy(leftReduced, 0, array, 0, l);
        System.arraycopy(rightReduced, 0, array, l + 1, r);
    }

    private void swap(int i, int j, int[] array) {
        final var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
