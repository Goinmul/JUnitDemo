package com.SourceCode;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Nested Example.")
public class NestedExample {

	// All nested test classes must be NON-STATIC.
	
	// By default, a nested test class can contain :
	// 1) Many test methods
	// 2) One single @BeforeEach, @AfterEach method.
	
	@BeforeAll
	static void beforeAll()
	{
		System.out.println("Before all test methods (first)");
	}
	
	@AfterAll
	static void afterAll()
	{
		System.out.print("After all test methods (last)");
	}
	
	@BeforeEach
	void beforeEach()
	{
		System.out.println("Before each test cases (outer)");
	}
	
	@AfterEach
	void afterEach()
	{
		System.out.println("After each test cases (outer)");
	}
	
	// --- till here is 'surface level' methods ---
	
	// Outer class sees this @Nested as one @Test.
	@Nested
	//@DisplayName("Tests for the method A")
	class A {
		
		@BeforeEach()
		void beforeEachInA()
		{
			System.out.println("Before each test method of the A class (level 1)");
		}
		
		@AfterEach()
		void afterEachInA()
		{
			System.out.println("After each test method of the A class (level 1)");
		}
		
		@Test
		//@DisplayName("Example test for method A #1")
		void sampleTestForMethodA()
		{
			System.out.println("Example test for method A $1 (First Nested)");
		}
		
		/*
		@Test
		@DisplayName("Example test for method A #2")
		void sampleTestForMethodATwo()
		{
			System.out.println("Example test for method A $2 (First Nested)");
		}
		*/
		
		
		@Nested
		//@DisplayName("When X is true")
		class WhenX
		{
			@BeforeEach
			void beforeEach()
			{
				System.out.println("Before each test method of the WhenX class (level 2)");
			}
			
			@AfterEach
			void afterEach()
			{
				System.out.println("After each test method of the WhenX class (level 2)");
			}
			
			@Test
			//@DisplayName("Example test for method A when X is true")
			void sampleTestForMethodAWhenX()
			{
				System.out.println("Example test for method A when X is true (innermost)");
			}
		}
		
		
	}
	
}
