/**
 * Created by chezkah kate on 10/28/2016.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.*;
import java.math.BigDecimal;
import java.util.*;
//import java.util.List;

public class Calculator  extends JFrame{
    private JPanel pane;
    private JTextArea output;
    private JButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnDiv,btnMul,btnSub,btnAdd,btnDec,btnEq,btnAC, btnC, btnPM, btnPerc;
    private String result;
    private BigDecimal first, second;
    private String operation;

    public Calculator(){
        pane = new JPanel(new GridLayout(5,4));
        result = "";

        output = new JTextArea();
        output.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        output.setBackground(Color.LIGHT_GRAY);
        output.setForeground(Color.BLACK);
        output.setFont(new Font("Calibri", Font.PLAIN, 20));
        output.setEditable(false);

        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");

        btnDiv = new JButton("÷");
        btnMul = new JButton("x");
        btnSub = new JButton("-");
        btnAdd = new JButton("+");
        btnDec = new JButton(".");
        btnEq = new JButton("=");
        btnAC = new JButton("AC");
        btnC = new JButton("C");
        btnPM = new JButton("+/-");
        btnPerc = new JButton("%");

        ActionListener l = e -> events(e);

        JButton[] numBtns ={btn0, btn1 ,btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDec, btnC, btnMul, btnSub, btnAC, btnDiv, btnPM, btnPerc, btnAdd, btnEq};

        for(int x = 0; x < numBtns.length; x++){

            numBtns[x].setFont(new Font("CalibriHeader", Font.PLAIN, 20));
            if(x < 12){
                numBtns[x].addActionListener(l);
                numBtns[x].setBackground(Color.WHITE);
                numBtns[x].setForeground(Color.BLACK);
            }else{
                numBtns[x].setBackground(Color.BLACK);
                numBtns[x].setForeground(Color.WHITE);
            }
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
            }
        });

        pane.add(btnAC);
        pane.add(btnPM);
        pane.add(btnPerc);
        pane.add(btnDiv);

        pane.add(btn7);
        pane.add(btn8);
        pane.add(btn9);
        pane.add(btnMul);

        pane.add(btn4);
        pane.add(btn5);
        pane.add(btn6);
        pane.add(btnSub);

        pane.add(btn1);
        pane.add(btn2);
        pane.add(btn3);
        pane.add(btnAdd);

        pane.add(btn0);
        pane.add(btnC);
        pane.add(btnDec);
        pane.add(btnEq);

        add(output, BorderLayout.NORTH);
        add(pane, BorderLayout.AFTER_LINE_ENDS);
        setTitle("Calculator");
        setSize(250,400);
        setVisible(true);
        setResizable(false);

        //AC = AllClear or clear all
        btnAC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText(null);
            }
        });

        btnPM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigDecimal x = new BigDecimal(output.getText());
                output.setText(String.valueOf(x.negate()));
            }
        });

        btnPerc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("0");
            }
        });

        btnDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first = new BigDecimal(output.getText());
                output.setText("");
                operation = "/";
            }
        });

        btnSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first = new BigDecimal(output.getText());
                output.setText("");
                operation = "-";
            }
        });

        btnMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first = new BigDecimal(output.getText());
                output.setText("");
                operation = "x";
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first = new BigDecimal(output.getText());
                output.setText("");
                operation = "+";
            }
        });
    }

    public void events(ActionEvent e) {
        //JButton src = (JButton) e.getSource();
        if (e.getSource().equals(btn0)) {
            output.setText(output.getText().concat("0"));
        }
        if (e.getSource().equals(btn1)) {
            output.setText(output.getText().concat("1"));
        }
        if (e.getSource().equals(btn2)){
            output.setText(output.getText().concat("2"));
        }
        if(e.getSource().equals(btn3)) {
            output.setText(output.getText().concat("3"));
        }
        if(e.getSource().equals(btn4)) {
            output.setText(output.getText().concat("4"));
        }
        if(e.getSource().equals(btn5)) {
            output.setText(output.getText().concat("5"));
        }
        if(e.getSource().equals(btn6)) {
            output.setText(output.getText().concat("6"));
        }
        if(e.getSource().equals(btn7)) {
            output.setText(output.getText().concat("7"));
        }
        if(e.getSource().equals(btn8)) {
            output.setText(output.getText().concat("8"));
        }
        if(e.getSource().equals(btn9)) {
            output.setText(output.getText().concat("9"));
        }
        if(e.getSource().equals(btnDec)) {
            output.setText(output.getText().concat("."));
        }
        if(e.getSource().equals(btnC)){
            output.remove(result.charAt(-1));
        }
    }


    public static void main(String[] args){
        new Calculator();
    }
}
