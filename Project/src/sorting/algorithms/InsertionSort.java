package sorting.algorithms;

import java.util.List;

import static utils.ArrayUtils.swap;

public abstract class InsertionSort {

    public static void insertionSort(List<int[]> stepsBuffer, int[] arr) {

        for (int i = 1; i < arr.length; i++)
            for (int j = i; j >= 1; j--)
                if (arr[j] <= arr[j - 1])
                    swap(stepsBuffer, arr, j, j - 1);
    }

}
