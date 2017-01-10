/**
 * 
 */
package com.test;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description:
 * 
 *               <pre>
 *              Swing 中的按钮是Jbutton，它是javax.swing.AbstracButton 类的子类，Swing
 *               中的按钮可以 显示图像，并且可以将按钮设置为窗口的默认图标，而且还可以将多个图像指定给一个按钮。 在前面的HelloWorld
 *               例子中就是用到了一个按钮。Jbutton 类的继承关系如下： 
 *               java.lang.Object
 *                  +--java.awt.Component 
 *                      +--java.awt.Container
 *                          +--javax.swing.JComponent 
 *                              +--javax.swing.AbstractButton
 *                                  +--javax.swing.JButton
 *               在Jbutton 中有如下几个比较常用的构造方。
 *                  JButton(Icon icon) ：按钮上显示图标。
 *                  JButton(String text)：按钮上显示字符。
 *                  JButton(String text, Icon icon)：按钮上既显示图标又显示字符。
 *               </pre>
 * 
 * @Version: 1.0
 * @Create: 2017年1月2日 下午9:59:47
 * @Author: sanbo
 */
public class JButtontest {
    public static void main(String[] args) {
        JFrame f = new JFrame("这是一个按钮");
        Container contentPane = f.getContentPane();
        // 创建一个带初始文本的按钮
        JButton b = new JButton("按钮");
        // 如果没有设置文字的位置，系统默认值会将文字置于图形的右边中间位置
        // 设置文本相对于图标的水平方向的位置
        b.setHorizontalTextPosition(JButton.CENTER);
        // 设置文本相对于图标的垂直方向的位置
        b.setVerticalTextPosition(JButton.BOTTOM);
        contentPane.add(b);
        f.pack();
        f.setSize(200, 120);
        f.setLocation(300, 200);
        // f.show();//不推荐方法
        f.setVisible(true);
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("你点击了新的窗口");
            }
        });
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}