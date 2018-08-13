package com.BasicUsageTest.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.BasicUsage.JUnit.MessageUtil;

public class MessageUnitTest2 {

	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);
	
	@Test//(expected = ArithmeticException.class)
	public void AddHiMethodTester()
	{
		System.out.println("Inside AddHiMethodTester()");
		message = "Hi!" + "Robert";
		assertEquals(message, messageUtil.AddHi());
	}
}
