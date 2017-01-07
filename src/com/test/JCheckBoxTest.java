/**
 * 
 */
package com.test;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 复选框
 * @Version: 1.0
 * @Create: 2017年1月7日 下午4:30:25
 * @Author: sanbo
 */
public class JCheckBoxTest implements ItemListener {
    private List<String> list = new ArrayList<String>();

    public JCheckBoxTest() {

        JFrame f = new JFrame("复选框");
        Container c = f.getContentPane();
        c.setLayout(new GridLayout(2, 1));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 3));
        p1.setBorder(BorderFactory.createTitledBorder("选择你喜欢的城市？"));
        JCheckBox c1 = new JCheckBox("北京");
        JCheckBox c2 = new JCheckBox("青岛");
        JCheckBox c3 = new JCheckBox("上海");
        c1.setMnemonic(KeyEvent.VK_1);// 快捷键ALT+1
        c2.setMnemonic(KeyEvent.VK_2);// 快捷键ALT+2
        c3.setMnemonic(KeyEvent.VK_3);// 快捷键ALT+3
        c1.setSelected(false);// 设置默认选择
        c2.setSelected(false);// 设置默认选择
        c3.setSelected(false);// 设置默认选择
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        p1.add(c1);
        p1.add(c2);
        p1.add(c3);
        p1.setSize(150, 180);
        c.add(p1);
        JButton btn = new JButton("确定");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (list.size() <= 0) {
                    JOptionPane.showMessageDialog(null, "你什么也没选择...", "结果", JOptionPane.PLAIN_MESSAGE);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("你选择了");
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(list.get(i)).append("、");
                    }
                    String s = sb.toString();
                    JOptionPane.showMessageDialog(null, s.substring(0, s.length() - 1), "结果",
                            JOptionPane.PLAIN_MESSAGE);

                    // showMessageDialog提示样式：
                    // JOptionPane.showMessageDialog(null, "你选择了：" +
                    // ((JCheckBox)
                    // e.getSource()).getText(), "标题",
                    // JOptionPane.INFORMATION_MESSAGE);
                    // showMessageDialog错误样式：
                    // JOptionPane.showMessageDialog(null, "文字", "标题",
                    // JOptionPane.ERROR_MESSAGE);
                    // showMessageDialog问号样式：
                    // JOptionPane.showMessageDialog(null, "文字", "标题",
                    // JOptionPane.QUESTION_MESSAGE);
                    // showMessageDialog普通样式：
                    // JOptionPane.showMessageDialog(null, "你选择了：" +
                    // ((JCheckBox)
                    // e.getSource()).getText(), "提示框来了~",
                    // JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        btn.setMnemonic(KeyEvent.VK_ENTER);
        c.add(btn);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 200);
        f.setLocation(400, 250);
        f.setVisible(true);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.toString());
        JCheckBox jb = (JCheckBox) e.getSource();
        if (jb.isSelected()) {
            String s = jb.getText();
            if (!list.contains(s)) {
                list.add(s);
            }
        } else {
            String s = jb.getText();
            if (list.contains(s)) {
                list.remove(s);
            }
        }
    }

    public static void main(String[] args) {
        new JCheckBoxTest();
    }

}
