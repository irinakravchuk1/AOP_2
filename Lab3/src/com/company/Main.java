package com.company;
import java.util.Scanner;

interface Run {
    String getName();
    double getSpeed();
    int getWeight();
    int getPassengersAmount();
    int getPropellersAmount();
}

abstract class Machine implements Run {
    Scanner scan = new Scanner(System.in);
    public final int MAXSPEED = 350;
    public final int MINSPEED = 0;
    public final int MINPASSENGERS = 1;
    public final int MAXPASSENGERS = 30;
    protected String name;
    protected double speed;
    Machine (String name, double speed) {
        this.name = name;
        this.speed = speed;
    }
    Machine (){
        System.out.print("Enter name: ");
        this.name = scan.nextLine();
        do {
            System.out.print("Enter speed(" + MINSPEED + "-" + MAXSPEED + " km/h): ");
            this.speed = scan.nextDouble();
        } while (speed < MINSPEED || speed > MAXSPEED);
    }
    public String getName() {
        return this.name;
    }
}

class Helicopter extends Machine {
    protected int weight;
    protected int passengersAmount;
    protected int propellersAmount;
    Helicopter (String name, double speed, int weight, int passengersAmount, int propellers) {
        super(name, speed);
        this.weight = weight;
        this.passengersAmount = passengersAmount;
        this.propellersAmount = propellers;
    }
    Helicopter (){
        super();
        do {
            System.out.print("Enter weight(300+ kg): ");
            this.weight = scan.nextInt();
        } while (weight < 300);
        do {
            System.out.print("Enter passengers amount(" + MINPASSENGERS + "-" + MAXPASSENGERS + "): ");
            this.passengersAmount = scan.nextInt();
        } while (passengersAmount < MINPASSENGERS || passengersAmount > MAXPASSENGERS);
        do {
            System.out.print("Enter propellers amount: ");
            this.propellersAmount = scan.nextInt();
        } while (propellersAmount < 0);
    }
    public double getSpeed(){
        return speed;
    }
    public int getWeight(){
        return weight;
    }
    public int getPassengersAmount(){
        return passengersAmount;
    }
    public int getPropellersAmount(){
        return propellersAmount;
    }
}

class CargoHelicopter extends Helicopter {
    int loadCapacity;
    CargoHelicopter(String name, double speed, int weight, int passengersAmount, int propellers, int loadCapacity) {
        super(name, speed, weight, passengersAmount, propellers);
        this.loadCapacity = loadCapacity;
    }
    CargoHelicopter () {
        super();
        System.out.print("Enter load capacity: ");
        this.loadCapacity = scan.nextInt();
    }
    public void showInformation(){
        System.out.println("Name of Cargo Helicopter: " + name +
                "\nSpeed of Cargo Helicopter: " + speed + " km/h" +
                "\nWeight of Cargo Helicopter: " + weight + " kg" +
                "\nThe number of Cargo Helicopter passengers: " + passengersAmount +
                "\nThe number of Cargo Helicopter propellers: " + propellersAmount +
                "\nThe load capacity of Cargo Helicopter: " + loadCapacity + " kg");
    }
}

class CombatHelicopter extends Helicopter {
    int gunsAmount;
    CombatHelicopter(String name, int speed, int weight, int passengersAmount, int propellers, int gunsAmount) {
        super(name, speed, weight, passengersAmount, propellers);
        this.gunsAmount = gunsAmount;
    }
    CombatHelicopter () {
        super();
        System.out.print("Enter guns amount: ");
        this.gunsAmount = scan.nextInt();
    }
    public void showInformation(){
        System.out.println("Name of Combat Helicopter: " + name +
                "\nSpeed of Combat Helicopter: " + speed + " km/h" +
                "\nWeight of Combat Helicopter: " + weight + " kg" +
                "\nThe number of Combat Helicopter passengers: " + passengersAmount +
                "\nThe number of Combat Helicopter propellers: " + propellersAmount +
                "\nThe number of Combat Helicopter guns: " + gunsAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice;
        boolean value1 = false, value2 = false;
        CargoHelicopter cargo = new CargoHelicopter("0", 0, 0, 0, 0, 0);
        CombatHelicopter combat = new CombatHelicopter("0", 0, 0, 0, 0, 0);
        do {
            System.out.print("Enter \"0\" to close the application\n" +
                    "Enter \"1\" to create or change information about Cargo Helicopter\n" +
                    "Enter \"2\" to create or change information about Combat Helicopter\n" +
                    "Enter \"3\" to print information about Cargo Helicopter\n" +
                    "Enter \"4\" to print information about Combat Helicopter\n");
            choice = scan.nextInt();
            switch (choice){
                case 0:
                    break;
                case 1:
                    cargo = new CargoHelicopter();
                    value1 = true;
                    break;
                case 2:
                    combat = new CombatHelicopter();
                    value2 = true;
                    break;
                case 3:
                    if (value1) {
                        cargo.showInformation();
                    } else {
                        System.out.println("Cargo Helicopter isn't created!");
                    }
                    break;
                case 4:
                    if (value2) {
                        combat.showInformation();
                    } else {
                        System.out.println("Combat Helicopter isn't created!");
                    }
                    break;
                default:
                    System.out.println("Enter the correct value!");
                    break;
            }
        } while (choice != 0);
    }
}