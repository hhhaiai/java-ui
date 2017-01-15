/**
 * 
 */
package com.test;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

/**
 * @Copyright © 2017 sanbo Inc. All rights reserved.
 * @Description: 
 * @Version: 1.0
 * @Create: 2017年1月14日 上午1:24:23
 * @Author: sanbo
 */
public class TreeDemo extends JFrame {
    private static final long serialVersionUID = 6436788551900883001L;
    // 增加带滚动条容器
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTree tree;
    private JPopupMenu popMenu;

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JPopupMenu getPopMenu() {
        return popMenu;
    }

    public void setPopMenu(JPopupMenu popMenu) {
        this.popMenu = popMenu;
    }

    public static void main(String[] args) {
        new TreeDemo();
    }

    public TreeDemo() {

        try {
            init();
            treeInit();
            popMenuInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        this.setSize(800, 600);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // 退出时需要终止当前jvm
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 设置当前窗口的信息
    private void init() {
        getContentPane().setLayout(null);
        setTitle("树操作");
    }

    // 初始化景点分类树
    public void treeInit() {
        if (jScrollPane1 != null) {
            this.remove(jScrollPane1);
        }
        jScrollPane1.setBounds(new Rectangle(0, 0, 800, 600));
        jScrollPane1.setAutoscrolls(true);
        this.getContentPane().add(jScrollPane1);
        expandTree();
        tree.addMouseListener(new TreePopMenuEvent(this));
        this.repaint();
    }

    // 右键点击分类导航树的菜单
    private void popMenuInit() {
        popMenu = new JPopupMenu();
        JMenuItem addItem = new JMenuItem("添加");
        addItem.addActionListener(new TreeAddViewMenuEvent(this));
        JMenuItem delItem = new JMenuItem("删除");
        delItem.addActionListener(new TreeDeleteViewMenuEvent(this));
        JMenuItem modifyItem = new JMenuItem("修改");
        modifyItem.addActionListener(new TreeModifyViewMenuEvent(this));
        popMenu.add(addItem);
        popMenu.add(delItem);
        popMenu.add(modifyItem);
    }

    /**
     * 完全展开一个JTree
     *
     * @param tree
     *            JTree
     */
    public void expandTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("根节点");
        tree = new JTree(root);

        tree.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) { // 选中菜单节点的事件
                System.out.println("选中菜单节点的事件");
//                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            }
        });
        tree.updateUI();
        jScrollPane1.getViewport().add(tree);
    }

    /**
     * 获取图片文件内容
     *
     * @param fileName
     * @return
     */
    public Image getImage(String fileName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ByteBuffer bb = ByteBuffer.allocate(1024 * 1024);
            byte[] buffer = new byte[1];
            while (bis.read(buffer) > 0) {
                bb.put(buffer);
            }
            ImageIcon icon = new ImageIcon(bb.array());
            return icon.getImage();
        } catch (IOException ex) {
            Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public JTree getTree() {
        return tree;
    }

    /**
     * popmenu点击右键的增加处理
     */
    class TreeAddViewMenuEvent implements ActionListener {

        private TreeDemo adaptee;

        public TreeAddViewMenuEvent(TreeDemo adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            String name = JOptionPane.showInputDialog("请输入分类节点名称：");
            DefaultMutableTreeNode treenode = new DefaultMutableTreeNode(name);
            ((DefaultMutableTreeNode) this.adaptee.getTree().getLastSelectedPathComponent()).add(treenode);
            this.adaptee.getTree().expandPath(new TreePath(
                    ((DefaultMutableTreeNode) this.adaptee.getTree().getLastSelectedPathComponent()).getPath()));
            this.adaptee.getTree().updateUI();
        }
    }

    /**
     * popmenu点击右键的删除处理
     */
    class TreeDeleteViewMenuEvent implements ActionListener {

        private TreeDemo adaptee;

        public TreeDeleteViewMenuEvent(TreeDemo adaptee) {
            this.adaptee = adaptee;
        }

        public void actionPerformed(ActionEvent e) {
            int conform = JOptionPane.showConfirmDialog(null, "是否确认删除？", "删除景点确认", JOptionPane.YES_NO_OPTION);
            if (conform == JOptionPane.YES_OPTION) {
//                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) (((DefaultMutableTreeNode) this.adaptee
//                        .getTree().getLastSelectedPathComponent()).getParent());
                ((DefaultMutableTreeNode) this.adaptee
                        .getTree().getLastSelectedPathComponent()).getParent();
                ((DefaultMutableTreeNode) this.adaptee.getTree().getLastSelectedPathComponent()).removeFromParent();
                this.adaptee.getTree().updateUI();
            }
        }
    }
}

/**
 * popmenu点击右键的修改处理
 */
class TreeModifyViewMenuEvent implements ActionListener {

    private TreeDemo adaptee;

    public TreeModifyViewMenuEvent(TreeDemo adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        String name = JOptionPane.showInputDialog("请输入新分类节点名称：");

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) this.adaptee.getTree().getSelectionPath()
                .getLastPathComponent();
        // 改名
        node.setUserObject(name);
        // 刷新
        this.adaptee.getTree().updateUI();
    }
}

/**
 * 菜单点击右键的事件处理
 */
class TreePopMenuEvent implements MouseListener {

    private TreeDemo adaptee;

    public TreePopMenuEvent(TreeDemo adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        TreePath path = adaptee.getTree().getPathForLocation(e.getX(), e.getY()); // 关键是这个方法的使用
        if (path == null) {
            return;
        }
        adaptee.getTree().setSelectionPath(path);
        if (e.getButton() == 3) {
            adaptee.getPopMenu().show(adaptee.getTree(), e.getX(), e.getY());
        }
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//            TreeDemo userframe = new TreeDemo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TreeDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
