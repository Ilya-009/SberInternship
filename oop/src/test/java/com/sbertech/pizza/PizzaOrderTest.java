package com.sbertech.pizza;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PizzaOrderTest {

    static PizzaOrder pizzaOrder;

    @BeforeAll
    static void beforeAll() {
        pizzaOrder = new PizzaOrder("Margarita", PizzaSize.MEDIUM, true, "address");
    }

    @Test
    void order() {
        pizzaOrder.order();
    }

    @Test
    void cancel() {
        pizzaOrder.cancel();
    }

    @Test
    void testToString() {
        System.out.println(pizzaOrder.toString());
    }
}