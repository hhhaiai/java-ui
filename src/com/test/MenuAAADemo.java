/**
 * 
 */
package com.test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月14日 上午12:39:33
 * @Author: sanbo
 */
public class MenuAAADemo {

    public static void main(String[] args) {
        try { // try语句块，监视该段程序
              // 设置窗口风格
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        } catch (Exception e) { // 捕获异常
            e.printStackTrace(); // 异常信息输出
        }
        int WIDTH = 800, HEIGHT = 600;
        JFrame f = new JFrame("为了学习进行测试");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menubar1 = new JMenuBar();

        JPanel p = new JPanel();

        f.setContentPane(p);

        f.setJMenuBar(menubar1);

        JMenu menu1 = new JMenu("菜单1");

        JMenu menu2 = new JMenu("菜单2");

        JMenu menu3 = new JMenu("菜单3");

        JMenu menu4 = new JMenu("菜单4");

        JMenu menu5 = new JMenu("菜单5");

        menubar1.add(menu1);

        menubar1.add(menu2);

        menubar1.add(menu3);

        menubar1.add(menu4);

        menubar1.add(menu5);

        JMenuItem item1 = new JMenuItem("子菜单1");

        JMenuItem item2 = new JMenuItem("子菜单2");

        JMenuItem item3 = new JMenuItem("子菜单3");

        JMenuItem item4 = new JMenuItem("子菜单4");

        JMenuItem item5 = new JMenuItem("子菜单5");

        JMenuItem item6 = new JMenuItem("子菜单6");

        JMenuItem item7 = new JMenuItem("子菜单7");

        JMenuItem item8 = new JMenuItem("子菜单8");

        JMenuItem item9 = new JMenuItem("子菜单9");

        JMenuItem item10 = new JMenuItem("子菜单10");

        JMenuItem item11 = new JMenuItem("子菜单11");

        JMenuItem item12 = new JMenuItem("子菜单12");

        menu1.add(item1);

        menu1.addSeparator();

        menu1.add(item2);

        menu1.addSeparator();

        menu1.add(item3);

        menu2.add(item4);

        menu2.addSeparator();

        menu2.add(item5);

        menu3.add(item6);

        menu3.addSeparator();

        menu3.add(item7);

        menu4.add(item8);

        menu4.addSeparator();

        menu4.add(item9);

        menu4.addSeparator();

        menu4.add(item10);

        menu5.add(item11);

        menu5.addSeparator();

        menu5.add(item12);

        JButton button1 = new JButton("工具1");

        JButton button2 = new JButton("工具2");

        JButton button3 = new JButton("工具3");

        JToolBar bar = new JToolBar();

        bar.add(button1);

        bar.add(button2);

        bar.add(button3);

        BorderLayout bord = new BorderLayout();

        p.setLayout(bord);

        p.add("North", bar);

        f.setVisible(true);

        f.setSize(WIDTH, HEIGHT);

        Toolkit kit = Toolkit.getDefaultToolkit();

        Dimension screenSize = kit.getScreenSize();

        int width = screenSize.width;

        int height = screenSize.height;

        int x = (width - WIDTH) / 2;

        int y = (height - HEIGHT) / 2;

        f.setLocation(x, y);
    }

}
