package sorting.algorithms;

import java.util.List;

public abstract class MSD_RadixSort {

    public static void radixSort(List<int[]> stepsBuffer, int[] arr, int maxBinaryDigits) {

        sortSplit(stepsBuffer, arr, maxBinaryDigits, 0, arr.length);
    }

    public static void sortSplit(List<int[]> stepsBuffer, int[] arr, int b, int index0, int length) {

        if (length <= 1)
            return;

        int binaryMask = 1 << (b - 1);

        int left = index0;
        int right = index0 + length - 1;

        while (left <= right) {

            // find 0 on left side
            while (left <= right && (arr[left] & binaryMask) == 0) {
                left++;
            }

            // find 1 on right side
            while (left <= right && (arr[right] & binaryMask) != 0) {
                right--;
            }

            // swap the 0 and the 1
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                stepsBuffer.add(arr.clone());
            }
        }

        int index1 = left;

        sortSplit(stepsBuffer, arr, b - 1, index0, index1 - index0);
        sortSplit(stepsBuffer, arr, b - 1, index1, length - (index1 - index0));
    }
}
