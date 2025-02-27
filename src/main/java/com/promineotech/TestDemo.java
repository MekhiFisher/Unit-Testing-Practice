package com.promineotech;

import java.util.Random;

public class TestDemo {
	public int addPositive(int a, int b) {
		int sum = 0;
		if (a > 0 && b > 0) {
			sum = a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		} 
		return sum;

	}
	
	public int subtractPositive(int a, int b) {
		int sum = 0;
		if (a > 0 && b > 0) {
			sum = a - b;
		} else {
			throw new IllegalArgumentException("Both numbers must be positive");
		}
		return sum;
	}
	
	public int randomNumberSquared() {
		int random = getRandomInt();
		int result = random * random;
		return result;
	}
	
	protected int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	
}
