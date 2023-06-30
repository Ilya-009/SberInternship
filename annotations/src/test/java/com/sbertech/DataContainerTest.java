package com.sbertech;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataContainerTest {

    static DataContainer dataContainer;

    @BeforeAll
    static void beforeAll() {
        dataContainer = new DataContainer();
    }

    @Test
    void testLombokFunctionality() {
        assertDoesNotThrow(() -> dataContainer.setUserName("name"));
        assertEquals(dataContainer.getUserName(), "name");
    }
}