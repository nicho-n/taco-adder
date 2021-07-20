package com.tacoloco.orders.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tacoloco.orders.service.OrderCalculator;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(classes={OrderController.class, OrderCalculator.class})
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnTotal() throws Exception {
		String request = "{\"veg\": 1,\"beef\": 1,\"chicken\": 1,\"chorizo\": 1}";
		mockMvc.perform(MockMvcRequestBuilders.post("/orders/total")
		  .content(request)
		  .contentType(MediaType.APPLICATION_JSON)
		  .accept(MediaType.APPLICATION_JSON)).andDo(print())
		  .andExpect(status().isOk())
		  .andExpect(content().string(containsString("9.6")
		));
	}
}