package com.test;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameDemo {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setTitle("中文");
        /**
         * <pre>
         *  设置默认的关闭时的操作，取值
         * DO_NOTHING_ON_CLOSE
         * HIDE_ON_CLOSE
         * DISPOSE_ON_CLOSE
         * EXIT_ON_CLOSE //点击对话框的关闭,直接关闭后台进程
         * 
         * </pre>
         */
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * <pre>
         * 设置扩展的状态，取值: 
         * NORMAL 
         * ICONIFIED 
         * MAXIMIZED_HORIZ 
         * MAXIMIZED_VERT
         * MAXIMIZED_BOTH //最大化
         * </pre>
         */
        f.setExtendedState(JFrame.MAXIMIZED_HORIZ);
        f.setIconImage(new ImageIcon("src/res/icon.jpg").getImage());
        // 向JFrame容器增加组建
        Container con = f.getContentPane();
        JPanel pa = new JPanel();
        JButton btn = new JButton("我类个去");
        pa.add(btn);
        con.add(pa);

        f.setSize(200, 200);
        f.setLocation(200, 200);
        f.setVisible(true);
        System.out.println(f.getSize().toString());
    }

}
