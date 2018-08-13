package com.TestSpace;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.BasicUsageTest.JUnit.MessageUtilSimpleTester;
import com.SourceCode.Assumptions;
import com.SourceCode.ExecutionOrder;

//simple test runner
public class TesterMain {

	public static void main(String[] args) {
		
		// gets test result from MessageUtil Class' methods.
		
		// 1. simple MessageUtil Class test
		Result result = JUnitCore.runClasses(MessageUtilSimpleTester.class);
		
		// 2. Execution procedure(Field1)
		//Result result = JUnitCore.runClasses(Field1.class);
		
		// 3. Suite Test
		//Result result = JUnitCore.runClasses(TestSuite.class);
		
		// 4. Ignore (MessageUnitTest1)
		
		// 5. Time test
		// easily done by @timeout
		
		for (Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
	
}
