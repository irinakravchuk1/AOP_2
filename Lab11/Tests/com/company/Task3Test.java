package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test {
    Task3 task3Instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        task3Instance = new Task3(3, 8);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        task3Instance = null;
    }

    @Test
    void getNumber() {
        int expResult = 4;
        int result = task3Instance.getNumber();
        assertEquals(expResult, result);
    }

    @Test
    void getNumbers() {
        int[] expResult = new int[]{4, 5, 6, 7};
        int[] result = task3Instance.getNumbers();
        assertArrayEquals(expResult, result);
    }
}