package com.tacoloco.orders.controller;

import com.tacoloco.orders.pojo.Order;
import com.tacoloco.orders.service.OrderCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@RestController
@EnableWebMvc
public class OrderController {
	
	@Autowired
	private OrderCalculator orderCalculator;

	@PostMapping("/orders/total")
	public double total (@RequestBody Order order) {
		return orderCalculator.total(order);
	}
}