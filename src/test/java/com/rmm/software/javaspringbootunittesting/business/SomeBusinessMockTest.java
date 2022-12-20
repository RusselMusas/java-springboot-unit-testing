package com.rmm.software.javaspringbootunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.rmm.software.javaspringbootunittesting.data.SomeDataService;

/**
 * @author RUSSEL
 * @Comment Unit Tests using Stub dataService
 */
class SomeBusinessMockTest {

	@Test
	void someBusinessUsingDataSercice_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		// Creating Mock service
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { 1, 3, 5 });

		// Set MockService Implementation to business class
		business.setSomeDataService(dataServiceMock);
		
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 9;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void someBusinessUsingDataSercice_emptyArray() {
		SomeBusinessImpl business = new SomeBusinessImpl();

		// Creating Mock service
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { });

		// Set MockService Implementation to business class
		business.setSomeDataService(dataServiceMock);
		
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 0;

		assertEquals(expectedResult, actualResult);
	}

	@Test
	void someBusinessUsingDataSercice_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		
		// Creating Mock service
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retreiveAllData()).thenReturn(new int[] { 12 });
		
		// Set MockService Implementation to business class
		business.setSomeDataService(dataServiceMock);
		
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 12;

		assertEquals(expectedResult, actualResult);
	}

}
