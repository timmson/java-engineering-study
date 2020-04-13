package ru.timmson.algorithms;

import static java.lang.System.arraycopy;

public class MergeSort {

    private static final MergeSort INSTANCE = new MergeSort();

    private MergeSort() {

    }

    public static MergeSort getInstance() {
        return INSTANCE;
    }

    public void sort(int[] array) {
        if (array.length > 1) {
            final var middle = array.length / 2;

            int[] left = copy(array, 0, middle);
            int[] right = copy(array, middle, array.length - middle);

            sort(left);
            sort(right);

            final var itLeft = new Iterator(left);
            final var itRight = new Iterator(right);

            for (int i = 0; i < array.length; i++) {
                if (!itLeft.isEnd()) {
                    if (!itRight.isEnd()) {
                        if (itLeft.current()<= itRight.current()) {
                            array[i] = itLeft.next();
                        } else {
                            array[i] = itRight.next();
                        }
                    } else {
                        array[i] = itLeft.next();
                    }
                } else {
                    array[i] = itRight.next();
                }
            }

        }

    }

    private int[] copy(int[] array, int start, int length) {
        int[] tmp = new int[length];
        arraycopy(array, start, tmp, 0, length);
        return tmp;
    }

    private void swap(int[] n, int i1, int i2) {
        var tmp = n[i2];
        n[i2] = n[i1];
        n[i1] = tmp;
    }

    private class Iterator {

        private final int[] array;
        private int i = 0;

        private Iterator(int[] array) {
            this.array = array;
        }

        public int next() {
            return array[i++];
        }

        public int current() {
            return array[i];
        }

        public boolean isStart() {
            return i == 0;
        }


        public boolean isEnd() {
            return i == array.length;
        }

        public int getI() {
            return i;
        }
    }
}
