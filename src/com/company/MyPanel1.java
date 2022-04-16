package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel1 extends JPanel {
    private int width;
    private int height;
    private int min;
    private int max;

    MyPanel1(int min, int max) {

        this.setSize(500, 500);
        this.min = min;
        this.max = max;

    }

    public void paint(Graphics g) {
        width = getWidth();
        height = getHeight();

        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.black);
        g3.drawLine(width / 2, 0, width / 2, height);
        g3.drawLine(0, height / 2, width, height / 2);
        drawGrid(g3);
        DrawFunction(g3);
    }

    public void drawGrid(Graphics2D g) {

        for (int x = width / 2; x < width; x += 30) {
            g.drawLine(x, height / 2 - 10, x, height / 2 + 10);
        }

        for (int x = width / 2; x > 0; x -= 30) {
            g.drawLine(x, height / 2 - 10, x, height / 2 + 10);
        }

        for (int y = height / 2; y < height; y += 30) {
            g.drawLine(width / 2 - 10, y, width / 2 + 10, y);
        }

        for (int y = height / 2; y > 0; y -= 30) {
            g.drawLine(width / 2 - 10, y, width / 2 + 10, y);
        }
    }

    public void DrawFunction(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setStroke(new BasicStroke(2f));

        int graphicsStartX = width / 2;
        int graphicsStartY = height / 2;
        for (int i = min; i < max; i++) {
            g.drawLine(i * 10 + graphicsStartX, Operations.Function(i) * 10 + graphicsStartY, (i + 1) * 10 + graphicsStartX, Operations.Function(i + 1) * 10 + graphicsStartY);
        }

    }
}


