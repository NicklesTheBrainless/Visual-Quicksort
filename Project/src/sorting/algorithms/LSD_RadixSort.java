package sorting.algorithms;

import java.util.ArrayList;
import java.util.List;

public abstract class LSD_RadixSort {

    public static void radixSort(List<int[]> stepsBuffer, int[] arr, int maxBinaryDigits) {

        for (int b = 0; b < maxBinaryDigits; b++) {

            List<Integer> list0 = new ArrayList<>();
            List<Integer> list1 = new ArrayList<>();

            for (int i : arr) {

                int digit = i & (1 << b);
                if (digit == 0)
                    list0.add(i);
                else
                    list1.add(i);
            }

            putTogether(stepsBuffer, arr, list0, list1);
        }
    }

    public static void putTogether(List<int[]> stepsBuffer, int[] totalArr, List<Integer> list0, List<Integer> list1) {

        for (int i = 0; i < totalArr.length; i++) {

            if (i < list0.size()) {
                totalArr[i] = list0.get(i);
                stepsBuffer.add(totalArr.clone());
            } else {
                totalArr[i] = list1.get(i - list0.size());
                stepsBuffer.add(totalArr.clone());
            }
        }
    }

}
