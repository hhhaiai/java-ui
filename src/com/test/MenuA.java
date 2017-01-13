/**
 * 
 */
package com.test;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月14日 上午12:56:24
 * @Author: sanbo
 */
public class MenuA {
    public static void main(String[] args) {
        int WIDTH = 800, HEIGHT = 600;
        JFrame f = new JFrame("menu 测试");
        Container c = f.getContentPane();
        JPanel p = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        c.add(p);
        f.setJMenuBar(menuBar);
        JMenu menu = new JMenu("文件");
        JMenuItem itemA = new JMenuItem("子菜单1");
        JMenuItem itemB = new JMenuItem("子菜单2");
        JMenuItem itemC = new JMenuItem("子菜单3");
        menu.add(itemA);
        // menu.addSeparator();//增加行下面的分割线
        menu.add(itemB);
        // menu.addSeparator();//增加行下面的分割线
        menu.add(itemC);
        menuBar.add(menu);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(WIDTH, HEIGHT);
        f.setSize(WIDTH, HEIGHT);
        f.setVisible(true);
    }

}
