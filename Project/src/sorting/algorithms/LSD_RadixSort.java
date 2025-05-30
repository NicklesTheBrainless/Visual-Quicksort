package sorting.algorithms;

import java.util.List;

public abstract class LSD_RadixSort {

    public static void radixSort(List<int[]> stepsBuffer, int[] arr, int maxBinaryDigits) {

        int[] binaryArr0 = new int[arr.length];
        int i0;

        int[] binaryArr1 = new int[arr.length];
        int i1;

        for (int b = 0; b < maxBinaryDigits; b++) {

            i0 = 0;
            i1 = 0;

            for (int i : arr) {

                int digit = i & (1 << b);

                if (digit == 0){
                    binaryArr0[i0] = i;
                    i0++;
                } else {
                    binaryArr1[i1] = i;
                    i1++;
                }
            }

            putTogether(stepsBuffer, arr, binaryArr0, i0, binaryArr1, i1);
        }
    }

    public static void putTogether(List<int[]> stepsBuffer, int[] totalArr, int[] arr0, int i0, int[] arr1, int i1) {

        int i = 0;
        for (int j = 0; j < i0; j++) {
            totalArr[i] = arr0[j];
            stepsBuffer.add(totalArr.clone());
            i++;
        }
        for (int j = 0; j < i1; j++) {
            totalArr[i] = arr1[j];
            stepsBuffer.add(totalArr.clone());
            i++;
        }
    }

}
