package com.marRover.rover;

public class Map {
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Map(){
        this.x = 10;
        this.y = 10;
    }
    public Map(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Los valores de x e y deben ser mayores que cero.");
        }
        this.x = x;
        this.y = y;
    }
}
