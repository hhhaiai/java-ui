package com.test;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//首先导入Swing 需要的包
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description:Javax.swing 包中有顶层容器和轻量级两种类型的组件,Swing 轻量级的组件都是由 AWT 的Container
 *                          类来直接或者是间接派生而来的.
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:56:30
 * @Author: sanbo
 */
public class HelloWorld {
    // 创建主方法
    public static void main(String[] args) {
        try { // try语句块，监视该段程序
              // 设置窗口风格
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) { // 捕获异常
            e.printStackTrace(); // 异常信息输出
        }
        // 创建顶层容器并初始化
        JFrame frame = new JFrame("Swing 第一个示例");
        // 获取面板容器
        Container c = frame.getContentPane();
        // 创建面板panel 并初始化
        JPanel pane = new JPanel();
        // 将面板添加到窗口
        c.add(pane);
        // 设置布局管理器FlowLayout
        pane.setLayout(new FlowLayout());
        // 创建标签label 并初始化
        final JLabel label = new JLabel();
        // 创建button 并初始化
        JButton button = new JButton("按钮");
        // 向容器中添加组件label
        pane.add(label);
        // 向容器中添加组件button
        pane.add(button);
        // 对按钮事件的处理方法
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 设置label 显示的内容
                label.setText("HelloWorld！");
            }
        });
        // 窗口设置结束，开始显示
        frame.addWindowListener(new WindowAdapter() {
            // 匿名类用于注册监听器
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } // 程序退出
        });
        // 设置窗口大小
        // frame.setSize(300, 240);
        // 设置窗口宽300*高240
        frame.setSize(new Dimension(300, 240));
        // 设置窗口初始化位置（窗口右上角的坐标为x=450,y=250)
        frame.setLocation(new Point(450, 250));

        // 显示窗口
        frame.setVisible(true);
    }
}
