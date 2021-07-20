package com.tacoloco.orders.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tacoloco.orders.pojo.Order;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@SpringBootConfiguration
public class OrderCalculatorTest {
    double vegPrice =  2.50;
    double beefPrice =  3.00;
    double chickenPrice =  3.01;
    double chorizoPrice =  3.50;
    int numTacosForDiscount = 4;
    double percentDiscount = 20;

    private OrderCalculator orderCalculator = new OrderCalculator(vegPrice, chickenPrice, beefPrice, chorizoPrice, numTacosForDiscount, percentDiscount);
    @Test
    public void testTotal() {
        double total = orderCalculator.total(new Order(1,1,1,0));
        assertEquals(8.51, total);
    }

    @Test
    public void testDiscount() {
        double total = orderCalculator.total(new Order(0,0,0,numTacosForDiscount));
        double expected = Math.floor(100 * ((chorizoPrice*4) * (100-percentDiscount)/100)) / 100;
        assertEquals(expected, total);
    }
}