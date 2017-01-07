package com.xnx3.demo;

import java.awt.event.KeyEvent;
import java.util.List;

import com.xnx3.media.ColorUtil;
import com.xnx3.robot.Robot;
import com.xnx3.robot.support.CoordBean;

/**
 * 纯Java，跨平台，模拟按键、鼠标点击、找图、找色，实现简单按键精灵的功能
 * 
 * @author 管雷鸣
 */
public class RobotDemo {

    public static void main(String[] args) {
        simple();
        colorCompare();
        imageSearch();
    }

    /**
     * 鼠标、键盘、延迟等基本操作
     */
    public static void simple() {
        Robot robot = new Robot();

        robot.delay(1000); // 延迟等待1秒
        robot.mouseRightClick(400, 400); // 点击鼠标右键
        robot.delay(300); // 延迟等待0.3秒
        robot.mouseLeftClick(400, 400); // 点击鼠标左键
        robot.press(KeyEvent.VK_H); // 按h键
        robot.press(KeyEvent.VK_SHIFT, KeyEvent.VK_CONTROL); // 按下SHIFT键后又按下CTRL键
    }

    /**
     * 点的颜色比较
     */
    public static void colorCompare() {
        Robot robot = new Robot();
        // 获取屏幕上某点颜色
        java.awt.Color color = robot.getPixelColor(100, 100);
        System.out.println("当前点的颜色值：" + ColorUtil.colorToHex(color));

        // 判断屏幕上制定点的颜色是否跟指定颜色相匹配（近似相等）
        boolean b = robot.getColorCompare(100, 100, "EBF1F9", Robot.SIM_ACCURATE);
        System.out.println("匹配颜色相似度：" + (b ? "相似" : "不相似"));
    }

    /**
     * 图片搜索 为提高搜索的精确度，推荐使用配套工具截图
     * https://github.com/xnx3/xnx3/blob/master/ScreenCapture.jar?raw=true
     */
    public static void imageSearch() {
        Robot robot = new Robot();
        robot.setSourcePath(RobotDemo.class); // 设置此处是为了让程序能自动找到要搜索的图片文件。图片文件在当前类下的res文件夹内

        // 在当前屏幕上搜索search.png图片，看起是否存在
        List<CoordBean> list1 = robot.imageSearch("search.png", Robot.SIM_ACCURATE);
        System.out.println(list1.size() > 0 ? "搜索到了" + list1.size() + "个目标" : "没搜索到");
        if (list1.size() > 0) {
            for (int i = 0; i < list1.size(); i++) {
                CoordBean coord = list1.get(i);
                System.out.println("搜索到的第" + (i + 1) + "个坐标：x:" + coord.getX() + ",y:" + coord.getY());
            }
        }

        // 在屏幕上指定的区域：左上方x100，y100， 右下方x300，y300的范围内搜索多个图像
        List<CoordBean> list2 = robot.imageSearch(100, 100, 300, 300, "search.png|L.png", Robot.SIM_BLUR_VERY);
        System.out.println(list2.size() > 0 ? "搜索到了" + list2.size() + "个目标" : "没搜索到");
        if (list2.size() > 0) {
            for (int i = 0; i < list2.size(); i++) {
                CoordBean coord = list2.get(i);
                System.out.println("搜索到的第" + (i + 1) + "个坐标：x:" + coord.getX() + ",y:" + coord.getY());
            }
        }
    }

}
