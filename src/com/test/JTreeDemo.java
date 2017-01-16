package com.test;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;

public class JTreeDemo {
    public static void main(String[] args) {

        JFrame f = new JFrame("树示例"); // 创建窗体
        // 设置用户在此窗体上发起 "close" 时默认执行的操作
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane();
        Box box = Box.createHorizontalBox(); // 创建 Box 类对象
        JTree tree1 = new JTree(); // 创建树
        tree1.putClientProperty("JTree.lineStyle", "Angled"); // 向此组件添加任意的键/值
        JScrollPane scrollPane1 = new JScrollPane(tree1);
        tree1.setAutoscrolls(true);
        // JTree tree2 = new JTree();
        // JScrollPane scrollPane2 = new JScrollPane(tree2);
        // 向 Box 容器添加滚动面板
        box.add(scrollPane1, BorderLayout.WEST);
        // 创建一个滚动面板

        // box.add(scrollPane2, BorderLayout.EAST);
        f.getContentPane().add(box, BorderLayout.CENTER);
        f.setSize(300, 240);
        f.setVisible(true);
    }
}