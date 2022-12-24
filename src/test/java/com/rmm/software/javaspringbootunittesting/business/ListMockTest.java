package com.rmm.software.javaspringbootunittesting.business;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ListMockTest {
	
	private List mock = mock(List.class);

	
	@Test
	void size_basic() {
		when(mock.size()).thenReturn(5);

		assertEquals(5, mock.size());
	}
	
	@Test
	void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(8);

		assertEquals(5, mock.size());
		assertEquals(8, mock.size());
	}
	
	@Test
	void returnWithParameters() {
		when(mock.get(0)).thenReturn("0 returned").thenReturn("end");

		assertEquals("0 returned", mock.get(0));
		assertEquals("end", mock.get(0));
		assertEquals(null, mock.get(1)); // default null is returned
	}

}
