package com.rmm.software.javaspringbootunittesting.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.software.javaspringbootunittesting.model.Item;

@RestController
public class ItemRestController {
	
	@GetMapping(value="/some-item")
	public Item getSomeItem() {
		
		return new Item(1, "Phone", 10, 120);
	}
	
}
