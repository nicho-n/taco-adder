package com.tacoloco.orders.service;

import com.tacoloco.orders.pojo.Order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OrderCalculator {
    @Value("${prices.taco.veg}") 
    double vegPrice;

    @Value("${prices.taco.chicken}") 
    double chickenPrice;

    @Value("${prices.taco.beef}") 
    double beefPrice;

    @Value("${prices.taco.chorizo}") 
    double chorizoPrice;

    @Value("${prices.bulkDiscount.numTacosForDiscount}") 
    int numTacosForDiscount;

    @Value("${prices.bulkDiscount.percentDiscount}") 
    double percentDiscount;

    private int numTacos(Order order) {
        return order.getVeg() + order.getBeef() + order.getChicken() + order.getChorizo();
    }

    private boolean shouldApplyDiscount(Order order) {
        return numTacos(order) >= numTacosForDiscount;
    }

    private double applyDiscount(double subtotal) {
        return subtotal * (100-percentDiscount)/100;
    }

    private double getSubtotal(Order order) {
        return order.getVeg()*vegPrice 
        + order.getBeef()*beefPrice 
        + order.getChicken()*chickenPrice 
        + order.getChorizo()*chorizoPrice;
    }

    public double total(Order order) {
        double subtotal = getSubtotal(order);
        return shouldApplyDiscount(order) ? applyDiscount(subtotal) : subtotal;
    }
}
