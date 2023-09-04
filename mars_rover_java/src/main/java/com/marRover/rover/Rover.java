package com.marRover.rover;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Rover {
    private int x;
    private int y;
    private int facing;

    public Rover(@NotNull Map map){
        if (map.isRover()){
            throw new IllegalCallerException("Solo puede haber un rover");
        }
        int[] coords = map.findEmptyCoordinate();
        map.setRover(true);
        x = coords[0];
        y = coords[1];
    }
    public Rover(@NotNull Map map, int x, int y){
        this.roverValidations(map, x, y);

        map.setRover(true);
        this.x = x;
        this.y = y;
    }

    private void roverValidations(Map map, int x, int y){
        if (x > map.getX() || x < 0 || y < 0 || y > map.getY()){
            throw new IllegalArgumentException("Las coordenadas deben estar dentro del mapa");
        }
        if (map.isRover()){
            throw new IllegalCallerException("Solo puede haber un rover");
        }
        if(!map.checkEmptyObstaclePosition(new int[] {x,y})){
            throw new IllegalArgumentException("Existe un obstaculo en esa coordenada");
        }
    }
    public int[] roverLocation() {
        int[] coords = new int[2];
        coords[0] = x;
        coords[1] = y;
        return coords;
    }
    public int getFacing(){
        return facing;
    }
}
