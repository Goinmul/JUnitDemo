package com.TestSpace;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.Test;

import com.SourceCode.Calculator;

//@DisplayName("name#1 for class")
public class CalculatorTester {
	
	Calculator cal1 = new Calculator();
	
	//@DisplayName("name#2 for method 😱")
	@Test
	public void simpleCalculatorTester()
	{
		assertEquals(30, cal1.simpleCalculator(10, 20));
	}
	
}
