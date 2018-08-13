package com.BasicUsage.JUnit;

public class MessageUtil {

	private String message;
	
	//Constructor
	public MessageUtil(String message)
	{
		this.message = message;
	}
	
	
	//method#1 : prints the message
	public String printMessage()
	{
		System.out.println(message);
		return message;
	}
	
	
	//method#2 : add "Hi!" to the message
	public String AddHi ()
	{
		message = "Hi!" + message;
		System.out.println(message);
		// intended error condition
				// int a = 0;
				// int b = 1/a;
		return message;
	}
	
}
