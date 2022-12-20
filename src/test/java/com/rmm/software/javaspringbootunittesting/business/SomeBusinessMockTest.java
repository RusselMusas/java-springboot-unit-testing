package com.rmm.software.javaspringbootunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rmm.software.javaspringbootunittesting.data.SomeDataService;

/**
 * @author RUSSEL
 * @Comment Unit Tests using Stub dataService
 */
class SomeBusinessMockTest {
	
	// Create business reference
	private SomeBusinessImpl business = new SomeBusinessImpl();
	// Creating Mock service
	private SomeDataService dataServiceMock = mock(SomeDataService.class);
	
	@BeforeEach
	void beforeTest() {
		// Set MockService Implementation to business class
		business.setSomeDataService(dataServiceMock);
	}

	@Test
	void someBusinessUsingDataSercice_basic() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { 1, 3, 5 });
		assertEquals(9, business.calculateSumUsingDataSercice());
	}

	@Test
	void someBusinessUsingDataSercice_emptyArray() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { });
		assertEquals(0, business.calculateSumUsingDataSercice());
	}

	@Test
	void someBusinessUsingDataSercice_oneValue() {
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { 12 });
		assertEquals(12, business.calculateSumUsingDataSercice());
	}

}
