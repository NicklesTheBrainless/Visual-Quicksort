package utils;

import java.util.List;
import java.util.Random;

public abstract class ArrayUtils {

    public static int[] createOrderedArr(int from, int to) {
        int[] arr = new int[to];
        for (int i = from; i < to; i++)
            arr[i] = i;
        return arr;
    }

    public static int[] createShuffledArr(int from, int to, int randomizationValue) {

        int[] arr = createOrderedArr(from, to);

        Random random = new Random();
        for (int i = 0; i < randomizationValue; i++)
            swap(arr, random.nextInt(from, to), random.nextInt(from, to));
        return arr;
    }



    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void swap(List<int[]> stepsBuffer, int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        stepsBuffer.add(arr.clone());
    }

}
