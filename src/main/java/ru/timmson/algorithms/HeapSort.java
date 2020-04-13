package ru.timmson.algorithms;


/**
 * @link https://algorithms.tutorialhorizon.com/heap-sort-java-implementation/
 */
public class HeapSort extends ArraySort {

    private static final HeapSort INSTANCE = new HeapSort();

    public static HeapSort getInstance() {
        return INSTANCE;
    }

    @Override
    public void sort(int array[]) {
        int size = array.length;

        // Build heap
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(array, size, i);

        // One by one extract (Max) an element from heap and
        // replace it with the last element in the array
        for (int i = size - 1; i >= 0; i--) {

            //array[0] is a root of the heap and is the max element in heap
            int x = array[0];
            array[0] = array[i];
            array[i] = x;

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
    }

    // To heapify a subtree with node i
    void heapify(int arrA[], int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int leftChildIdx = 2 * i + 1; // left = 2*i + 1
        int rightChildIdx = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (leftChildIdx < heapSize && arrA[leftChildIdx] > arrA[largest])
            largest = leftChildIdx;

        // If right child is larger than largest so far
        if (rightChildIdx < heapSize && arrA[rightChildIdx] > arrA[largest])
            largest = rightChildIdx;

        // If largest is not root
        if (largest != i) {
            int swap = arrA[i];
            arrA[i] = arrA[largest];
            arrA[largest] = swap;

            // Recursive call to  heapify the sub-tree
            heapify(arrA, heapSize, largest);
        }
    }

}
