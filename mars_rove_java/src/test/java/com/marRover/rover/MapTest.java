package com.marRover.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapTest {

    @Test
    public void shouldcreateADefaultMapWithXAndYInt(){
        Map map = new Map();
        Assertions.assertNotNull(map.getX());
        Assertions.assertNotNull(map.getY());
    }

    @Test
    public void shouldCreateACustomMapWithXAndYInt(){
        Map map = new Map(5,7);
        Assertions.assertEquals(5, map.getX());
        Assertions.assertEquals(7, map.getY());

        Map map2 = new Map(15,27);
        Assertions.assertEquals(15, map2.getX());
        Assertions.assertEquals(27, map2.getY());
    }
    @Test
    public void xAndYShouldNeverBeEqualsOrLessThanZero() {
        int[][] testData = {
                {0, 1},
                {1, 0},
                {0, 0},
                {-1, 0},
                {0, -1},
                {-1, -2},
                {1, -1},
                {-1, 1}
        };

        for (int[] data : testData) {
            int x = data[0];
            int y = data[1];
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Map(x, y);
            });
        }
    }
}
