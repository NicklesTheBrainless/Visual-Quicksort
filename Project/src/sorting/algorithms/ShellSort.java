package sorting.algorithms;

import java.util.List;

import static _main.setting._Settings.GAP_SEQUENCE;
import static utils.ArrayUtils.swap;

public abstract class ShellSort {

    public static void shellSort(List<int[]> stepsBuffer, int[] arr) {

        for (int gap : GAP_SEQUENCE) {

            if (gap >= arr.length / 2)
                continue;

            for (int off = 0; off < gap; off++)
                insertionSortGapedArr(stepsBuffer, arr, gap, off);
        }
    }

    private static void insertionSortGapedArr(List<int[]> stepsBuffer, int[] arr, int gap, int off) {

        for (int i = off; i < arr.length; i += gap)
            for (int j = i; j >= gap; j--)
                if (arr[j] < arr[j - gap])
                    swap(stepsBuffer, arr, j, j - 1);
                else
                    break;
    }
}
