package sorting.algorithms;

import java.util.List;

public abstract class BubbleSort {

    public static void bubbleSort(List<int[]> stepsBuffer, int[] arr) {

        for (int i = 0; i < (arr.length - 1); i++)
            for (int j = 0; j < (arr.length - i - 2); j++)
                if (arr[j] > arr[j+1])
                    swap(stepsBuffer, arr, j, j + 1);
    }

    private static void swap(List<int[]> stepsBuffer, int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        stepsBuffer.add(arr.clone());
    }
}
