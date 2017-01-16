package com.test;

import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class JTreeDemoA extends JFrame {

    private static final long serialVersionUID = -4142468464529147078L;

    public JTreeDemoA() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(383, 412);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 351, 317);
        getContentPane().add(scrollPane);
        String[] s1 = { "张一", "张二" };
        String[] s2 = { "王二", "李四" };
        Hashtable<String, String[]> hashtable1 = new Hashtable<String, String[]>();
        hashtable1.put("家人", s1);
        hashtable1.put("朋友", s2);
        JTree tree = new JTree(hashtable1);
        scrollPane.setViewportView(tree);
        JButton btnFlash = new JButton("刷新");
        btnFlash.setBounds(12, 352, 93, 23);
        getContentPane().add(btnFlash);
        JButton btnQuit = new JButton("退出");
        btnQuit.setBounds(270, 352, 93, 23);
        getContentPane().add(btnQuit);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JTreeDemoA();
    }
}