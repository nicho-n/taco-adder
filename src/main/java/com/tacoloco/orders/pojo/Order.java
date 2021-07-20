package com.tacoloco.orders.pojo;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private @Getter int veg;
    private @Getter int chicken;
    private @Getter int beef;
    private @Getter int chorizo;
}