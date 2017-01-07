/**
 * 
 */
package com.test.key;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 监听
 * @Version: 1.0
 * @Create: 2017年1月7日 下午5:14:47
 * @Author: sanbo
 */
public class KeyDemo {
    // 定义该图形中所需的组件的引用
    private Frame f;
    private Button bt;
    private TextField tf;

    // 方法
    KeyDemo()// 构造方法
    {
        madeFrame();
    }

    public void madeFrame() {
        f = new Frame("My Frame");

        // 对Frame进行基本设置。
        f.setBounds(300, 100, 600, 500);// 对框架的位置和大小进行设置
        f.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));// 设计布局

        bt = new Button("My Button");
        tf = new TextField(20);

        // 将组件添加到Frame中
        f.add(tf);
        f.add(bt);

        // 加载一下窗体上的事件
        myEvent();

        // 显示窗体
        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter()// 窗口监听
        {
            public void windowClosing(WindowEvent e) {
                System.out.println("窗体执行关闭！");
                System.exit(0);
            }
        });
        bt.addKeyListener(new KeyAdapter()// 键盘监听按钮
        {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                    System.exit(0);
                // 组合键
                else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_ENTER)
                    System.exit(0);
                else
                    System.out.println(e.getKeyChar() + "..." + KeyEvent.getKeyText(e.getKeyCode()));
            }

        });
        tf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (!(code >= KeyEvent.VK_0 && code <= KeyEvent.VK_9)) {
                    System.out.println(code + "..." + "是非法的");
                    e.consume();
                }
            }
        });
    }

    public static void main(String[] agrs) {
        new KeyDemo();
    }
}