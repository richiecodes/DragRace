package com.richiecodes;

import java.util.Random;

public class Sedan extends Car {

    private int speed = 0;
    private final String name;
    private int maxSpeed;
    private final Engine engine;
    private int friction;

    public Sedan(String name) {
        this.name = name;
        engine = new Engine();
        setEngine(name);
    }

    @Override
    public void accelerate() {
        Random rand = new Random();
        friction = rand.nextInt(10);

        if (speed < maxSpeed) {
            switch (engine.getName()) {
                case "V6":
                    speed += 10 - friction;
                    break;

                case "V8":
                    speed += 20 - friction;
                    break;

                case "Electric":
                    speed += 30 - friction;
                    break;
            }
            if (friction > 0) {
                System.out.println("You experienced some friction. Speed is affected by "
                        + friction + " mph :(\n");
            }
            System.out.println("Speeding up! Speed is now: " + speed + "/" + maxSpeed +
                    " mph\n");
        } else if (speed == maxSpeed) {
            System.out.println("Max speed limit reached!\n");
        }
    }

    @Override
    public void slowdown() {
        if (speed > 0) {
            speed -= 10;
            System.out.println("Slowing! Speed is now: " + speed + "/" + maxSpeed +
                    " mph\n");
        } else if (speed == 0) {
            System.out.println("Car isn't moving!\n");
        }
    }

    @Override
    public int getCurrentSpeed() {
        return speed;
    }

    @Override
    public void setEngine(String name) {
        switch (name) {
            case "Roadster":
                engine.setName("V6");
                maxSpeed = 300;
                break;

            case "Dodge Ram":
                engine.setName("V8");
                maxSpeed = 250;
                break;

            case "Tesla Model S":
                engine.setName("Electric");
                maxSpeed = 350;
                break;
        }
    }

    @Override
    public String toString() {
        String accelRate = "";

        switch (engine.getName()) {
            case "V6":
                accelRate += "10";
                break;

            case "V8":
                accelRate += "20";
                break;

            case "Electric":
                accelRate += "30";
        }

        return (name + "\nEngine Type: " + engine.getName() + "\tAcceleration Rate: "
                + accelRate + " mph\tMax Speed: " + maxSpeed + "\n");
    }
}
