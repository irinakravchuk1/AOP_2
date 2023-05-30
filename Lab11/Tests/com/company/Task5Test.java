package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task5Test {
    Task5 task5Instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        task5Instance = new Task5(17, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14, 15, 16, 1);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        task5Instance = null;
    }

    @Test
    void getMaxSquare() {
        double expResult = 8;
        double result = task5Instance.getMaxSquare();
        assertEquals(expResult, result);
    }
}