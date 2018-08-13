package com.BasicUsageTest.JUnit;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.jupiter.api.Disabled;

import com.BasicUsage.JUnit.MessageUtil;

//@Disabled
public class MessageUnitTest1 {
	
	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);

	//@Disabled
	//@Test(timeout = 1000) 
	//for failure : while(true)
	@Test
	public void testPrintMessage()
	{
		System.out.println("Inside testPrintMessage()");
		assertEquals(message, messageUtil.printMessage());
	}
}
