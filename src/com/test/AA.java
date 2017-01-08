package com.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 示例计算器
 * @Version: 1.0
 * @Create: 2017年1月8日 下午10:28:26
 * @Author: sanbo
 */

public class AA extends JFrame {
    private static final long serialVersionUID = -849010177432461085L;

    JTextField TFCalcBox;

    String[] Save1 = new String[10];
    int c = 0;
    double Answer = 0;
    String printAnswer;
    int AfterEqual = 0;
    int SymbolMark = 0;
    double AnswerHalf = 0;
    int AfterAnswer = 0;
    /*
     * Here the value of the variables AfterEqual,SymbolMark & AfterAnswer are
     * made 0 when their related buttons are pressed by the user but the values
     * are again made 0 when they are used.
     */
    double Ans;
    double ButtonValue;
    String Symbol;
    String Text;

    // When any number button is pressed this method store that number in a
    // array...
    public void SaveMethod(String Num) {
        Save1[c] = Num;
        String tmp = Save1[0];
        for (int n = 1; n <= c; n++) {
            tmp = tmp + Save1[n];
        }
        TFCalcBox.setText(tmp);
        AfterEqual = 0;
        c = c + 1;
    }

    // When any action button is pressed this method work...
    public void CalcMethod1(String S) {
        if (AfterEqual != 1) {
            // // After Pressing the equal button when pressed action button...
            // AnswerHalf = AnswerHalf;
            // }
            // // After Pressing the number button when pressed action button...
            // else {
            String ButtonNo = Save1[0];
            for (int n = 1; n < c; n++) {
                ButtonNo = ButtonNo + Save1[n];
            }
            ButtonValue = Double.parseDouble(ButtonNo);
            if (SymbolMark > 0) {
                if (Symbol.equals("+")) {
                    AnswerHalf = AnswerHalf + ButtonValue;
                } else if (Symbol.equals("-")) {
                    AnswerHalf = AnswerHalf - ButtonValue;
                } else if (Symbol.equals("*")) {
                    AnswerHalf = AnswerHalf * ButtonValue;
                } else if (Symbol.equals("/")) {
                    AnswerHalf = AnswerHalf / ButtonValue;
                }
            } else {
                AnswerHalf = ButtonValue;
            }
        }
        SymbolMark++;
        Symbol = S;
        c = 0;
    }

    // This method works after pressing Equal Button...
    public void CalcMethod2() {
        if (AfterAnswer == 0) {
            String ButtonNo = Save1[0];
            for (int n = 1; n < c; n++) {
                ButtonNo = ButtonNo + Save1[n];
            }
            ButtonValue = Double.parseDouble(ButtonNo);
        } else {
            ButtonValue = Ans;
        }
    }

    // This method works after CalcMethod2...
    public void Calculation() {
        if (Symbol.equals("+")) {
            AnswerHalf = AnswerHalf + ButtonValue;
        } else if (Symbol.equals("-")) {
            AnswerHalf = AnswerHalf - ButtonValue;
        } else if (Symbol.equals("*")) {
            AnswerHalf = AnswerHalf * ButtonValue;
        } else if (Symbol.equals("/")) {
            AnswerHalf = AnswerHalf / ButtonValue;
        }
        printAnswer = Double.toString(AnswerHalf);
        AfterEqual = 1;
        SymbolMark = 0;
        c = 0;
        AfterAnswer = 0;
        TFCalcBox.setText(printAnswer);
    }

    public void MethodForACbutton() {
        TFCalcBox.setText("0");
        AnswerHalf = 0;
        AfterEqual = 0;
        SymbolMark = 0;
        c = 0;
    }

    public void MethodForCutButton() {
        c = c - 2;
        String tmp = Save1[0];
        for (int n = 1; n <= c; n++) {
            tmp = tmp + Save1[n];
        }
        c++;
        TFCalcBox.setText(tmp);
    }

    public AA() {
        JPanel P2 = new JPanel();
        P2.setLayout(new GridLayout(5, 4));

        final JButton Bone = new JButton("1");
        final JButton Btwo = new JButton("2");
        final JButton Bthree = new JButton("3");
        final JButton Bans = new JButton("Ans");
        TFCalcBox = new JTextField();
        TFCalcBox.setPreferredSize(new Dimension(365, 40));
        final JButton Bfour = new JButton("4");
        final JButton Bfive = new JButton("5");
        final JButton Bsix = new JButton("6");
        final JButton Bac = new JButton("AC");

        final JButton Bseven = new JButton("7");
        final JButton Beight = new JButton("8");
        final JButton Bnine = new JButton("9");
        final JButton Bcut = new JButton("C");

        final JButton Bzero = new JButton("0");
        final JButton Bpoint = new JButton(".");
        final JButton Bplus = new JButton("+");
        final JButton Bequal = new JButton("=");

        final JButton Bminus = new JButton("-");
        final JButton Bmultiple = new JButton("/");
        final JButton Bproduct = new JButton("*");
        final JButton Bexit = new JButton("EXIT");

        P2.add(Bone);
        P2.add(Btwo);
        P2.add(Bthree);
        P2.add(Bans);

        P2.add(Bfour);
        P2.add(Bfive);
        P2.add(Bsix);
        P2.add(Bac);

        P2.add(Bseven);
        P2.add(Beight);
        P2.add(Bnine);
        P2.add(Bcut);

        P2.add(Bzero);
        P2.add(Bpoint);
        P2.add(Bplus);
        P2.add(Bequal);

        P2.add(Bminus);
        P2.add(Bmultiple);
        P2.add(Bproduct);
        P2.add(Bexit);

        JPanel P1 = new JPanel();
        P1.add(TFCalcBox);
        add(P1, BorderLayout.NORTH);
        add(P2, BorderLayout.CENTER); // ****
        setTitle("Basic Calculator");
        // this.pack();
        setSize(380, 450);
        setVisible(true);
        setLocation(600, 150);
        setResizable(false);

        Bone.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("1");
            }
        });

        Btwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("2");
            }
        });

        Bthree.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("3");
            }
        });

        Bfour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("4");
            }
        });

        Bfive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("5");
            }
        });

        Bsix.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("6");
            }
        });

        Bseven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("7");
            }
        });

        Beight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("8");
            }
        });

        Bnine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("9");
            }
        });

        Bzero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod("0");
            }
        });

        Bplus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText("+");
                CalcMethod1("+");
            }
        });

        Bminus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText("-");
                CalcMethod1("-");
            }
        });

        Bmultiple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText("/");
                CalcMethod1("/");
            }
        });

        Bproduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText("*");
                CalcMethod1("*");
            }
        });

        Bequal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText("=");
                AfterEqual = 1;
                SymbolMark = 0;
                CalcMethod2();
                Calculation();
            }
        });

        Bac.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MethodForACbutton();
            }
        });

        Bcut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MethodForCutButton();
            }
        });

        Bpoint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SaveMethod(".");
            }
        });

        Bexit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Bans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TFCalcBox.setText(printAnswer);
                Ans = AnswerHalf;
                AfterAnswer = 1;
            }
        });
    }

    public static void main(String[] args) {
        new AA();
    }
}