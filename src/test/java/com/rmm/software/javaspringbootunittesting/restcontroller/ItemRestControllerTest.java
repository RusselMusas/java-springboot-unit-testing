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
@WebMvcTest(ItemRestController.class)
class ItemRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void someitem_basic() throws Exception {
		
		// Call GET "/some-item" rest controller
		RequestBuilder request = MockMvcRequestBuilders
				.get("/some-item")
				.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())	// verify the status code
				.andExpect(content().json("{\"id\":1,\"name\":\"Phone\",\"price\":10,\"quantity\":120}")) // verify response body with MvcResult
				.andReturn();
		
	}

}
