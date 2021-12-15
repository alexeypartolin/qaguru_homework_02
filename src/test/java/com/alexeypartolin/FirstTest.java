package com.alexeypartolin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Первый простой тест")
public class FirstTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all method");
    }

    @Test
    void firstTest() {
        Assertions.assertEquals(1,1);
    }



    @Test
    void secondTest() {
        Assertions.assertEquals(5,5);
    }
}
