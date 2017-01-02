/**
 * 
 */
package com.test;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月2日 下午8:44:14
 * @Author: sanbo
 */
public class C {
    public static void main(String[] args) {
        Frame mf = new Frame("FlowLayoutDemo01");
        mf.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        Button bt1 = new Button("East");
        Button bt2 = new Button("South");
        Button bt3 = new Button("West");
        Button bt4 = new Button("North");
        Button bt5 = new Button("Center");
        mf.setFont(new Font("宋体", Font.PLAIN, 14));
        mf.add(bt1);
        mf.add(bt2);
        mf.add(bt3);
        mf.add(bt4);
        mf.add(bt5);

        mf.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }

        });
        mf.setSize(new Dimension(350, 100));
        mf.setLocation(new Point(450, 50));
        mf.setVisible(true);
    }
}
