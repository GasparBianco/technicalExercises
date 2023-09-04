package com.marRover.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RoverTest {

    @Test
    public void whenRoverIsCreatedHaveToChangeRoverInMapToTrue(){
        Map map = new Map();
        Rover rover = new Rover(map);
        Assertions.assertTrue(map.isRover());
    }

    @Test
    public void roverHaveToBeCreatedOnARandomLocation(){
        Map map = new Map();
        for(int i=0;i<25; i++){
            map.createRandomObstacle();
        }

        Rover rover = new Rover(map);
        Assertions.assertArrayEquals(map.findEmptyCoordinate(), rover.roverLocation());
    }
    @Test
    public void roverCouldBeCreateOnACustomLocation(){
        Rover rover = new Rover(new Map(), 1,1);
        Assertions.assertArrayEquals(new int[]{1, 1}, rover.roverLocation());
    }
    @Test
    public void canNotCreateTheRoverOnAObstacle(){
        Map map = new Map();
        map.createCustomObstacle(1,1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Rover rover = new Rover(map,1,1);
        });
    }
    @Test
    public void justOneRoverCanExist(){
        Map map = new Map();
        Rover rover = new Rover(map);
        Assertions.assertThrows(IllegalCallerException.class, () -> {
            Rover rover2 = new Rover(map,1,1);
        });
        Assertions.assertThrows(IllegalCallerException.class, () -> {
            Rover rover3 = new Rover(map);
        });
    }
    @Test
    public void roverHaveToBeInsideTheMap(){
        Map map = new Map();
        Rover rover = new Rover(map);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Rover rover2 = new Rover(map,11,1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Rover rover2 = new Rover(map,1,11);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Rover rover2 = new Rover(map,-11,1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Rover rover2 = new Rover(map,1,-1);
        });
    }

}
