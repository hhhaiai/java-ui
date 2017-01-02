/**
 * 
 */
package com.test;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月2日 下午8:44:36
 * @Author: sanbo
 */
public class D {
    public static void main(String[] args) {
        Frame mf = new Frame("GridLayoutDemo01");
        mf.setLayout(new GridLayout(3, 2, 10, 10));// 定义一个3行2列，控件间水平距离为10，垂直距离为10
        Button bt1 = new Button("East");
        Button bt2 = new Button("South");
        Button bt3 = new Button("West");
        Button bt4 = new Button("North");
        Button bt5 = new Button("Center");
        mf.setFont(new Font("宋体", Font.PLAIN, 14));

        mf.add(bt1, "East");
        mf.add(bt2, "South");
        mf.add(bt3, "West");
        mf.add(bt4, "North");
        mf.add(bt5, "Center");

        mf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });
        mf.setSize(new Dimension(200, 200));
        mf.setLocation(new Point(450, 50));
        mf.setVisible(true);
    }

}
