package com.kodilla.kodillapatterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractPizzaOrderDecoratorTest {

    @Test
    public void testBasicPizzaCost() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        BigDecimal costs = pizzaOrder.getCost();

        assertEquals(new BigDecimal(15), costs);
    }

    @Test
    public void testBasicPizzaDescription() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        String description = pizzaOrder.getDescription();

        assertEquals("Pizza dough and tomato sauce with cheese", description);

    }

    @Test
    public void testPizzaWithAdditionalCheeseAndOlivesDescription() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        String description = pizzaOrder.getDescription();

        assertEquals("Pizza dough and tomato sauce with cheese + additional cheese + olives", description);
    }

    @Test
    public void testPizzaWithAdditionalCheeseAndOlivesCost() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        BigDecimal costs = pizzaOrder.getCost();

        assertEquals(new BigDecimal(20), costs);
    }

    @Test
    public void testPizzaWithPepperoniAndOlivesAndAdditionalCheeseDescription() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PepperoniDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);

        String description = pizzaOrder.getDescription();

        assertEquals("Pizza dough and tomato sauce with cheese + pepperoni + olives + additional cheese", description);
    }

    @Test
    public void testPizzaWithPepperoniAndOlivesAndAdditionalCheeseCost() {
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new PepperoniDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new AdditionalCheeseDecorator(pizzaOrder);

        BigDecimal costs = pizzaOrder.getCost();

        assertEquals(new BigDecimal(23), costs);
    }
}