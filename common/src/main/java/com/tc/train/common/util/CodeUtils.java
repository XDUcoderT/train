package com.tc.train.common.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CodeUtils {
    //验证码字符集
    private static final char[] chars = {'1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z'
    };
    //字符数量
    public static final int SIZE = 4;
    //干扰线数量
    public static final int LINES = 4;
    //图片宽度
    public static final int WIDTH = 200;
    //图片高度
    public static final int HEIGHT = 60;
    //字体大小
    public static final int FONT_SIZE = 30;

    public static Random random = new Random();

    /**
     * 返回验证码字符串和图片BufferedImage对象
     * @return
     */
    public static Object[] createImage(){
        StringBuffer stringBuffer = new StringBuffer();
        //创建空白图片
        BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
        //获取图片画笔
        Graphics graphics = image.getGraphics();
        //设置画笔颜色
        graphics.setColor(Color.LIGHT_GRAY);
        //绘制矩形背景
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        //画随机字符
        for (int i = 0; i < SIZE; i++) {
            //获取随机字符串索引
            int n = random.nextInt(chars.length);
            //设置随机颜色
            graphics.setColor(getRandomColor());
            //设置字体大小
            graphics.setFont(new Font(null, Font.BOLD + Font.ITALIC,FONT_SIZE));
            //绘制字符
            graphics.drawString(chars[n]+"", i * WIDTH/SIZE, HEIGHT*2/3);
            //记录字符
            stringBuffer.append(chars[n]);
        }
        //画干扰线
        for (int i = 0; i < LINES; i++) {
            //设置随机颜色
            graphics.setColor(getRandomColor());
            //随机画线
            graphics.drawLine(random.nextInt(WIDTH),random.nextInt(HEIGHT),random.nextInt(WIDTH),random.nextInt(HEIGHT));
        }
        //返回验证码和图片
        return new Object[]{stringBuffer.toString(),image};
    }

    /**
     * 随机取色
     * @return
     */
    public static Color getRandomColor(){
        Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
        return color;
    }
}