/**
 * 
 */
package com.test;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 窗口居中设置尺寸的功能
 * @Version: 1.0
 * @Create: 2017年1月14日 上午1:11:56
 * @Author: sanbo
 */
public class CentFrame {

    public static void main(String[] args) {
        int WIDTH = 800, HEIGHT = 600;
        JFrame f = new JFrame("menu 测试");
        f.pack();// 这个必须在设置窗口尺寸之前,不然就是默认大小
        f.setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        int x = (width - WIDTH) / 2;
        int y = (height - HEIGHT) / 2;
        f.setLocation(x, y);
        f.setVisible(true);
    }
}
