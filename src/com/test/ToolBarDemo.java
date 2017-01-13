/**
 * 
 */
package com.test;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 工具栏设置
 * @Version: 1.0
 * @Create: 2017年1月14日 上午1:04:42
 * @Author: sanbo
 */
public class ToolBarDemo {

    public static void main(String[] args) {
        int WIDTH = 800, HEIGHT = 600;
        JFrame f = new JFrame("menu 测试");
        Container c = f.getContentPane();
        JPanel p = new JPanel();
        JButton button1 = new JButton("工具1");

        JButton button2 = new JButton("工具2");
        JButton button3 = new JButton("工具3");
        JToolBar bar = new JToolBar();
        bar.add(button1);
        bar.add(button2);
        bar.add(button3);
        BorderLayout bord = new BorderLayout();
        p.setLayout(bord);
        p.add("North", bar);// 上面一排左边
        // p.add("South",bar);//最下面一排左边
        // p.add("East", bar);//右侧全屏
        // p.add("West", bar);//左侧全屏
        // p.add(bar);//全部窗口
        c.add(p);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(WIDTH, HEIGHT);
        f.setLocation(WIDTH, HEIGHT);
        f.setVisible(true);
    }
}
