package com.company;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    private Connection connection;
    private Statement statement;
    private PreparedStatement ps;
    private UserData userData;
    private JTable userTable;
    private JButton buttonAdd, buttonRemove;
    private String del, add, col;
    private JScrollPane jsp;

    public Main() {
        initConnection();
        buildUI();
        loadDataFromDB();
        buttonAdd = new JButton("Додати нульовий запис");
        buttonRemove = new JButton("Видалити останній запис");

        this.userData.fireTableDataChanged();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    statement.close();
                    connection.close();
                }
                catch (SQLException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
        });
        setVisible(true);
        add(buttonRemove, BorderLayout.LINE_START);
        add(buttonAdd, BorderLayout.LINE_END);

        buttonRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                del = ("DELETE FROM PostOffice WHERE NUM = '" + userData.getRowCount() + "'");
                try {
                    statement.executeUpdate(del);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                loadDataFromDB();
                userTable = new JTable(userData);
                getContentPane().remove(jsp);
                jsp = new JScrollPane(userTable);
                getContentPane().add(jsp, BorderLayout.CENTER);
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                col = Integer.toString(userData.getRowCount() + 1);
                add = ("INSERT INTO PostOffice " + "VALUES ('" + "0" + "','" +
                        "0" + "','" + "0" + "','" + "0" + "','" + col + "')");
                try {
                    statement.executeUpdate(add);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                loadDataFromDB();
                userTable = new JTable(userData);
                getContentPane().remove(jsp);
                jsp = new JScrollPane(userTable);
                getContentPane().add(jsp, BorderLayout.CENTER);
            }
        });
    }

    private void initConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:ucanaccess://d:/Прога/AoП/java/ForLab9/MyDataBaseForLab9.accdb");
            statement = connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildUI() {
        setSize(1100, 200);
        setTitle("Post Offices");
        getContentPane().setLayout(new BorderLayout());
        this.userData = new UserData();
        this.userTable = new JTable(userData);
        jsp = new JScrollPane(userTable);
        getContentPane().add(jsp, BorderLayout.CENTER);
    }

    private void loadDataFromDB() {
        this.userData.alData.clear();
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PostOffice");
            while (resultSet.next()) {
                String num = resultSet.getString(5);
                String city = resultSet.getString(1);
                String departmentsAmount = resultSet.getString(2);
                String employeesAmount = resultSet.getString(3);
                String profit = resultSet.getString(4);
                RowAddress r = new RowAddress(num, city, departmentsAmount, employeesAmount, profit);
                this.userData.alData.add(r);
            }
            resultSet.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    class RowAddress {
        String num;
        String city;
        String departmentsAmount;
        String employeesAmount;
        String profit;

        public RowAddress(String num, String city, String departmentsAmount, String employeesAmount, String profit) {
            this.num = num;
            this.city = city;
            this.departmentsAmount = departmentsAmount;
            this.employeesAmount = employeesAmount;
            this.profit = profit;
        }
    }

    class UserData extends AbstractTableModel {
        String columns[] = {"Номер", "Місто", "Кількість відділень", "Кількість співробітників", "Річний прибуток (млн)"};
        public List alData = new ArrayList();

        public int getColumnCount() {
            return columns.length;
        }

        public Object getValueAt(int nRow, int nCol) {
            if (nRow <0 || nRow > this.alData.size()) {
                return null;
            }
            RowAddress rowAddress = (RowAddress) this.alData.get(nRow);
            switch (nCol) {
                case 0:
                    return rowAddress.num;
                case 1:
                    return rowAddress.city;
                case 2:
                    return rowAddress.departmentsAmount;
                case 3:
                    return rowAddress.employeesAmount;
                case 4:
                    return rowAddress.profit;
            }
            return "";
        }

        public int getRowCount() {
            return alData == null ? 0 : alData.size();
        }

        public String getColumnName(int column) {
            return columns[column];
        }

        public boolean isCellEditable(int nRow, int nCol) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
