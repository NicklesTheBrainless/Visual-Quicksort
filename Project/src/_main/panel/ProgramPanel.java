package _main.panel;

import sorting.algorithms.*;
import sorting.SortVisualizer;
import utils.ArrayUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static _main.setting._Settings.*;

public class ProgramPanel extends BasePanel {

    public SortVisualizer sortV;

    public ProgramPanel() {

        super(SETTING_FPS);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);

        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }


    @Override
    protected void onStart() {

        int[] arr = ArrayUtils.createShuffledArr(0, ARR_LENGTH, ARR_LENGTH * 8);

        List<int[]> stepsBuffer = new ArrayList<>();

        switch (SETTING_SORTING_ALGORITHM) {
            case BUBBLE_SORT -> BubbleSort.bubbleSort(stepsBuffer, arr);
            case INSERTION_SORT -> InsertionSort.insertionSort(stepsBuffer, arr);
            case SHELL_SORT -> ShellSort.shellSort(stepsBuffer, arr);
            case MERGE_SORT -> MergeSort.mergeSort(stepsBuffer, arr);
            case QUICK_SORT -> QuickSort.quickSort(stepsBuffer, arr);
            case LSD_RADIX_SORT -> LSD_RadixSort.radixSort(stepsBuffer, arr, ARR_MAX_BINARY_LENGTH);
            case MSD_RADIX_SORT -> MSD_RadixSort.radixSort(stepsBuffer, arr, ARR_MAX_BINARY_LENGTH);
        }

        sortV = new SortVisualizer(stepsBuffer);
    }

    @Override
    protected void update(double delta) {

        if (sortV == null)
            return;

        sortV.update(delta);
    }

    @Override
    protected void draw(Graphics2D g2) {

        if (sortV == null)
            return;

        sortV.draw(g2);
    }
}