package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    Task2 task2Instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        task2Instance = new Task2(1, 10, 8);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        task2Instance = null;
    }

    @Test
    void getX() {
        double expResult = 10;
        double result = task2Instance.getX();
        assertEquals(expResult, result);
    }

    @Test
    void getY() {
        double expResult = 8;
        double result = task2Instance.getY();
        assertEquals(expResult, result);
    }

    @Test
    void getZ() {
        double expResult = 1;
        double result = task2Instance.getZ();
        assertEquals(expResult, result);
    }
}