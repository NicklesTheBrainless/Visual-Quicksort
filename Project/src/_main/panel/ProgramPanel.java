package _main.panel;

import sorting.algorithms.BubbleSort;
import sorting.SortVisualizer;
import sorting.algorithms.InsertionSort;
import sorting.algorithms.MergeSort;
import sorting.algorithms.QuickSort;
import utils.ArrayUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        int[] arr = ArrayUtils.createShuffledArr(ARR_MIN_VALUE, ARR_MAX_VALUE, ARR_LENGTH * 8);

        List<int[]> stepsBuffer = new ArrayList<>();

        switch (SETTING_SORTING_ALGORITHM) {
            case BUBBLE_SORT -> BubbleSort.bubbleSort(stepsBuffer, arr);
            case INSERTION_SORT -> InsertionSort.insertionSort(stepsBuffer, arr);
            case MERGE_SORT -> MergeSort.mergeSort(stepsBuffer, arr);
            case QUICK_SORT -> QuickSort.quickSort(stepsBuffer, arr);
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