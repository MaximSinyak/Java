package ru.geekbrains.lesson_8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private final JTextField textField;
    private char operation;
    private double total;
    private boolean ifFirstDigit;
    private boolean ifFirstOperation;
    private boolean isResult = false;
	private boolean isPoint = true;
	


    public MyFrame() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 300, 300);
        
        ifFirstDigit = true;

        total = 0;

        JPanel jPanel = new JPanel();

        textField = new JTextField(20);
        textField.setEditable(false);

        jPanel.add(textField);
        JButton[] jbs = new JButton[9];
        for (int i=0; i < jbs.length; i++){
            jbs[i] = new JButton(String.valueOf(i + 1));
            jbs[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    action(e);
                }
            });
            jPanel.add(jbs[i]);
        }

        JButton buttonZero = new JButton("0");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonEquals = new JButton("=");
		JButton buttonMultiply = new JButton("*");
		JButton buttonDivision = new JButton("/");
		JButton buttonSquaring = new JButton("X\u00b2");
		JButton buttonPoint = new JButton(".");
		JButton buttonClean = new JButton("C");
		JButton buttonCleanAll = new JButton("CA");

        buttonZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                action(e);
            }
        });

        buttonPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                operation(e);
                ifFirstOperation = false;
            }
        });

        buttonMinus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                operation(e);
            }
        });

        buttonEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                calculating(e);
            }
        });
		
		buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                operation(e);
            }
        });
		
		buttonDivision.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                operation(e);
            }
        });
		
		buttonSquaring.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                squaring(e);
            }
        });
		
		buttonPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                point(e);
				isPoint = false;

            }
        });
		
		buttonClean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                clean(e);
            }
        });
		
		buttonCleanAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                cleanAll(e);
            }
        });

        jPanel.add(buttonCleanAll);
		jPanel.add(buttonZero);
        jPanel.add(buttonClean);
        jPanel.add(buttonPlus);
        jPanel.add(buttonMultiply);
        jPanel.add(buttonPoint);
        jPanel.add(buttonMinus);
        jPanel.add(buttonDivision);
		jPanel.add(buttonSquaring);
		jPanel.add(buttonEquals);



        add(jPanel);
	setVisible(true);
    }

    public void calculating(ActionEvent e){
        String text = textField.getText();
        String digit = "";
        for (int i = 0; i < text.length(); i++) {    //char c: text.toCharArray()
            char c = text.charAt(i);
            if (c == '-' || c == '+' || c == '*' || c == '/') {
                double currentValue = Double.parseDouble(digit);
                if(ifFirstDigit) {
                    total += currentValue;
                    ifFirstDigit = false;
                } else {
                    if(operation == '-'){
                        total -= currentValue;
                    } else if (operation == '+'){
                        total += currentValue;
                    } else if (operation == '*'){
                        total *= currentValue;
                    } else if (operation == '/'){
                        total /= currentValue;
                    }
                }

                digit = "";
                operation = c;
                continue;
            }

            digit += c;

        }

        double currentValue = Double.parseDouble(digit);
        if(operation == '-'){
            total -= currentValue;
        } else if (operation == '+'){
            total += currentValue;
        } else if (operation == '*'){
            total *= currentValue;
        } else if (operation == '/'){
            total /= currentValue;
        }

        ifFirstDigit = true;
        textField.setText(String.valueOf(total));
        total = 0;
        ifFirstOperation = true;
        isResult = true;

    }

    public void action(ActionEvent e){
        if (isResult){
            isResult = false;
            textField.setText(null);
            textField.setText(textField.getText() + e.getActionCommand());
            ifFirstOperation = true;
        }
        else {
            textField.setText(textField.getText() + e.getActionCommand());
            ifFirstOperation = true;
        }
    }

    public void operation(ActionEvent e){
        if(ifFirstOperation) {
            textField.setText(textField.getText() + e.getActionCommand());
        }
        else {
            String text = textField.getText();
            String digit = "";
            for (int i = 0; i < text.length() - 1; i++) {    
                char c = text.charAt(i);
                digit += c;
            }
            textField.setText(digit + e.getActionCommand());
        }
		isResult = false;
		isPoint = true;
    }
	
	public void point(ActionEvent e){
		if(isPoint) {	
			if (isResult){
				isResult = false;
				textField.setText(null);
				textField.setText(textField.getText() + e.getActionCommand());
				ifFirstOperation = true;
			}
			else {
				textField.setText(textField.getText() + e.getActionCommand());
				ifFirstOperation = true;
			}
		}
    }
	
	public void squaring(ActionEvent e){
        if (isResult)
        {
            isResult = false;
            calculating(e);
            String text = textField.getText();
            String digit = "";
            for (char c : text.toCharArray()) {
                digit += c;
            }
            double currentValue = Double.parseDouble(digit);
            currentValue *= currentValue;
            textField.setText(String.valueOf(currentValue));
        }
        else {
            String text = textField.getText();
            double currentValue = Double.parseDouble(text);
            currentValue *= currentValue;
            textField.setText(String.valueOf(currentValue));
        }
    }
	
	public void clean(ActionEvent e){
        String text = textField.getText();
		if (text.charAt(text.length()) == '.') {
			isPoint = false;
		}
		String digit = "";
         for (int i = 0; i < text.length() - 1; i++) {    
            char c = text.charAt(i);
            digit += c;
        }
        textField.setText(digit);
    }
	
	public void cleanAll(ActionEvent e){
        textField.setText(null);
		isPoint = true;
		isResult = false;
    }
}
