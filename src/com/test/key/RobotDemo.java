/**
 * 
 */
package com.test.key;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: java.awt.Robot点击事件
 * @Version: 1.0
 * @Create: 2017年1月7日 下午7:13:11
 * @Author: sanbo
 */
public class RobotDemo {

    public static void main(String[] args) {
        try {
            Robot r = new Robot();
            // 设置每次输入的延迟为200ms
            r.setAutoDelay(200);
            // 打出一个大写的Q
            r.keyPress(KeyEvent.VK_SHIFT); // 模拟键盘按下shift键
            r.keyPress(KeyEvent.VK_Q); // 模拟键盘按下Q键（小写）
            r.keyRelease(KeyEvent.VK_Q); // 模拟键盘释放Q键
            r.keyRelease(KeyEvent.VK_SHIFT); // 模拟键盘释放shift键
            // 移动鼠标到坐标（x,y)处，并点击左键
            r.mouseMove(300, 1050); // 移动鼠标到坐标（x,y）处
            r.mousePress(KeyEvent.BUTTON1_DOWN_MASK); // 模拟按下鼠标左键
            r.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK); // 模拟释放鼠标左键
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
