package com.tacoloco.orders.tacoadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tacoloco.orders"})
public class TacoAdderApplication {
	public static void main(String[] args) {
		SpringApplication.run(TacoAdderApplication.class, args);
	}
}
