/**
 * 
 */
package com.test;

import java.awt.Container;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 自身类实现ActionListener接口,作为事件监听器
 * @Version: 1.0
 * @Create: 2017年1月2日 下午8:49:14
 * @Author: sanbo
 */
public class Event {
    public static void main(String[] args) {
        JFrame f = new JFrame("这是一个按钮");
        Container contentPane = f.getContentPane();
        JButton b = new JButton("按钮");// 创建一个带初始文本的按钮
        // 如果没有设置文字的位置，系统默认值会将文字置于图形的右边中间位置
        // 设置文本相对于图标的水平方向的位置
        b.setHorizontalTextPosition(JButton.CENTER);
        // 设置文本相对于图标的垂直方向的位置
        b.setVerticalTextPosition(JButton.BOTTOM);
        contentPane.add(b);
        f.pack();
        f.setLocation(new Point(700, 300));
        // f.show();
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
