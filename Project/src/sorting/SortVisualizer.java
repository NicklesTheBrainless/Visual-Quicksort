package sorting;

import utils.PanelObject;

import java.awt.*;
import java.util.List;

import static _main.setting._Settings.*;

public class SortVisualizer implements PanelObject {

    List<int[]> steps;
    int iStep;

    public SortVisualizer(List<int[]> steps) {
        this.steps = steps;
    }

    @Override
    public void update(double delta) {
        iStep++;

        if (iStep == steps.size())
            System.exit(0);
    }

    @Override
    public void draw(Graphics2D g2) {

        int[] currentStep = steps.get(iStep);

        for (int i = 0; i < currentStep.length; i++) {

            int value = currentStep[i];
            int x = i + X_OFF;
            int y = Y_OFF;
            g2.setColor(VISUAL_SORT_COLOR);
            g2.drawLine(x, y, x, y + (value * DIRECTION));
        }
    }

}
