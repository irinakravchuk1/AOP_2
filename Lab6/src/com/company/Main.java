package com.company;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;

public class Main extends Frame{
    private Label l1;
    private CheckboxGroup group;
    private Checkbox ch1, ch2, ch3;
    private Font radioButtonFont;
    private int font = 1, r = 0, g = 0, b = 0, style = 0, size = 30;
    Main(String name, int width, int height){
        super (name);
        setSize(width, height);
        setLayout(null);
        setVisible(true);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent ev){
                System.exit (0);
            }
        });
        group = new CheckboxGroup();
        radioButtonFont = new Font("Arial", Font.BOLD, 12);
        ch1 = new Checkbox("Змінити шрифт", group, true);
        ch2 = new Checkbox("Змінити колір шрифту", group, false);
        ch3 = new Checkbox("Змінити стиль шрифту", group, false);
        ch1.setBounds(20, 350, 150, 30);
        ch1.setState(true);
        ch2.setBounds(190, 350, 150, 30);
        ch3.setBounds(360, 350, 150, 30);
        ch1.setFont(radioButtonFont);
        ch2.setFont(radioButtonFont);
        ch3.setFont(radioButtonFont);
        add(ch1);
        add(ch2);
        add(ch3);
        l1 = new Label("Магічний напис", Label.CENTER);
        l1.setBounds(90, 160, 350, 50);
        l1.setForeground(new Color(r, g, b));
        l1.setFont(new Font("Arial", style, size));
        add(l1);
        ch1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                font++;
                if (font == 4)
                    font = 1;
                switch(font){
                    case 1:
                        l1.setFont(new Font(Font.DIALOG, style, size));
                        break;
                    case 2:
                        l1.setFont(new Font(Font.MONOSPACED, style, size));
                        break;
                    case 3:
                        l1.setFont(new Font(Font.SERIF, style, size));
                }
            }
        });
        ch2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r =  (int)(Math.random() * 256);
                g =  (int)(Math.random() * 256);
                b =  (int)(Math.random() * 256);
                l1.setForeground(new Color(r, g, b));
            }
        });
        ch3.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                style++;
                if (style == 4)
                    style = 0;
                switch(font){
                    case 1:
                        l1.setFont(new Font(Font.DIALOG, style, size));
                        break;
                    case 2:
                        l1.setFont(new Font(Font.MONOSPACED, style, size));
                        break;
                    case 3:
                        l1.setFont(new Font(Font.SERIF, style, size));
                }
            }
        });
    }
    public static void main(String[] args) {
        Frame f = new Main("Напис", 530, 400);
    }
}