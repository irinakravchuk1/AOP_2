//у текстовий файл треба вводити числа від 0 до 20 через перехід на наступний рядок(\n)
package com.company;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Main extends Frame{
    private int[]daysTemperature;
    private static final File file  = new File ("INPUT.txt");
    private static FileReader fileReader;
    private String[]days = new String[]{"Пн", "Вт", "Ср", "Чт", "Пт", "Сб", "Нд"};

    public Main(String name, int[]daysTemperature) {
        super (name);
        setSize(500, 440);
        setResizable(false);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
        this.daysTemperature = daysTemperature;
    }

    public void paint(Graphics g){
        g.setColor(Color.black);

        //лінія х
        int x = 50;
        g.drawLine(x, 380, x + 400, 380);
        //стрілка
        g.drawLine(x + 400, 380, x + 395, 375);
        g.drawLine(x + 400, 380, x + 395, 385);
        //Розмітка
        for (int xCopy = x + 50; xCopy < x + 400; xCopy+=50)
            g.drawLine(xCopy, 375, xCopy, 385);
        //Маркеровка
        x = 93;
        for (int i = 0; i < 7; i++){
            g.drawString(days[i], x, 400);
            x+=50;
        }

        //лінія у
        int y = 50;
        g.drawLine(50, y, 50, y + 330);
        //стрілка
        g.drawLine(50, y, 55, y + 5);
        g.drawLine(50, y, 45, y + 5);
        //Розмітка
        for (y = 65; y < 380; y += 15)
            g.drawLine(45, y, 55, y);
        //Маркеровка
        y = 70;
        for (int t = 20; t >= 0; t--) {
            g.drawString(String.valueOf(t), 30, y);
            y+=15;
        }

        //крива
        x = 100;
        for (int i = 0; i < 6; i++){
            g.drawLine(x, 65 + 15 * (20 - daysTemperature[i]), x + 50, 65 + 15 * (20 - daysTemperature[i + 1]));
            x+=50;
        }
    }
    public static void main(String[] args) throws IOException {
        fileReader = new FileReader(file);

        //масив для зчитування інформації з файла
        char[] information = new char[100];
        fileReader.read(information);

        //конвертуємо чар масив у стрінг
        String value = new String(information), valueClean = "";

        //позбавляємось сміття
        for (int i = 0; i < value.length(); i++) {
            if ((Character.isLetterOrDigit(value.charAt(i))) || (value.charAt(i) == '\n'))
                valueClean += value.charAt(i);
        }

        //розділяємо рядок на масив
        String strDaysTemp[] = valueClean.split("\n");

        //конвертуємо у int
        int[]daysTemp = new int[strDaysTemp.length];
        for (int i = 0; i < strDaysTemp.length; i++) {
            daysTemp[i] = Integer.parseInt(strDaysTemp[i]);
        }

        new Main("Графік погоди(Температура)", daysTemp);
    }
}
