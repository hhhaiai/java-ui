/**
 * 
 */
package com.test;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 该种方法更符合面向对象编程的思想
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:52:42
 * @Author: sanbo
 */
public class Event3 extends JFrame {

    private static final long serialVersionUID = -1584859002315344561L;
    private JButton btBlue, btDialog;

    // 构造方法
    public Event3() {
        // 设置标题栏内容
        setTitle("Java GUI 事件监听处理");
        // 设置初始化窗口位置
        setBounds(100, 100, 500, 350);
        // 设置窗口布局
        setLayout(new FlowLayout());
        // 创建按钮对象
        btBlue = new JButton("蓝色");
        // 添加事件监听器对象(面向对象思想)
        btBlue.addActionListener(new ColorEventListener());
        btDialog = new JButton("弹窗");
        btDialog.addActionListener(new DialogEventListener());
        // 把按钮容器添加到JFrame容器上
        add(btBlue);
        add(btDialog);
        // 设置窗口可视化
        setVisible(true);
        // 设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 内部类ColorEventListener，实现ActionListener接口
    class ColorEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Container c = getContentPane();
            c.setBackground(Color.BLUE);
        }

    }

    // 内部类DialogEventListener，实现ActionListener接口
    class DialogEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // 创建JDialog窗口对象
            JDialog dialog = new JDialog();
            dialog.setBounds(300, 200, 400, 300);
            dialog.setVisible(true);
        }

    }

    // ***************************主方法***************************
    public static void main(String[] args) {
        new Event3();
    }

}