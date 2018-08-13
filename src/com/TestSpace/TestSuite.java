package com.TestSpace;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.BasicUsageTest.JUnit.MessageUnitTest1;
import com.BasicUsageTest.JUnit.MessageUnitTest2;

@RunWith(Suite.class) // means TestSuite Class runs a number of test simultaneously(at once).
@Suite.SuiteClasses({MessageUnitTest1.class, MessageUnitTest2.class}) // this line is where the class names are put
public class TestSuite
{
	@BeforeClass
	static public void setup()
	{
		System.out.println("setup");
		// pre-test instantiation (fixture)
	}
	
	@AfterClass
	static public void teardown()
	{
		System.out.println("teardown");
		// after-test instantiation
	}
	
	// blank
}
