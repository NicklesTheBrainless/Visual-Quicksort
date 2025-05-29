package sorting.algorithms;

import java.util.List;

import static utils.ArrayUtils.swap;

public abstract class BubbleSort {

    public static void bubbleSort(List<int[]> stepsBuffer, int[] arr) {

        for (int i = 0; i < (arr.length - 1); i++)
            for (int j = 0; j < (arr.length - i - 2); j++)
                if (arr[j] > arr[j+1])
                    swap(stepsBuffer, arr, j, j + 1);
    }

}
