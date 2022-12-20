package com.rmm.software.javaspringbootunittesting.business;

import org.springframework.stereotype.Service;

import com.rmm.software.javaspringbootunittesting.data.SomeDataService;

@Service
public class SomeBusinessImpl {

	private SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {

		int sum = 0;

		for (int value : data) {
			sum += value;
		}

		return sum;
	}

	public int calculateSumUsingDataSercice() {

		int sum = 0;
		int[] data = someDataService.retreiveAllData();

		for (int value : data) {
			sum += value;
		}

		return sum;
	}

}
