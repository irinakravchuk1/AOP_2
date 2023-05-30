package com.company;
import java.util.Scanner;

class Task1{
    private Scanner scan = new Scanner(System.in);
    private double x1, y1, x2, y2;
    public Task1 (){
        System.out.print("Enter the coordinates of point A\nx: ");
        x1 = scan.nextDouble();
        System.out.print("y: ");
        y1 = scan.nextDouble();
        System.out.print("Enter the coordinates of point B\nx: ");
        x2 = scan.nextDouble();
        System.out.print("y: ");
        y2 = scan.nextDouble();
    }

    public Task1 (double x1, double x2, double y1, double y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double averageX(){
        return (x1 + x2) / 2;
    }

    public double averageY(){
        return (y1 + y2) / 2;
    }

    public void printResult(){
        if (averageX() != 0 && averageY() != 0)
            System.out.println("Coordinates of the middle of the segment AB\nx: " + averageX() + "; y: " + averageY() + ";\n");
        else
            System.out.println("The points coincide!\n");
    }
} //ready

class Task2{
    private Scanner scan = new Scanner(System.in);
    private double x, y, z;
    public Task2(){
        System.out.print("Enter x: ");
        x = scan.nextDouble();
        System.out.print("Enter y: ");
        y = scan.nextDouble();
        System.out.print("Enter z: ");
        z = scan.nextDouble();
    }

    public Task2(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private void sort(){
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
    }

    public double getX(){
        sort();
        return x;
    }

    public double getY(){
        sort();
        return y;
    }

    public double getZ(){
        sort();
        return z;
    }

    public void printResult() {
        System.out.println("x = " + getX() + "; y = " + getY() + "; z = " + getZ() + ";\n");
    }
} //ready

class Task3{
    private Scanner scan = new Scanner(System.in);
    private int x, y;

    public Task3(){
        System.out.print("Enter x: ");
        x = scan.nextInt();
        System.out.print("Enter y (y > x): ");
        y = scan.nextInt();
        while (y <= x) {
            System.out.print("Enter y (y > x): ");
            y = scan.nextInt();
        }
    }

    public Task3(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getNumber(){
        int number, xCopy = x + 1;
        for (number = 0; xCopy < y; xCopy++) {
            number++;
        }
        return number;
    }

    public int[] getNumbers(){
        int[]numbers = new int[getNumber()];
        int xCopy = x + 1;
        for (int i = 0; xCopy < y; xCopy++, i++)
            numbers[i] = xCopy;
        return numbers;
    }

    public void printResult(){
        int[]numbers = getNumbers();
        System.out.println(x);
        for (int i = 0; i < numbers.length; i++)
            System.out.println(numbers[i]);
        System.out.println(y);
        System.out.println("Number: " + getNumber() + "\n");
    }
} //ready

class Task4{
    private Scanner scan = new Scanner(System.in);
    private int arr[];

    public Task4(){
        System.out.print("Enter size: ");
        arr = new int[scan.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 4);
        }
    }

    public Task4(int []arr) {
        this.arr = arr;
    }

    public int getNum0(){
        int num0 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                num0++;
        }
        return num0;
    }

    public int getNum1(){
        int num1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
                num1++;
        }
        return num1;
    }

    public int getNum2(){
        int num2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2)
                num2++;
        }
        return num2;
    }

    public int getNum3(){
        int num3 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3)
                num3++;
        }
        return num3;
    }

    public void printResult() {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
        System.out.println("Number of zeros: " + getNum0() + "\nNumber of units: " + getNum1() +
                "\nNumber of twos: " + getNum2() +"\nNumber of threes: " + getNum3() + "\n");
    }
} //ready

class Task5{
    private Scanner scan = new Scanner(System.in);
    private byte number;
    private class Triangle{
        double x1, y1, x2, y2, x3, y3;

        public Triangle(){
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
        }

        public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }

        public double getSquare(){
            return Math.abs((x1-x3) * (y2-y3) - (x2-x3) * (y1-y3)) / 2;
        }
    }
    private Triangle triangle1, triangle2, triangle3;

    public Task5(){
        System.out.println("Triangle 1");
        triangle1 = new Triangle();
        System.out.println("Triangle 2");
        triangle2 = new Triangle();
        System.out.println("Triangle 3");
        triangle3 = new Triangle();
    }

    public Task5(double x11, double x12, double x13, double x21, double x22, double x23, double x31, double x32, double x33,
                 double y11, double y12, double y13, double y21, double y22, double y23, double y31, double y32, double y33){
        triangle1 = new Triangle(x11, y11, x12, y12, x13, y13);
        triangle2 = new Triangle(x21, y21, x22, y22, x23, y23);
        triangle3 = new Triangle(x31, y31, x32, y32, x33, y33);
    }

    public double getMaxSquare(){
        double maxS = triangle1.getSquare();
        if (triangle2.getSquare() > maxS)
            maxS = triangle2.getSquare();
        if (triangle3.getSquare() > maxS)
            maxS = triangle3.getSquare();
        return maxS;
    }

    public void printResult(){
        if (triangle1.getSquare() == getMaxSquare())
            System.out.println("Triangle 1 has the largest area");
        if (triangle2.getSquare() == getMaxSquare())
            System.out.println("Triangle 2 has the largest area");
        if (triangle3.getSquare() == getMaxSquare())
            System.out.println("Triangle 3 has the largest area");
        System.out.println();
    }
} //ready

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        Task1 task1;
        Task2 task2;
        Task3 task3;
        Task4 task4;
        Task5 task5;
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
                    task1 = new Task1();
                    task1.printResult();
                    break;
                case 2:
                    task2 = new Task2();
                    task2.printResult();
                    break;
                case 3:
                    task3 = new Task3();
                    task3.printResult();
                    break;
                case 4:
                    task4 = new Task4();
                    task4.printResult();
                    break;
                case 5:
                    task5 = new Task5();
                    task5.printResult();
                    break;
                default:
                    System.out.println("Enter the correct value!");
            }
        }
    }
}
