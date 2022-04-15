package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel1  extends JPanel {
    private int width;
    private int height;
    MyPanel1() {
        this.setSize(500, 500);
    }
    public void paint(Graphics g) {
        width = getWidth();
        height = getHeight();
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.blue);
        g3.drawLine(width / 2, 0, width / 2, height);
        g3.drawLine(0, height / 2, width, height / 2);
        drawGrid(g3);
    }
    public void drawGrid (Graphics2D g){

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
}

