package com.sbertech.phone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PhoneTest {

    private static final Phone phone = new Phone("88005553535", "iPhone 13 Pro Max");

    @Test
    void receiveCall() {
        assertDoesNotThrow(() -> phone.receiveCall("Ilya"));
    }

    @Test
    void testReceiveCall() {
        assertDoesNotThrow(() -> phone.receiveCall("Ilya", "89115096473"));
    }

    @Test
    void getNumber() {
        assertEquals("88005553535", phone.getNumber());
    }

    @Test
    void sendMessage() {
        phone.sendMessage(new String[] { "88005553535", "89115096473" });
    }
}