package com.company;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame{
    private Label l;
    private PopupMenu menu;
    private MenuItem type, colour, style;
    private int font = 1, r = 0, g = 0, b = 0, fontStyle = 0, size = 30;
    Main(String name, int width, int height) {
        super(name);
        setSize(width, height);
        setLayout(null);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(0);
            }
        });
        enableEvents(AWTEvent.MOUSE_EVENT_MASK|AWTEvent.MOUSE_MOTION_EVENT_MASK);

        l = new Label("Магічний напис", Label.CENTER);
        l.setBounds(90, 150, 350, 50);
        l.setForeground(new Color(r, g, b));
        l.setFont(new Font(Font.DIALOG, fontStyle, size));
        add(l);

        menu = new PopupMenu("Контекстне меню");
        add(menu);
        type = new MenuItem("Змініти тип шрифту");
        colour = new MenuItem("Змініти колір шрифту");
        style = new MenuItem("Змініти стиль шрифту");
        menu.add(type);
        menu.add(colour);
        menu.add(style);

        type.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                font++;
                if (font == 4)
                    font = 1;
                switch(font) {
                    case 1:
                        l.setFont(new Font(Font.DIALOG, fontStyle, size));
                        break;
                    case 2:
                        l.setFont(new Font(Font.MONOSPACED, fontStyle, size));
                        break;
                    case 3:
                        l.setFont(new Font(Font.SERIF, fontStyle, size));
                }
            }
        });
        colour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r =  (int)(Math.random() * 256);
                g =  (int)(Math.random() * 256);
                b =  (int)(Math.random() * 256);
                l.setForeground(new Color(r, g, b));
            }
        });
        style.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontStyle++;
                if (fontStyle == 4)
                    fontStyle = 0;
                switch(font){
                    case 1:
                        l.setFont(new Font(Font.DIALOG, fontStyle, size));
                        break;
                    case 2:
                        l.setFont(new Font(Font.MONOSPACED, fontStyle, size));
                        break;
                    case 3:
                        l.setFont(new Font(Font.SERIF, fontStyle, size));
                }
            }
        });
    }
    public void processMouseEvent(MouseEvent e) {
        if (e.isPopupTrigger())
            menu.show(e.getComponent(), e.getX(), e.getY());
    }
        public static void main(String[] args) {
        Frame f = new Main("Lab_8", 530, 350);
    }
}
