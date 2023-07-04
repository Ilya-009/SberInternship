package com.sbertech;

import com.sbertech.exceptions.*;

import java.util.List;
import java.util.Objects;

public class BankOnline {
    private static final List<String> BLOCKED_CARDS = List.of(
            "1111111111111111",
            "2222222222222222",
            "3333333333333333");
    private static final String CARD_PATTERN = "^\\d{16}$";
    private static final Double TRANSFER_LIMIT = 50000d;

    public void send(String cardNumber, Double money) throws
            InvalidCardNumberException,
            CardBlockedException,
            NegativeMoneyAmountException,
            OutOfLimitTransferException
    {
        Objects.requireNonNull(cardNumber);
        Objects.requireNonNull(money);

        if (!cardNumber.matches(CARD_PATTERN)) {
            throw new InvalidCardNumberException();
        }

        if (BLOCKED_CARDS.contains(cardNumber)) {
            throw new CardBlockedException();
        }

        if (money < 0) {
            throw new NegativeMoneyAmountException();
        }

        if (money > TRANSFER_LIMIT) {
            throw new OutOfLimitTransferException();
        }

        System.out.printf("Successfully transferred %.2f to card number %s", money, cardNumber);
    }
}
