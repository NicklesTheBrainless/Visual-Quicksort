package sorting;

import java.util.List;

public abstract class SortingUtils {

    public static void swap(List<int[]> stepsBuffer, int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        stepsBuffer.add(arr.clone());
    }

}
