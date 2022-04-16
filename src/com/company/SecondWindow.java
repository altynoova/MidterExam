package com.company;

import javax.swing.*;
import java.awt.*;

public class SecondWindow extends JFrame {
    MyPanel1 myPanel1;
    final private int min;
    final private int max;

    SecondWindow(int min, int max) {
        this.min = min;
        this.max = max;

        this.setTitle("Second Window");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        this.setSize(700, 500);


        JLabel label = new JLabel("y=2*x*x*x+3*x*x-10");
        label.setLayout(null);
        label.setFont(new Font("Serif", Font.PLAIN, 15));
        label.setBounds(360, 40, 150, 40);
        this.add(label);

        myPanel1 = new MyPanel1(min, max);
        this.add(myPanel1);

        this.setVisible(true);
    }
}
