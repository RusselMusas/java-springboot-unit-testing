package com.rmm.software.javaspringbootunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rmm.software.javaspringbootunittesting.data.SomeDataService;

/**
 * @author RUSSEL
 * @Comment Unit Tests using Stub dataService
 */
@ExtendWith(MockitoExtension.class)
class SomeBusinessMockTest {
	
	// Create Mock
	@Mock
	private SomeDataService dataServiceMock;
	
	// Inject Mock into business service
	@InjectMocks
	private SomeBusinessImpl business;
	
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
