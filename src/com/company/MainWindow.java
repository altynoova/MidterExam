package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    DefaultListModel<String> list;
    JList<String> list1;
    JTextArea textArea;
    JTextField textField1;
    JTextField textField2;
    JButton buttonDraw;
    SecondWindow secondWindow;

    private enum Actions {
        GO,
        DRAW
    }

    MainWindow() {
        this.setTitle("Main Window");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 100);
        this.setSize(700, 500);

        JLabel label = new JLabel("X start:");
        label.setLayout(null);
        label.setFont(new Font("Serif", Font.PLAIN, 18));
        label.setBounds(20, 10, 80, 40);
        this.add(label);

        JLabel label1 = new JLabel("X end:");
        label1.setLayout(null);
        label1.setFont(new Font("Serif", Font.PLAIN, 18));
        label1.setBounds(20, 70, 80, 40);
        this.add(label1);

        textField1 = new JTextField();
        textField1.setBounds(110, 10, 200, 40);
        textField1.setLayout(null);
        this.add(textField1);


        textField2 = new JTextField();
        textField2.setBounds(110, 70, 200, 40);
        textField2.setLayout(null);
        this.add(textField2);


        JButton buttonGo = new JButton("GO!");
        buttonGo.setLayout(null);
        buttonGo.setBounds(350, 10, 150, 40);
        buttonGo.setActionCommand(Actions.GO.name());
        buttonGo.addActionListener(this);
        this.add(buttonGo);

        buttonDraw = new JButton("DRAW FUNCTION");
        buttonDraw.setLayout(null);
        buttonDraw.setActionCommand(Actions.DRAW.name());
        buttonDraw.addActionListener(this);
        buttonDraw.setBounds(350, 70, 150, 40);
        this.add(buttonDraw);

        list = new DefaultListModel<>();
        list.addElement("Find max");
        list.addElement("Find root");
        list.addElement("Print points");
        list1 = new JList<>(list);
        list1.setBounds(50, 170, 150, 250);
        this.add(list1);

        JLabel result = new JLabel("Result:");
        result.setLayout(null);
        result.setFont(new Font("Serif", Font.PLAIN, 22));
        result.setBounds(440, 120, 140, 50);
        this.add(result);

        textArea = new JTextArea("0");
        textArea.setLayout(null);
        textArea.setBounds(350, 170, 250, 250);
        this.add(textArea);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (list1.getSelectedIndex() == 0 && e.getActionCommand() == Actions.GO.name()) {
            int xStart = Integer.parseInt(textField1.getText());
            int xEnd = Integer.parseInt(textField2.getText());
            int maxValue = Operations.FindMax(xStart, xEnd);
            textArea.setText(String.valueOf(maxValue));
        }

        if (list1.getSelectedIndex() == 1 && e.getActionCommand() == Actions.GO.name()) {
            int xStart = Integer.parseInt(textField1.getText());
            int xEnd = Integer.parseInt(textField2.getText());
            textArea.setText(String.valueOf(Operations.BisectionMethod(xStart, xEnd)));
        }

        if (list1.getSelectedIndex() == 2 && e.getActionCommand() == Actions.GO.name()) {
            int xStart = Integer.parseInt(textField1.getText());
            int xEnd = Integer.parseInt(textField2.getText());
            textArea.setText(String.valueOf(Operations.PrintPoints(xStart, xEnd)));
        }
        if (e.getActionCommand() == Actions.DRAW.name()) {
            int xStart = Integer.parseInt(textField1.getText());
            int xEnd = Integer.parseInt(textField2.getText());
            secondWindow = new SecondWindow(xStart, xEnd);
        }
    }
}
