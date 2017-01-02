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
 * @Description: 这是比较好的一种方法
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:51:19
 * @Author: sanbo
 */
public class Event2 extends JFrame {

    private static final long serialVersionUID = 4406539625913270156L;
    private JButton btBlue, btDialog;

    // 构造方法
    public Event2() {
        // 设置标题栏内容
        setTitle("Java GUI 事件监听处理");
        // 设置初始化窗口位置
        setBounds(100, 100, 500, 350);
        // 设置窗口布局
        setLayout(new FlowLayout());
        // 创建按钮对象
        btBlue = new JButton("蓝色");
        // 添加事件监听器(此处即为匿名类)
        btBlue.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获得容器，设置容器背景颜色
                Container c = getContentPane();
                c.setBackground(Color.BLUE);
            }
        });
        // 创建按钮对象,并添加事件监听器
        btDialog = new JButton("弹窗");
        btDialog.addActionListener(new ActionListener() {
            // 事件处理
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建JDialog窗口对象
                JDialog dialog = new JDialog();
                dialog.setBounds(300, 200, 400, 300);
                dialog.setVisible(true);
            }
        });

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
        new Event2();
    }

}