package sorting.algorithms;

import java.util.List;

import static sorting.SortingUtils.swap;

public abstract class QuickSort {

    public static void quickSort(List<int[]> stepsBuffer, int[] arr) {
        quickSort(stepsBuffer, arr, 0, arr.length - 1);
    }

    public static void quickSort(List<int[]> stepsBuffer, int[] arr, int from, int to) {

        if (from >= to)
            return;

        int pivotIndex = partition(stepsBuffer, arr, from, to);
        quickSort(stepsBuffer, arr, from, pivotIndex - 1);
        quickSort(stepsBuffer, arr, pivotIndex + 1, to);
    }

    private static int partition(List<int[]> stepsBuffer, int[] arr, int from, int to) {

        int pivot = arr[to];
        int i = from - 1;

        for (int j = from; j < to; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(stepsBuffer, arr, i, j);
            }
        }

        int pivotIndex = i + 1;
        swap(stepsBuffer, arr, pivotIndex, to);

        return pivotIndex;
    }

}
