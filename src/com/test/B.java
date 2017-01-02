/**
 * 
 */
package com.test;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月2日 下午8:43:32
 * @Author: sanbo
 */
public class B {
    public static void main(String[] args) {
        Frame mf = new Frame("BorderLayoutDemo01");
        mf.setLayout(new BorderLayout(20, 10));
        // 定义五个按钮对象，按钮上文本分别为East，South，West，North，Center
        Button bt1 = new Button("East");
        Button bt2 = new Button("South");
        Button bt3 = new Button("West");
        Button bt4 = new Button("North");
        Button bt5 = new Button("Center");

        mf.setFont(new Font("宋体", Font.PLAIN, 14));// 设置窗体使用的字体为宋体，普通文本，字体大小为14
        // 将按钮添加到Frame窗口
        mf.add(bt1, "East");
        mf.add(bt2, "South");
        mf.add(bt3, "West");
        mf.add(bt4, "North");
        mf.add(bt5, "Center");
        // 设置关闭窗口同时终止应用程序
        mf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });
        // 设置窗口宽200，高200
        mf.setSize(new Dimension(200, 200));
        // 设置窗口初始化位置（窗口右上角的坐标为x=450,y=50)
        mf.setLocation(new Point(450, 50));
        // 显示窗口
        mf.setVisible(true);
    }
}
