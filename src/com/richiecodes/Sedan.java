package com.richiecodes;

public class Sedan extends Car {

    private int speed = 0;
    private String name;
    private int maxSpeed;

    public Sedan(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void accelerate() {
        if (speed < maxSpeed) {
            if(name.equals("Roadster")) {
                speed += 30;
            } else {
                speed += 10;
            }
            System.out.println("Speeding up! Speed is now: " + speed + "/" + maxSpeed + " mph\n");
        } else if (speed == maxSpeed) {
            System.out.println("Max speed limit reached!\n");
        }
    }

    @Override
    public void slowdown() {
        if (speed > 0) {
            speed -= 10;
            System.out.println("Slowing! Speed is now: " + speed + "/" + maxSpeed + " mph\n");
        } else if (speed == 0) {
            System.out.println("Car isn't moving!\n");
        }
    }

    @Override
    public int getCurrentSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name + "\tMax Speed: " + maxSpeed;
    }
}
