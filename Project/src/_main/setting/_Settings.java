package _main.setting;

import sorting.SortingAlgorithm;

import java.awt.*;

public abstract class _Settings {

    // WINDOW
    public static final String TITLE = "Sorting Algorithms - Visualized";

    // FPS
    public static final int SETTING_FPS = 500;

    // SCREEN
    public static final int SCREEN_WIDTH  = 900;
    public static final int SCREEN_HEIGHT = 900;

    // SORTING
    public static final SortingAlgorithm SETTING_SORTING_ALGORITHM = SortingAlgorithm.QUICK_SORT;
    public static final int ARR_LENGTH = 800;
    public static final int ARR_MIN_VALUE = 0;
    public static final int ARR_MAX_VALUE = 800;

    // VISUALIZATION
    public static final Color BACKGROUND_COLOR  = new Color(30, 32, 40);
    public static final Color VISUAL_SORT_COLOR = new Color(80, 240, 120);
    public static final int DIRECTION = -1;
    public static final int X_OFF = 50;
    public static final int Y_OFF = 850;

}
