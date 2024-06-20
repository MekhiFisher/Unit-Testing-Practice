package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		//@formatter:off
		return Stream.of(
				arguments(1, 2, 3, false),
				arguments(2, 4, 6, false),
				arguments(0, 0, 0, true),
				arguments(-1, 4, 0, true),
				arguments(2, 0, 2, true)
				);
		//@formatter:on
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForSubtractPositive")
	void assertThatTwoPositiveNumbersAreSubtractedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.subtractPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.subtractPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForSubtractPositive() {
		//@formatter:off
		return Stream.of(
				arguments(3, 5, -2, false),
				arguments(10, 7, 3, false),
				arguments(10, -1, 0, true),
				arguments(0, 0, 0, true)
				);
		//@formatter:on
	}

	@Test
	protected void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(1, 3)).isEqualTo(4);
		assertThat(testDemo.addPositive(5, 10)).isEqualTo(15);
	}

	@Test
	protected void assertThatPairsOfPositiveNumbersAreSubtractedCorrectly() {
		assertThat(testDemo.subtractPositive(3, 2)).isEqualTo(1);
		assertThat(testDemo.subtractPositive(2, 3)).isEqualTo(-1);
	}
	
	@Test
	protected void assertThatNumberSqauredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	
	
	
	
}
