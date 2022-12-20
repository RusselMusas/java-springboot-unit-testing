package com.rmm.software.javaspringbootunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.rmm.software.javaspringbootunittesting.data.SomeDataService;


/**
 * @author RUSSEL
 * @Comment STUB Implementation for UNIT TESTS
 */
class someDataServiceStub implements SomeDataService {

	@Override
	public int[] retreiveAllData() {
		return new int[] { 1, 4, 3};
	}
	
}

/**
 * @author RUSSEL
 * @Comment STUB 2 Implementation for UNIT TESTS
 */
class someDataServiceStubEmpty implements SomeDataService {

	@Override
	public int[] retreiveAllData() {
		return new int[] { };
	}
	
}

/**
 * @author RUSSEL
 * @Comment STUB 3 Implementation for UNIT TESTS
 */
class someDataServiceStubOne implements SomeDataService {

	@Override
	public int[] retreiveAllData() {
		return new int[] { 6 };
	}
	
}


/**
 * @author RUSSEL
 * @Comment Unit Tests using Stub dataService
 */
class SomeBusinessUsingDataServiceTest {
	
	@Test
	void someBusinessUsingDataSercice_basic() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceStub());
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 8;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void someBusinessUsingDataSercice_emptyArray() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceStubEmpty());
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void someBusinessUsingDataSercice_oneValue() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		business.setSomeDataService(new someDataServiceStubOne());
		int actualResult = business.calculateSumUsingDataSercice();
		int expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
	}

}
