package com.rmm.software.javaspringbootunittesting.business;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListMockTest {
	
	private List<String> mock = mock(List.class);

	
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
	
	@Test
	void returnWithGenericParameters() {
		// Use of anyInt()
		when(mock.get(anyInt())).thenReturn("int returned");

		assertEquals("int returned", mock.get(0));
		assertEquals("int returned", mock.get(5));
		assertEquals("int returned", mock.get(10));
	}
	
	@Test
	void verificationBasics() {
		// System Under Testing: SUT
		String value1 = mock.get(0);
		String value2 = mock.get(3);
		
		// Verify
		verify(mock).get(0);
		verify(mock, times(2)).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(10);
	}
	
	@Test
	void argumentCapturing() {
		// SUT
		mock.add("some argument");
		
		// Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("some argument", captor.getValue());
	}
	
	@Test
	void multipleArgumentCapturing() {
		// SUT
		mock.add("some argument1");
		mock.add("some argument2");
		
		// Verify
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("some argument1", allValues.get(0));
		assertEquals("some argument2", allValues.get(1));
	}
	
}
