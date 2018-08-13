package com.SourceCode;

//JUnit 4
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Before BeforeClass, ...
 */
public class ExecutionOrder {
	
	// set something before the 'entire' testing (Fixture)

	@BeforeClass // @BeforeAll in JUnit 5
	public static void beforeClass()
	{
		System.out.println("Before all");
	}

	@AfterClass // @AfterAll in JUnit 5
	public static void afterClass()
	{
		System.out.println("After all");
	}

	// set something before each test respectively
	@Before // @BeforeEach in JUnit 5
	public void before()
	{
		System.out.println("Before each");
	}

	@After // @BeforeEach in JUnit 5
	public void after()
	{
		System.out.println("After each");
	}

	// actual tests
	@Test(timeout = 1000)
	public void testCase1()
	{
		System.out.println("test #1");
	}

	@Test
	public void testCase2()
	{
		System.out.println("test #2");
	}
	

}
