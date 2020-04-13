package ru.timmson.algorithms;

import static java.lang.System.arraycopy;

public class TreeSort extends ArraySort {

    private static final TreeSort INSTANCE = new TreeSort();

    public static TreeSort getInstance() {
        return INSTANCE;
    }

    @Override
    public void sort(int[] array) {
        int i = 0;
        final var rootNode = new Node(array[i++]);

        for (; i < array.length; i++) {
            rootNode.add(array[i]);
        }

        copy(rootNode.getValues(), array);
    }

    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void add(int newValue) {
            if (newValue <= this.value) {
                if (left != null) {
                    left.add(newValue);
                } else {
                    this.left = new Node(newValue);
                }
            } else {
                if (right != null) {
                    right.add(newValue);
                } else {
                    this.right = new Node(newValue);
                }
            }
        }

        public int[] getValues() {
            int[] leftArr = (left != null) ? left.getValues() : new int[0];
            int[] rightArr = (right != null) ? right.getValues() : new int[0];
            return concatenate(concatenate(leftArr, value), rightArr);
        }

        protected int[] concatenate(int[] array, int... values) {
            int[] tmp = new int[array.length + values.length];
            arraycopy(array, 0, tmp, 0, array.length);
            arraycopy(values, 0, tmp, array.length, values.length);
            return tmp;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

}
