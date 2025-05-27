package sorting.algorithms;

import java.util.List;

import static sorting.SortingUtils.swap;

public abstract class QuickSort {

    public static void quickSort(List<int[]> stepsBuffer, int[] arr) {
        quickSort(stepsBuffer, arr, 0, arr.length - 1);
    }

    public static void quickSort(List<int[]> stepsBuffer, int[] arr, int start, int end) {

        if (start >= end)
            return;

        int pivotIndex = partition(stepsBuffer, arr, start, end);
        quickSort(stepsBuffer, arr, start, pivotIndex - 1);
        quickSort(stepsBuffer, arr, pivotIndex + 1, end);
    }

    private static int partition(List<int[]> stepsBuffer, int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(stepsBuffer, arr, i, j);
            }
        }

        int pivotIndex = i + 1;
        swap(stepsBuffer, arr, pivotIndex, end);

        return pivotIndex;
    }

}
