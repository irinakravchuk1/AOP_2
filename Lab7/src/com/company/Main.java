package com.company;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame {
    Button b1;
    Label l1, l2;
    TextField country1, country2, country3, area1, area2, area3;
    Main(String name){
        super(name);
        setSize(600, 350);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
        setBackground(Color.ORANGE);
        setFont(new Font("Arial", Font.PLAIN, 20));
        b1 = new Button("ОК");
        l1 = new Label("Назва країни", Label.LEFT);
        l2 = new Label("Її площа (км^2)", Label.LEFT);
        country1 = new TextField();
        country2 = new TextField();
        country3 = new TextField();
        area1 = new TextField();
        area2 = new TextField();
        area3 = new TextField();
        l1.setBounds(30, 50, 160, 30);
        l2.setBounds(300, 50, 200, 30);
        country1.setBounds(30, 100, 200, 30);
        country2.setBounds(30, 150, 200, 30);
        country3.setBounds(30, 200, 200, 30);
        area1.setBounds(300, 100, 200, 30);
        area2.setBounds(300, 150, 200, 30);
        area3.setBounds(300, 200, 200, 30);
        b1.setBounds(250, 270, 100, 40);
        b1.setBackground(new Color(232, 232, 232));
        b1.addActionListener(new ButtonPress());
        add(l1);
        add(l2);
        add(country1);
        add(country2);
        add(country3);
        add(area1);
        add(area2);
        add(area3);
        add(b1);
    }
    class ButtonPress implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            String c1 = "0", c2 = "0", c3 = "0";

            //Знаходження значення найменшої площі
            int min = Integer.parseInt(area1.getText());
            if (Integer.parseInt(area2.getText()) < min)
                min = Integer.parseInt(area2.getText());
            else if (Integer.parseInt(area3.getText()) < min)
                min = Integer.parseInt(area3.getText());

            //Присвоєння відповідних значень
            if (min == Integer.parseInt(area1.getText()))
                c1 = country1.getText();
            if (min == Integer.parseInt(area2.getText()))
                c2 = country2.getText();
            if (min == Integer.parseInt(area3.getText()))
                c3 = country3.getText();

            //Створення нового вікна
            new NewFrame("Друга форма", c1, c2, c3);
        }
    }
    public static void main(String[] args) {
        Frame f = new Main("Lab7");
    }
}

class NewFrame extends Frame {
Label l, l1, l2, l3;
    NewFrame(String name, String country1,  String country2, String country3){
        super(name);
        setVisible(true);
        setLayout(null);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
        setBackground(Color.ORANGE);
        setFont(new Font("Arial", Font.BOLD, 25));
        l = new Label("Країна(-и) з найменшою площею", Label.CENTER);
        l.setBounds(100, 50, 400, 30);
        l.setFont(new Font("Arial", Font.PLAIN, 25));
        add(l);
        int y = 100;
        if (country1 != "0"){
            l1 = new Label(country1, Label.LEFT);
            l1.setBounds(30, y, 200, 30);
            add(l1);
            y+=50;
        }
        if (country2 != "0"){
            l2 = new Label(country2, Label.LEFT);
            l2.setBounds(30, y, 200, 30);
            add(l2);
            y+=50;
        }
        if (country3 != "0"){
            l3 = new Label(country3, Label.LEFT);
            l3.setBounds(30, y, 200, 30);
            add(l3);
            y+=50;
        }
        setSize(600, y);
    }
}