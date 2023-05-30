package com.company;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{
    Main(String name, int width, int height){
        super (name);
        setSize(width, height);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        //лінія х
        g.drawLine(50, 380, 550, 380);

        g.drawLine(550, 380, 545, 375);
        g.drawLine(550, 380, 545, 385);

        g.drawLine(150, 375, 150, 385);
        g.drawLine(250, 375, 250, 385);
        g.drawLine(350, 375, 350, 385);
        g.drawLine(450, 375, 450, 385);
        //лінія у
        g.drawLine(50, 50, 50, 380);

        g.drawLine(50, 50, 55, 55);
        g.drawLine(50, 50, 45, 55);

        g.drawLine(45, 80, 55, 80);
        g.drawLine(45, 110, 55, 110);
        g.drawLine(45, 140, 55, 140);
        g.drawLine(45, 170, 55, 170);
        g.drawLine(45, 200, 55, 200);
        g.drawLine(45, 230, 55, 230);
        g.drawLine(45, 260, 55, 260);
        g.drawLine(45, 290, 55, 290);
        g.drawLine(45, 320, 55, 320);
        g.drawLine(45, 350, 55, 350);
        //крива
        g.drawLine(150, 260, 250, 140);
        g.drawLine(250, 140, 350, 260);
        g.drawLine(350, 260, 450, 290);
        //успішність
        g.setColor(Color.red);
        g.setFont(new Font("14Red", Font.BOLD, 14));

        g.drawString("Відмінно", 118, 400);
        g.drawString("Добре", 227, 400);
        g.drawString("Задовільно", 310, 400);
        g.drawString("Незадовільно", 403, 400);
        //кількість
        g.drawString("10", 25, 85);
        g.drawString("9", 32, 115);
        g.drawString("8", 32, 145);
        g.drawString("7", 32, 175);
        g.drawString("6", 32, 205);
        g.drawString("5", 32, 235);
        g.drawString("4", 32, 265);
        g.drawString("3", 32, 295);
        g.drawString("2", 32, 325);
        g.drawString("1", 32, 355);
        //написи
        g.drawString("4", 145, 274);
        g.drawString("8", 245, 137);
        g.drawString("4", 345, 274);
        g.drawString("3", 445, 304);
    }
    public static void main(String[] args) {
        new Main("Графік успішності студентів",600,440);
    }
}