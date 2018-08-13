package com.SourceCode;

import static java.time.Duration.*;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AssertionsExamples {

	//See all assertions at) http://junit.sourceforge.net/javadoc/org/junit/Assert.html
	
	int[] array1 = {1};
	int[] array2 = {1};
	
	int a = 1;
	int b = 1;
	
	// assertEquals (same value or not)
	@Test
	void standardAssertions()
	{
		assertEquals(2, 2);
	
		assertArrayEquals(array1, array2); //(expected, actual)
	
		assertTrue(true);
		
		assertFalse(false);
	
		assertNotNull(array1);
	
		assertNull(null);
	
		assertNotSame(array1, array2); // (unexpected, actual)
	
		assertSame(array1, array1);
		
		// assertSame : asserts that two objects refer to the same object (uses == operator)
		// assertEquals : asserts that the two objects are equal (uses "equals()" method - comparing values)
		// (in asserEquals, if primitive values are passed, then the values are compared.
		// if objects are passed, then "equals()" method is invoked)
		
		// assertSame(a,b); // should fail (but passed somehow...)
		// assertSame(a,a); // should pass
		
		// fail("This test failed.");
	}

	// assertAll (assert all assertions in parenthesis)
	@Test
	void groupedAssertions()
	{
		assertAll("Name", ()->assertEquals("John","John"), ()-> assertEquals("Carl","Carl") );
	}

	// dependent assertions : A bit confusing...
	@Test
	void dependentAssertions()
	{
		// in a code block, if an assertion fails,
		// then the subsequent code in the same block will be skipped.
		assertAll("properties", ()-> {String firstName = "Kim"; // Kim -> person.getName();
		
		// #1 assertion
		assertNotNull(firstName); 

		// #2 assertion (Executed only if the previous assertion is valid.
		assertAll("first Name", ()->assertTrue(firstName.startsWith("K")),
								()->assertTrue(firstName.endsWith("m")));
				}
			);
	}
	
	// Quite not clear
	@Test
	void exceptionTesting()
	{
		// thrown when a method passes illegal/inappropriate arguments
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->
		{	throw new IllegalArgumentException("a message");	}	);
		
		assertEquals("a message", exception.getMessage());
	}

	@Test
	void timeoutNotExceeded()
	{
		assertTimeout(ofMinutes(2), ()->{
			// perform task that takes less than 2 minutes. (if it took more than 2 min, test fails.)
		});
	}
	
	// Quite not clear...
	@Test
	void timeoutNotExceededWithResult()
	{
		// The following assertion(below) succeeding, return the supplied object.
		String actualResult = assertTimeout(ofMinutes(2), ()-> { return "a result"; });
		assertEquals("a result", actualResult);
	}
	
	@Test
	void timeoutExceeded()
	{
		// set ofMillis(10) for an fail statement
		assertTimeout(ofMillis(1000), ()-> {
			// Simulate task that takes more than 10 ms.
			Thread.sleep(100);
		});
		// time limit is 10ms, but actual sleep time is 100
	}
	
	// timeout check with preemption(something like terminating thread, I guess)
	@Test
	void timeoutExceededWithPreemptiveTermination()
	{
		assertTimeoutPreemptively(ofMillis(1000), ()->{
			// task that takes more than 10ms should be here. (for a fail statement)
			Thread.sleep(100);
		});
	}
	
}
