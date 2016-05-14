package csh.dhsjms.Calculator3;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator frame = new Calculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 179 * 2, 260);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout());
        setResizable(false);
        textField = new JTextField();
        textField.setSize(146 * 2, 52 * 2);
        contentPane.add(textField);
        textField.setColumns(12);
        textField.setText(null);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);

        java.awt.Font font = new java.awt.Font("Dialog", 1, 25);
        Map<String, JButton> buttonMap = new HashMap<String, JButton>();

        for (int i = 0; i < 10; ++i) {
            JButton tempButton = new JButton(i + "");
            tempButton.setFont(font);
            buttonMap.put(i + "", tempButton);
            final int finalI = i;
            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (finalI == 0){
                        deailWith0();
                    }else {
                        setTextField(textField, (char) (finalI + '0'));
                    }
                }
            });
        }

        for (Character character : SimpleCalculator.operators) {
            JButton tempButton = new JButton(character + "");
            tempButton.setFont(font);
            buttonMap.put(character + "", tempButton);
            tempButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setOperate(textField, character);
                }
            });
        }

        JButton btnNewButton_clear = new JButton("C");
        btnNewButton_clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(null);
            }
        });

        JButton button_eql = new JButton("=");
        button_eql.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText(SimpleCalculator.calculate(textField.getText()));
            }
        });



        btnNewButton_clear.setFont(font);

        button_eql.setFont(font);
        textField.setFont(font);

        contentPane.add(buttonMap.get("/"));
        contentPane.add(buttonMap.get("+"));
        contentPane.add(buttonMap.get("-"));
        contentPane.add(buttonMap.get("*"));

        contentPane.add(buttonMap.get("7"));
        contentPane.add(buttonMap.get("8"));
        contentPane.add(buttonMap.get("9"));
        contentPane.add(btnNewButton_clear);

        contentPane.add(buttonMap.get("4"));
        contentPane.add(buttonMap.get("5"));
        contentPane.add(buttonMap.get("6"));
        contentPane.add(buttonMap.get("0"));

        contentPane.add(buttonMap.get("1"));
        contentPane.add(buttonMap.get("2"));
        contentPane.add(buttonMap.get("3"));
        contentPane.add(button_eql);

    }

    private void deailWith0() {
        if (isBlankString()){
            return;
        }else if (checkLastIsOperater(textField)){
            return;
        }else {
            setTextField(textField, '0');
        }
    }

    private void setTextField(JTextField textField, char additionalString) {
        textField.setText(textField.getText() + additionalString);
    }

    private void setOperate(JTextField textField, char operater) {
        if (isBlankString()) {
            return;
        }
        if (!checkLastIsOperater(textField)) {
            setTextField(textField, operater);
        } else {
            String test = textField.getText();
            textField.setText(test.substring(0, test.length() - 1) + operater);
        }
    }

    private boolean isBlankString() {
        if (textField == null || textField.getText().equals("")) {
            return true;
        }
        return false;
    }

    private boolean checkLastIsOperater(JTextField textField) {
        String text = textField.getText();
        if (SimpleCalculator.operators.contains(text.charAt(text.length() - 1))) {
            return true;
        } else {
            return false;
        }
    }
}
