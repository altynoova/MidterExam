package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class MainWindow extends JFrame implements ActionListener {
    DefaultListModel<String> list;
    JList<String> list1;
    JTextArea textArea;
    JTextArea textArea1;
    int startx;
    int endx;
    SecondWindow secondWindow;

    private enum Actions {
        GO,
        DRAW
    }

    public int AddValue(int start, int end) {
        int x, y;
        int max = 0;
        for (x = start; x <= end; x = x + 1) {
            y = 2 * x * x * x + 3 * x * x - 10;
            if (y > max) {
                max = y;
            }
            textArea.setText(String.valueOf(x));
            textArea.setText(String.valueOf(y));
        }
        return max;
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

        JTextField textField1 = new JTextField();
        textField1.setBounds(110, 10, 200, 40);
        textField1.setLayout(null);
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField1.getText();
                startx = Integer.parseInt(textFieldValue);
            }
        });
        this.add(textField1);


        JTextField textField2 = new JTextField();
        textField2.setBounds(110, 70, 200, 40);
        textField2.setLayout(null);
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField2.getText();
                endx = Integer.parseInt(textFieldValue);
            }
        });
        this.add(textField2);

//        AddValue(startx, endx);

        JButton buttonGo = new JButton("GO!");
        buttonGo.setLayout(null);
        buttonGo.setBounds(350, 10, 150, 40);
        buttonGo.setActionCommand(Actions.GO.name());
        buttonGo.addActionListener(this);
        this.add(buttonGo);

        JButton buttonDraw = new JButton("DRAW FUNCTION");
        buttonDraw.setLayout(null);
        buttonGo.setActionCommand(Actions.DRAW.name());
        buttonDraw.addActionListener(this);
        buttonDraw.setBounds(350, 70, 150, 40);
        this.add(buttonDraw);

        list = new DefaultListModel<>();
        list.addElement("Find max");
        list.addElement("Find root");
        list.addElement("Print points");
        list1 = new JList<>(list);
        list1.setBounds(50, 170, 150, 200);
        this.add(list1);

        JLabel result = new JLabel("Result:");
        result.setLayout(null);
        result.setFont(new Font("Serif", Font.PLAIN, 22));
        result.setBounds(440, 120, 140, 50);
        this.add(result);

        textArea = new JTextArea("0");
        textArea.setLayout(null);
        textArea.setBounds(350, 170, 250, 260);
        PrintStream printStream = new PrintStream(new CustomOutputStream(textArea));
        System.setOut(printStream);
        System.setErr(printStream);
        this.add(textArea);

        textArea1 = new JTextArea(" 4 ");
        textArea1.setLayout(null);
        textArea1.setBounds(350, 170, 250, 260);
        this.add(textArea1);
        textArea1.setVisible(false);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (list1.getSelectedIndex() == 0 && e.getActionCommand() == Actions.GO.name()) {
            textArea.setText(String.valueOf(AddValue(startx, endx)));
            textArea.setVisible(true);
        }
        if (e.getActionCommand() == Actions.DRAW.name()) {
            secondWindow = new SecondWindow();
        }
    }
}
