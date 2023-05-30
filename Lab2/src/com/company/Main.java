package com.company;
import java.util.Scanner;

class StraightLine {
    private double a, b;
    StraightLine (double a, double b) {
        this.a = a;
        this.b = b;
    }
    StraightLine () {}
    void setLine(double a, double b) {
        this.a = a;
        this.b = b;
    }
    void Check(double x, double y){
        if (y == a * x + b)
            System.out.println("Point with coordinates (" + x + "; " + y + ") belongs to the line");
        else
            System.out.println("Point with coordinates (" + x + "; " + y + ") doesn't belong to the line");
    }
    void Crossing(StraightLine one){
        if (a == one.a)
            System.out.println("Sorry, it's impossible to determine coordinates of crossing");
        else {
            double x, y;
            x = (b - one.b) / (one.a - a);
            y = a * x + b;
            System.out.println("Crossing:\nx = " + x + "\ny = " + y);
        }
    }
    double GetA(){
        return a;
    }
    double GetB(){
        return b;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        System.out.println("Enter a & b:");
        StraightLine line1 = new StraightLine(scan.nextDouble(), scan.nextDouble());
        StraightLine line2 = new StraightLine();
        do {
            System.out.println("Main line: y = " + line1.GetA() + " * x + " + line1.GetB());
            System.out.println("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to change the line\n" +
                    "Enter \"2\" to determine whether the point with coordinates (x; y) belongs to the line\n" +
                    "Enter \"3\" to determine the coordinates of the point of intersection with another line");
            choice = scan.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    System.out.println("Let's change line\nEnter a & b:");
                    line1.setLine(scan.nextDouble(), scan.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter x & y:");
                    line1.Check(scan.nextDouble(), scan.nextDouble());
                    break;
                case 3:
                    System.out.println("Let's create another line\nEnter a & b:");
                    line2.setLine(scan.nextDouble(), scan.nextDouble());
                    System.out.println("Additional line: y = " + line2.GetA() + " * x + " + line2.GetB());
                    line1.Crossing(line2);
                    break;
                default:
                    System.out.println("Enter the correct value!");
                    break;
            }
        } while (choice != 0);
    }
}