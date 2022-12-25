package com.rmm.software.javaspringbootunittesting.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Spring Unit Test
@WebMvcTest(HelloWorldRestController.class)
class HelloWorldRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void helloWorld_basic() throws Exception {
		
		// Call GET "/hello-world" rest controller
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		// Verify the response
		// System.out.println("Response body: " + result.getResponse().getContentAsString());
		assertEquals("Hello World", result.getResponse().getContentAsString());
		
	}

}
