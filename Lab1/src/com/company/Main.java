package com.company;
import java.util.Scanner;

class Task1{
    Scanner scan = new Scanner(System.in);
    double x1, y1, x2, y2, x3, y3;
    void start() {
        System.out.print("Enter the coordinates of point A\nx: ");
        x1 = scan.nextDouble();
        System.out.print("y: ");
        y1 = scan.nextDouble();
        System.out.print("Enter the coordinates of point B\nx: ");
        x2 = scan.nextDouble();
        System.out.print("y: ");
        y2 = scan.nextDouble();
        if (x1 != x2 && y1 != y2) {
            x3 = (x1 + x2) / 2;
            y3 = (y1 + y2) / 2;
            System.out.println("Coordinates of the middle of the segment AB\nx: " + x3 + "; y: " + y3 + ";\n");
        }
        else
            System.out.println("The points coincide!\n");
    }
}

class Task2{
    Scanner scan = new Scanner(System.in);
    double x, y, z;
    void start() {
        System.out.print("Enter x: ");
        x = scan.nextDouble();
        System.out.print("Enter y: ");
        y = scan.nextDouble();
        System.out.print("Enter z: ");
        z = scan.nextDouble();
        while (x < y || y < z || x < z) {
            if (x < y) {
                x = x + y;
                y = x - y;
                x = x - y;
            } else {
                y = y + z;
                z = y - z;
                y = y - z;
            }
        }
        System.out.println("x = " + x + "; y = " + y + "; z = " + z + ";\n");
    }
}

class Task3{
    Scanner scan = new Scanner(System.in);
    int x, y, number;
    void start() {
        System.out.print("Enter x: ");
        x = scan.nextInt();
        System.out.print("Enter y (y > x): ");
        y = scan.nextInt();
        while (y <= x) {
            System.out.print("Enter y (y > x): ");
            y = scan.nextInt();
        }
        for (number = 0; x <= y; x++, number++)
            System.out.println(x);
        System.out.println("Number: " + number + "\n");
    }
}

class Task4{
    Scanner scan = new Scanner(System.in);
    int size, arr[], num0, num1, num2, num3;
    void start() {
        num0 = 0;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        System.out.print("Enter size: ");
        size = scan.nextInt();
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 4);
            System.out.println(arr[i]);
            if (arr[i] == 0)
                num0++;
            if (arr[i] == 1)
                num1++;
            if (arr[i] == 2)
                num2++;
            if (arr[i] == 3)
                num3++;
        }
        System.out.println("Number of zeros: " + num0 + "\nNumber of units: " + num1 +"\nNumber of twos: " + num2 +"\nNumber of threes: " + num3 + "\n");
    }
}

class Task5{
    Scanner scan = new Scanner(System.in);
    byte number;
    class Triangle{
        double x1, y1, x2, y2, x3, y3, s;
        void SetAndCount(){
            System.out.print("First point\nEnter x: ");
            x1 = scan.nextDouble();
            System.out.print("Enter y: ");
            y1 = scan.nextDouble();
            System.out.print("Second point\nEnter x: ");
            x2 = scan.nextDouble();
            System.out.print("Enter y: ");
            y2 = scan.nextDouble();
            System.out.print("Third point\nEnter x: ");
            x3 = scan.nextDouble();
            System.out.print("Enter y: ");
            y3 = scan.nextDouble();
            while ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x3 == x2 && y3 == y2)) {
                System.out.println("This is not a triangle!");
                System.out.print("First point\nEnter x: ");
                x1 = scan.nextDouble();
                System.out.print("Enter y: ");
                y1 = scan.nextDouble();
                System.out.print("Second point\nEnter x: ");
                x2 = scan.nextDouble();
                System.out.print("Enter y: ");
                y2 = scan.nextDouble();
                System.out.print("Third point\nEnter x: ");
                x3 = scan.nextDouble();
                System.out.print("Enter y: ");
                y3 = scan.nextDouble();
            }
            s = Math.abs((x1-x3) * (y2-y3) - (x2-x3) * (y1-y3)) / 2;
        }
    }
    void start(){
        System.out.println("Triangle 1");
        Triangle triangle1 = new Triangle(), triangle2 = new Triangle(), triangle3 = new Triangle();
        triangle1.SetAndCount();
        System.out.println("Triangle 2");
        triangle2.SetAndCount();
        System.out.println("Triangle 3");
        triangle3.SetAndCount();
        if (triangle1.s == triangle2.s && triangle1.s > triangle3.s) {
            System.out.println("Triangles 1 & 2 has the largest area\n");
            number = -1;
        }
        else if (triangle1.s == triangle3.s && triangle1.s > triangle2.s) {
            System.out.println("Triangles 1 & 3 has the largest area\n");
            number = -1;
        }
        else if (triangle3.s == triangle2.s && triangle3.s > triangle1.s) {
            System.out.println("Triangles 2 & 3 has the largest area\n");
            number = -1;
        }
        else if (triangle1.s > triangle2.s && triangle1.s > triangle3.s)
            number = 1;
        else if (triangle2.s > triangle1.s && triangle2.s > triangle3.s)
            number = 2;
        else if (triangle1.s == triangle2.s && triangle3.s == triangle2.s)
            number = 0;
        else
            number  = 3;
        if (number != 0 && number != -1)
            System.out.println("Triangle " + number + " has the largest area\n");
        else if (number == 0)
            System.out.println("Areas are the same\n");
        //System.out.println(triangle1.s + " " + triangle2.s + " " + triangle3.s);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        Task5 task5 = new Task5();
        while (choice != 0) {
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to complete the first task\n" +
                    "Enter \"2\" to complete the second task\n" +
                    "Enter \"3\" to complete the third task\n" +
                    "Enter \"4\" to complete the fourth task\n" +
                    "Enter \"5\" to complete the fifth task");
            choice = scan.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    task1.start();
                    break;
                case 2:
                    task2.start();
                    break;
                case 3:
                    task3.start();
                    break;
                case 4:
                    task4.start();
                    break;
                case 5:
                    task5.start();
                    break;
                default:
                    System.out.println("Enter the correct value!");
            }
        }
    }
}