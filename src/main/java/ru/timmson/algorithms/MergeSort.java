package ru.timmson.algorithms;

public class MergeSort extends ArraySort {

    private static final MergeSort INSTANCE = new MergeSort();

    private MergeSort() {

    }

    public static MergeSort getInstance() {
        return INSTANCE;
    }

    @Override
    public void sort(int[] array) {
        if (array.length > 1) {
            final var middle = array.length / 2;

            int[] left = extract(array, 0, middle);
            int[] right = extract(array, middle, array.length - middle);

            sort(left);
            sort(right);

            int l = 0;
            int r = 0;

            for (int i = 0; i < array.length; i++) {
                if (l < left.length) {
                    if (r < right.length) {
                        if (left[l] <= right[r]) {
                            array[i] = left[l++];
                        } else {
                            array[i] = right[r++];
                        }
                    } else {
                        array[i] = left[l++];
                    }
                } else {
                    array[i] = right[r++];
                }
            }

        }

    }

}
