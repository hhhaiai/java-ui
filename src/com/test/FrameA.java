/**
 * 
 */
package com.test;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月7日 下午2:30:23
 * @Author: sanbo
 */
public class FrameA extends JFrame {
    private static final long serialVersionUID = -1275713735423779159L;

    public FrameA() {
        super("FrameA 不知道是什么");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        Image image = new ImageIcon("src/res/icon.jpg").getImage();
        setIconImage(image);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrameA();
    }

}
