package com.test;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 Umeng Inc. All rights reserved.
 * @Description: 组合框
 * @Version: 1.0
 * @Create: 2017年1月12日 上午11:23:11
 * @Author: sanbo
 */
public class JComboBoxTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame jf = new JFrame("JComboBox demo");
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Container cp = jf.getContentPane();
                cp.setLayout(new GridLayout(1, 2));
                String[] str = { "故宫", "泰山", "张家界", "颐和园", "孔府" };
                Vector<String> vector = new Vector<String>();
                vector.addElement("北京");
                vector.addElement("上海");
                vector.addElement("青岛");
                vector.addElement("广州");
                vector.addElement("成都");
                vector.addElement("西安");
                JComboBox<String> combo1 = new JComboBox<String>(str); // 定义一个JComboBox对象
                // 利用 JComboBox 类所提供的 addItem()方法,加入一个项目到此 JComboBox 中。
                combo1.addItem("天堂");
                // 创建一个带有指定标题的标题框
                combo1.setBorder(BorderFactory.createTitledBorder("你想去哪个景点游点玩?"));
                JComboBox<String> combo2 = new JComboBox<String>(vector);
                combo2.setBorder(BorderFactory.createTitledBorder("你喜欢的城市"));
                cp.add(combo1);
                cp.add(combo2);
                jf.pack();
                jf.setVisible(true);
                jf.addWindowListener(new WindowAdapter() { // 添加窗口监听器
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
    }
}