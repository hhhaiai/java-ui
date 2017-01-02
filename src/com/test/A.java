/**
 * 
 */
package com.test;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: GUI(图形用户界面) Graphical User Interface(图形用户接口)
 *               用图形的方式,来显示计算机操作的界面,这样更方便更直观. CLI Command Line User
 *               Interface(命令行用户接口) 就是常用的Dos命令行操作. 需要记忆一些常用的命令.操作更直观. 举例:
 *               比如:创建文件夹,或者删除文件夹等 md haha del haha
 * 
 *               Java的GUI提供的对象都存在 java.Awt 和 javax.Swing 两个包中. java.Awt:Abstract
 *               Window ToolKit(抽象 窗口工具包) 需要调用本地系统方法实现功能.属重量级控件 (跨平台不够强)
 *               java.Swing:在AWT的基础上,建立的一套图形界面系统,器重提供了更多的组件,
 *               而且完全由java实现,增强了移植性,属于轻量级控件.(跨平台很好) java.swt: IBM 公司开发 Eclipse
 *               用的组件工具 可以Eclipse网站下载后就可以使用了. 布局管理器 1)容器中的组件的排放方式,就是布局.
 *               2)常见的布局管理器 FlowLayout(流式布局管理器) 从左到右的顺序排列 Panel默认的布局管理器
 *               BorderLayout(辩解布局管理器) 东 南 西 北 中 Frame 默认的布局管理器 不指定布局方式,默认
 *               满屏覆盖,在添加一个 也是 满屏覆盖 GridLayout (网格布局管理器) 规则的矩阵 CardLayout
 *               (卡片布局管理器) 选项卡 GridBagLayout(网格包布局管理器) 非规则的矩阵 事件监听机制组成 事件源:
 *               事件:Event 监听器:Listener 时间处理:(引发事件后处理方式)
 * 
 *               事件源:就是awt包或者swing包中的那些图像界面组件. 事件:每个事件源都有自己特定的对应时间和共性时间.
 *               监听器:可以出发某一个事件的动作都已经封装到监听器中.
 * @Version: 1.0
 * @Create: 2017年1月2日 下午8:36:12
 * @Author: sanbo
 */

public class A {
    public static void main(String[] args) {
        Frame f = new Frame("my awt");
        f.setSize(500, 400);
        f.setLocation(300, 200);
        f.setLayout(new FlowLayout());
        Button b = new Button("Button");
        f.add(b);
        f.addWindowListener(new MyWin());

        f.setVisible(true);
        System.out.println("Hello world!");
    }

}

// 因为接口WindowLinstener中的所有方法都被子类 WindowAdapter实现了,.
// 并且覆盖了其中的所有方法,那么我们只能继承 WindowAdapter 覆盖我们的方法即可
class MyWin extends WindowAdapter {

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("我关了");
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        // 每次获得焦点 就会触发
        System.out.println("我活了");
        super.windowActivated(e);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("我开了");
        super.windowOpened(e);
    }

}
