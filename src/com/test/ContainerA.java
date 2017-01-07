/**
 * 
 */
package com.test;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: TODO
 * @Version: 1.0
 * @Create: 2017年1月7日 下午3:15:40
 * @Author: sanbo
 */
public class ContainerA {
    public static void main(String[] args) {
        JFrame f = new JFrame("demo");
        Image i = new ImageIcon("src/res/icon.jpg").getImage();
        f.setIconImage(i);
        f.setBackground(Color.GREEN);
        f.setSize(200, 150);
        f.setLocation(300, 200);
        f.setUndecorated(false);
        f.setVisible(true);
    }

}
