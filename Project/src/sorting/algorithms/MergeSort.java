package sorting.algorithms;

import java.util.List;

public abstract class MergeSort {

    public static void mergeSort(List<int[]> stepsBuffer, int[] arr) {
        mergeSort(stepsBuffer, arr, 0, arr.length);
    }

    public static void mergeSort(List<int[]> stepsBuffer, int[] arr, int from, int to) {

        int len = to - from;
        if (len <= 1)
            return;

        int middle = from + (len/2);

        mergeSort(stepsBuffer, arr, from, middle);
        mergeSort(stepsBuffer, arr, middle, to);
        merge(stepsBuffer, arr, from, middle, middle, to);
    }

    private static void merge(List<int[]> stepsBuffer, int[] arr, int leftFrom, int leftTo, int rightFrom, int rightTo) {

        int len = rightTo - leftFrom;
        int[] tempArr = new int[len];

        int i = 0, l = leftFrom, r = rightFrom;

        while (l < leftTo && r < rightTo) {

            if (arr[l] <= arr[r]) {
                tempArr[i] = arr[l];
                i++;
                l++;
            } else {
                tempArr[i] = arr[r];
                i++;
                r++;
            }
        }
        while (l < leftTo) {
            tempArr[i] = arr[l];
            i++;
            l++;
        }
        while (r < rightTo) {
            tempArr[i] = arr[r];
            i++;
            r++;
        }

        insertArr(stepsBuffer, arr, tempArr, leftFrom);
    }

    private static void insertArr(List<int[]> stepsBuffer, int[] arr, int[] inArr, int off) {

        for (int i = 0; i < inArr.length; i++) {
            arr[i + off] = inArr[i];
            stepsBuffer.add(arr.clone());
        }
    }

}
