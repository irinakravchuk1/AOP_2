package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{
    Main(String name){
        super(name);
        setSize(615, 435);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
        Font f1 = new Font("Cambria", Font.BOLD | Font.ITALIC, 24);
        Font f2 = new Font("Cambria", Font.BOLD, 18);
        Font f3 = new Font("Cambria", Font.PLAIN, 15);
        Font f4 = new Font("Cambria", Font.ITALIC, 14);
        Font f5 = new Font("Cambria", Font.PLAIN, 22);

        setBackground(new Color(221, 231, 200));
        setFont(f3);

        Label l1 = new Label("Оформлення замовлення", Label.LEFT);
        l1.setFont(f1);
        l1.setBounds(40, 50, 350, 30);
        l1.setForeground(new Color(0, 133, 1));
        add(l1);

        Label l2 = new Label("Контактні дані", Label.LEFT);
        l2.setFont(f2);
        l2.setBounds(95, 95, 150, 30);
        add(l2);

        Label l3 = new Label("Прізвище та ім'я", Label.RIGHT);
        l3.setFont(f3);
        l3.setBounds(65, 145, 115, 30);
        add(l3);
        TextField tf1 = new TextField();
        tf1.setBounds(190, 145, 340, 30);
        add(tf1);

        Label l4 = new Label("Місто", Label.RIGHT);
        l4.setFont(f3);
        l4.setBounds(65, 190, 115, 30);
        add(l4);
        Choice ch = new Choice();
        ch.setFont(f5);
        ch.setBounds(190, 190, 200,30);
        add(ch);

        Label l5 = new Label("Телефон", Label.RIGHT);
        l5.setFont(f3);
        l5.setBounds(65, 235, 115, 30);
        add(l5);
        TextField tf2 = new TextField();
        tf2.setBounds(190, 235, 300, 30);
        add(tf2);

        Label l6 = new Label("E-mail", Label.RIGHT);
        l6.setFont(f3);
        l6.setBounds(65, 280, 115, 30);
        add(l6);
        TextField tf3 = new TextField();
        tf3.setBounds(190, 280, 300, 30);
        add(tf3);

        Checkbox ch1 = new Checkbox(" Я хочу отримувати розсилку інтернет-магазину To4ka");
        ch1.setBounds(40, 365, 400, 20);
        ch1.setFont(f4);
        ch1.setState(true);
        add(ch1);

        Button b1 = new Button("ОК");
        b1.setBounds(474, 379, 123, 38);
        b1.setFont(f2);
        b1.setBackground(new Color(220, 220, 220));
        add(b1);
    }
    public void paint(Graphics g){
        g.setColor(new Color(78, 114, 62));
        g.fillRect(30, 125, 500, 4);
        Image img = new ImageIcon("1.jpg").getImage();
        g.drawImage(img, 520, 40,80,80, null);
    }
    public static void main(String[] args) {
        Frame f = new Main("Оформлення замовлення");
        /*String fonts[]
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }*/
    }
}