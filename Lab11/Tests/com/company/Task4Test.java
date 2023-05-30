package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4Test {
    Task4 task4Instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        task4Instance = new Task4(new int[]{1, 2, 3, 3, 3, 0, 1, 0});
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        task4Instance = null;
    }

    @Test
    void getNum0() {
        int expResult = 2;
        int result = task4Instance.getNum0();
        assertEquals(expResult, result);
    }

    @Test
    void getNum1() {
        int expResult = 2;
        int result = task4Instance.getNum1();
        assertEquals(expResult, result);
    }

    @Test
    void getNum2() {
        int expResult = 1;
        int result = task4Instance.getNum2();
        assertEquals(expResult, result);
    }

    @Test
    void getNum3() {
        int expResult = 3;
        int result = task4Instance.getNum3();
        assertEquals(expResult, result);
    }
}