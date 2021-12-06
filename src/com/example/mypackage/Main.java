package com.example.mypackage;
import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class Main {

    public static void main(String... args) {
        JFrame application = createGUI();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }

    private static JFrame createGUI() {
        JTextField input = new JTextField();
        input.setPreferredSize(new Dimension(300, 40));

        JTextField input2 = new JTextField();
        input2.setPreferredSize(new Dimension(300,40));

        JButton convertButton = new JButton("Calculate");

        JLabel output = new JLabel();
        output.setPreferredSize(new Dimension(300, 40));

        String[] choices = { "+","-", "/","*"};
        final JComboBox<String> cb = new JComboBox<>(choices);


        convertButton.addActionListener(event -> {
            boolean flag = true;

            try {
                Integer.parseInt(input.getText());
                Integer.parseInt(input2.getText());
            }
            catch (NumberFormatException e) {
                showMessageDialog(null, "Please enter valid Integers!");
                flag = false;
            }

            if (flag) {
                int int1 = Integer.parseInt(input.getText());
                int int2 = Integer.parseInt(input2.getText());

                String operation = (String) cb.getSelectedItem();

                int result;

                switch (operation) {
                    case "+":
                        result = int1 + int2;
                        output.setText(Integer.toString(result));
                        break;
                    case "-":
                        result = int1 - int2;
                        output.setText(Integer.toString(result));
                        break;
                    case "*":
                        result = int1 * int2;
                        output.setText(Integer.toString(result));
                        break;
                    case "/":
                        result = int1 / int2;
                        output.setText(Integer.toString(result));
                        break;
                }
            }
        });

        JFrame gui = new JFrame("Basic Calculator");
        gui.setLayout(new FlowLayout());
        gui.add(input);
        gui.add(cb);
        gui.add(input2);
        gui.add(convertButton);
        gui.add(output);
        gui.pack();
        gui.setLocationRelativeTo(null); // Centering the screen

        return gui;
    }

}
