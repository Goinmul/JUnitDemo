package com.BasicUsageTest.JUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import com.BasicUsage.JUnit.MessageUtil;

public class MessageUtilSimpleTester {

	String message = "Hello World"; // Oracle message
	
	// instantiate
	MessageUtil messageUtil = new MessageUtil(message);

	// simple test
	@Test
	public void testPrintMessage()
	{
		assertEquals(message, messageUtil.printMessage());
		// give an example by
		// assertEquals("oracle" + message, messageUtil.printMessage());
	}
	
}
