/**
 * 
 */
package com.test.key;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 监听
 * @Version: 1.0
 * @Create: 2017年1月7日 下午5:17:05
 * @Author: sanbo
 */
public class Ek {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.addKeyListener(new KeyListener() {

            // 在键入键时调用
            @Override
            public void keyTyped(KeyEvent e) {
                String s = "[KeyChar:" + e.getKeyChar() + "-----KeyText:" + KeyEvent.getKeyText(e.getKeyCode()) + "]";
                System.out.println("keyTyped--->" + s);
            }

            // 在按下键时调用
            @Override
            public void keyReleased(KeyEvent e) {
                String s = "[KeyChar:" + e.getKeyChar() + "-----KeyText:" + KeyEvent.getKeyText(e.getKeyCode()) + "]";
                System.out.println("keyReleased--->" + s);
            }

            // 在释放键时调用
            @Override
            public void keyPressed(KeyEvent e) {
                String s = "[KeyChar:" + e.getKeyChar() + "-----KeyText:" + KeyEvent.getKeyText(e.getKeyCode()) + "]";
                System.out.println("keyPressed--->" + s);
            }
        });
        f.setAlwaysOnTop(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}
