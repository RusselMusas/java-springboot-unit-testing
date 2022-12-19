package com.rmm.software.javaspringbootunittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SomeBusinessTest {
	
	@Test
	void someBusiness_basic() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {1,4,3});
		int expectedResult = 8;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void someBusiness_emptyArray() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	void someBusiness_oneValue() {
		SomeBusinessImpl  business = new SomeBusinessImpl();
		int actualResult = business.calculateSum(new int[] { 6 });
		int expectedResult = 6;
		
		assertEquals(expectedResult, actualResult);
	}

}
