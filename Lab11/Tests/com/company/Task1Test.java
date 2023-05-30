package com.company;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {
    Task1 task1Instance;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("* Task1Test: Before method setUp()");
        task1Instance = new Task1(5, 7, 6, 2);
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("* Task1Test: After method tearDown()");
        task1Instance = null;
    }

    @org.junit.jupiter.api.Test
    void averageX() {
        double expResult = 6;
        double result = task1Instance.averageX();
        System.out.println("* Task1Test: test method 1 testAverageX()");
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    void averageY() {
        double expResult = 4;
        double result = task1Instance.averageY();
        System.out.println("* Task1Test: test method 2 testAverageY()");
        assertEquals(expResult, result);
    }
}