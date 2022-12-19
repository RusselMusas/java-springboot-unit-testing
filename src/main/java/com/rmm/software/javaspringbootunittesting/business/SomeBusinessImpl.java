package com.rmm.software.javaspringbootunittesting.business;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl {
	
	public int calculateSum(int[] data) {
		
		int sum = 0;
		
		for(int value : data) {
			sum += value;
		}
		
		return sum;
	}

}
