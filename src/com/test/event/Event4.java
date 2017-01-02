/**
 * 
 */
package com.test.event;

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
 * @Description: 通过外部类处理
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:54:02
 * @Author: sanbo
 */
public class Event4 extends JFrame {

    private static final long serialVersionUID = 8443743484865165862L;
    private JButton btBlue, btDialog;

    // 构造方法
    public Event4() {
        // 设置标题栏内容
        setTitle("Java GUI 事件监听处理");
        // 设置初始化窗口位置
        setBounds(100, 100, 500, 350);
        // 设置窗口布局
        setLayout(new FlowLayout());
        // 创建按钮对象
        btBlue = new JButton("蓝色");
        // 将按钮添加事件监听器
        btBlue.addActionListener(new ColorEventListener(this));
        // 创建按钮对象
        btDialog = new JButton("弹窗");
        // 将按钮添加事件监听器
        btDialog.addActionListener(new DialogEventListener());
        // 把按钮容器添加到JFrame容器上
        add(btBlue);
        add(btDialog);
        // 设置窗口可视化
        setVisible(true);
        // 设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ***************************主方法***************************
    public static void main(String[] args) {
        new Event4();
    }

}

// 外部类ColorEventListener，实现ActionListener接口
class ColorEventListener implements ActionListener {

    private Event4 el;

    ColorEventListener(Event4 el) {
        this.el = el;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Container c = el.getContentPane();
        c.setBackground(Color.BLUE);
    }

}

// 外部类DialogEventListener，实现ActionListener接口
class DialogEventListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // 创建JDialog窗口对象
        JDialog dialog = new JDialog();
        dialog.setBounds(300, 200, 400, 300);
        dialog.setVisible(true);
    }

}