package sorting.algorithms;

import java.util.List;

import static utils.ArrayUtils.swap;

public abstract class HeapSort {

    public static void heapSort(List<int[]> stepsBuffer, int[] arr) {

        buildHeap(stepsBuffer, arr);

        for (int n = arr.length - 1; n >= 0; n--) {
            swap(stepsBuffer, arr, 0, n);
            heapify(stepsBuffer, arr, n, 0);
        }
    }

    private static void buildHeap(List<int[]> stepsBuffer, int[] arr) {

        int startIndex = (arr.length / 2) - 1;
        for (int i = startIndex; i >= 0; i--)
            heapify(stepsBuffer, arr, arr.length - 1, i);
    }

    private static void heapify(List<int[]> stepsBuffer, int[] arr, int n, int index) {

        int leftIndex  = index * 2 + 1;
        int rightIndex = index * 2 + 2;
        int maxIndex = index;

        if (leftIndex < n && arr[leftIndex] > arr[maxIndex])
            maxIndex = leftIndex;

        if (rightIndex < n && arr[rightIndex] > arr[maxIndex])
            maxIndex = rightIndex;

        if (maxIndex != index) {
            swap(stepsBuffer, arr, maxIndex, index);
            heapify(stepsBuffer, arr, n, maxIndex);
        }
    }

}
