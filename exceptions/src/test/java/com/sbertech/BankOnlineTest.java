package com.sbertech;

import com.sbertech.exceptions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankOnlineTest {

    @Test
    void send() {
        BankOnline bankOnline = new BankOnline();

        assertThrows(NullPointerException.class, () -> bankOnline.send(null, null));
        assertThrows(NullPointerException.class, () -> bankOnline.send(null, 10000d));
        assertThrows(InvalidCardNumberException.class, () -> bankOnline.send("123456789548759", 10000d));
        assertThrows(InvalidCardNumberException.class, () -> bankOnline.send("12y3456789548759", 10000d));
        assertThrows(CardBlockedException.class, () -> bankOnline.send("2222222222222222", 10000d));
        assertThrows(NegativeMoneyAmountException.class, () -> bankOnline.send("1234567895481759", -100d));
        assertThrows(OutOfLimitTransferException.class, () -> bankOnline.send("1234567895481759", 70000d));

        assertDoesNotThrow(() -> bankOnline.send("1234567895481759", 10000d));
    }
}