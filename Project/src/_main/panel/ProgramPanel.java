package _main.panel;

import sorting.algorithms.BubbleSort;
import sorting.SortVisualizer;
import sorting.algorithms.QuickSort;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static _main.setting._Settings.*;

public class ProgramPanel extends BasePanel {

    public static Random random = new Random();
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

        int[] arr = new int[ARR_LENGTH];
        for (int i = 0; i < ARR_LENGTH; i++)
            arr[i] = random.nextInt(MIN_VALUE, MAX_VALUE);

        List<int[]> stepsBuffer = new ArrayList<>();

        switch (SETTING_SORTING_ALGORITHM) {
            case BUBBLE_SORT -> BubbleSort.bubbleSort(stepsBuffer, arr);
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