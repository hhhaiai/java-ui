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
 * @Description:
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:41:33
 * @Author: sanbo
 */
public class But extends JFrame implements ActionListener {

    private static final long serialVersionUID = -403091149133837076L;
    private JButton btBlue, btDialog;

    // 构造方法
    public But() {
        // 设置标题栏内容
        setTitle("Java GUI 事件监听处理");
        // 设置初始化窗口位置
        setBounds(100, 100, 500, 350);
        // 设置窗口布局
        setLayout(new FlowLayout());

        // 创建按钮对象
        btBlue = new JButton("蓝色");
        // 将按钮添加事件监听器
        btBlue.addActionListener(this);
        // 把按钮容器添加到JFrame容器上
        add(btBlue);

        // 创建按钮对象
        btDialog = new JButton("弹窗");
        // 将按钮添加事件监听器
        btDialog.addActionListener(this);
        // 把按钮容器添加到JFrame容器上
        add(btDialog);
        // 设置窗口可视化
        setVisible(true);
        // 设置窗口关闭
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ***************************事件处理***************************
    @Override
    public void actionPerformed(ActionEvent e) {
        // 判断最初发生Event事件的对象
        if (e.getSource() == btBlue) {
            // 获得容器
            Container c = getContentPane();
            // 设置容器背景颜色
            c.setBackground(Color.BLUE);
        } else if (e.getSource() == btDialog) {
            // 创建JDialog窗口对象
            JDialog dialog = new JDialog();
            dialog.setBounds(300, 200, 400, 300);
            dialog.setVisible(true);
        }
    }

    // ***************************主方法***************************
    public static void main(String[] args) {
        new But();
    }
}