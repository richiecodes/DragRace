package com.richiecodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DragRace {
    private boolean run = true;
    private final List<Car> cars = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    private int destination;
    private int ticks = 0;

    public DragRace() {
        cars.add(new Sedan("Roadster"));
        cars.add(new Sedan("Dodge Ram"));
        cars.add(new Sedan("Tesla Model S"));
        game();
    }

    public void game() {
        Car playerCar = cars.get(setupGame() - 1);

        while (run) {
            System.out.println(gameDetails(playerCar));

            System.out.println("\nWhat will you do?" +
                    "\n1.Accelerate" +
                    "\n2.Slowdown" +
                    "\n3.Coast" +
                    "\n4.Quit");
            menu(in.nextInt(), playerCar);

            if (destination <= 0) {
                destination = 0;
                System.out.println("\nDestination reached!\nYou've arrived in "
                        + ticks + " hours!");
                run = false;
            }
        }
    }

    private String listCars() {
        String s = "";
        int i = 1;
        for(var car : cars) {
            s += (i + ". " + car + "\n");
            i++;
        }

        return s;
    }

    private int setupGame() {
        System.out.println("Choose car: \n" + listCars());
        int choice = in.nextInt();
        cls();
        System.out.println("Set destination (mi): ");
        destination = in.nextInt();
        cls();

        return choice;
    }

    public String gameDetails(Car playerCar) {
        String out = "";

        out += ("Car: " + playerCar +
                "\nDestination: " + destination + " miles to go" +
                "\nSpeed: " + playerCar.getCurrentSpeed() + " mph" +
                "\nTime passed: " + ticks + " hours");

        return out;
    }

    public void menu(int choice, Car playerCar) {
        switch (choice) {
            case 1:
                cls();
                playerCar.accelerate();
                ticks++;
                destination -= playerCar.getCurrentSpeed();
                break;

            case 2:
                cls();
                playerCar.slowdown();
                ticks++;
                destination -= playerCar.getCurrentSpeed();
                break;

            case 3:
                cls();
                System.out.println("Chillin' at " + playerCar.getCurrentSpeed() + " mph!");
                ticks++;
                destination -= playerCar.getCurrentSpeed();
                break;

            default:
            case 4:
                run = false;
                break;
        }
    }

    public void cls() {
        int i = 100;
        while (i > 0) {
            System.out.println();
            i--;
        }
    }
}
