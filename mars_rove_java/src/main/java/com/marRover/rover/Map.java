package com.marRover.rover;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Map {
    private final int x;
    private final int y;
    private ArrayList<int[]> obstacles = new ArrayList<>();
    public Map(int x, int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Los valores de x e y deben ser mayores que cero.");
        }
        this.x = x;
        this.y = y;
    }
    public Map(){
        this.x = 10;
        this.y = 10;
    }
    public void createCustomObstacle(int[] coords) {
        if (obstacles.isEmpty()){
            obstacles.add(coords);
        }else if(checkEmptyObstaclePosition(coords)){
            obstacles.add(coords);
        }else {
            throw new RuntimeException("Ya existe un obstaculo en esa posicion");
        }
    }
    public void createRandomObstacle(){
        int [] coords = new int[2];
        Random random = new Random();
        coords[0] = random.nextInt(this.getX()+1);
        coords[1] = random.nextInt(this.getY()+1);
        if (obstacles.isEmpty()){
            obstacles.add(coords);
        }else if(checkEmptyObstaclePosition(coords)){
            obstacles.add(coords);
        }else {
            obstacles.add(findEmptyCoordinate());
        }
    }

    private boolean checkEmptyObstaclePosition(int[] coords){
        boolean check = true;
        for (int[] obstacle : obstacles) {
            if (Arrays.equals(coords, obstacle)) {
                check = false;
                break;
            }
        }
        return check;
    }

    private int[] findEmptyCoordinate() {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                int[] coords = {i, j};
                if (this.checkEmptyObstaclePosition(coords)) {
                    return coords;
                }
            }
        }
        throw new RuntimeException("El mapa esta lleno de obstaculos");
    }

    public ArrayList<int[]> getObstacles() {
        return obstacles;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }


}
