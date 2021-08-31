package com.richiecodes;

public class Engine {
    private String name;

    public Engine() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " Engine";
    }
}
