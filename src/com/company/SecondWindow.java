package com.company;

import javax.swing.*;
public class SecondWindow extends JFrame {
    MyPanel1 myPanel1;
    SecondWindow(){
        this.setTitle("Second Window");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        this.setSize(700, 500);
        myPanel1=new MyPanel1();
        this.add(myPanel1);

        this.setVisible(true);
    }
}
