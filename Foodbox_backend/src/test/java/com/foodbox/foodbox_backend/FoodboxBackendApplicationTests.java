package com.foodbox.foodbox_backend;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class FoodboxBackendApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldReturnaddress() throws Exception {

		mockMvc.perform(get("/api/address/")).andDo(print()).andExpect(status().isOk());
				
	}
	
	@Test
	public void shouldReturncuisines() throws Exception {

		mockMvc.perform(get("/api/cuisines/")).andDo(print()).andExpect(status().isOk());
				
	}
	@Test
	public void shouldReturncart() throws Exception {

		mockMvc.perform(get("/api/cart/")).andDo(print()).andExpect(status().isOk());
				
	}
	@Test
	public void shouldReturncart_line() throws Exception {

		mockMvc.perform(get("/api/cart_line/")).andDo(print()).andExpect(status().isOk());
				
	}
	@Test
	public void shouldReturnproduct() throws Exception {

		mockMvc.perform(get("/api/product/")).andDo(print()).andExpect(status().isOk());
				
	}
	@Test
	public void shouldReturnuser() throws Exception {

		mockMvc.perform(get("/api/user/")).andDo(print()).andExpect(status().isOk());
				
	}
	@Test
	void contextLoads() {
	}

}
