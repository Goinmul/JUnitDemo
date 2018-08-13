package com.SourceCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class Assumptions {

	// assumptions is like an if statement of tests.
	
	// Assumptions example before fixing (should not pass the test. This will fail)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,-1})
	void testWithoutAssumptions(int i)
	{
		//System.out.println("Assumptions test");
		try 
		{
			Thread.sleep(i);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	// Assumptions example after fixing (should pass)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,-1})
	void testWithAssumption(int i)
	{
		//System.out.println("Testing only positive numbers");
		assumeTrue(i>=0);
		try
		{
			Thread.sleep(i);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	// test carried under Windows OS ( test will succeed )
	@Test
	void runTest_ifWindow()
	{
		// if assumeTrue(true), this test is carried on/ else, it is being skipped.
		assumeTrue(System.getProperty("os.name").startsWith("Windows"));
		assertEquals(1,1);
		// rest part of test
	}

	// test carried under Linux OS ( test will be skipped )
	@Test
	void runTest_ifLinux()
	{
		assumeTrue(()-> System.getProperty("os.name").startsWith("Linux"));
		assertEquals(1,1);
	}

	// test carried under Linux (WHY EXECUTED?? : should fail)
	@Test
	void runTest_that()
	{
		String osName = System.getProperty("os.name");

		//assumingThat( condition , runnable code(assertions) )
		assumingThat(osName.startsWith("Linux"), ()-> assertEquals(1,1));
		//*should be executed only under Linux, but somehow works on every OS type
	}



}
