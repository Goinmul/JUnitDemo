package com.TestSpace;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/*
 * Automated Test(not a selective-input type)
 */
public class ClamiAutomatedExample {
	
	// Scanner sc1 = new Scanner(System.in);
	int argsValueNumber = 91;
	String argsValueString = "0";
	
	String[] args = {"-f","data/sample.arff","-l","class","-p","buggy","-m","-c","50","--suppress"};
	
	
	@BeforeAll
	void setup()
	{
		System.out.println("Initial setup...");
		// setup
		// CLAMI runner = new CLAMI();
	}
	
	@AfterAll
	void teardown()
	{
		System.out.println("Close testing...");
		//assertEquals(runner.dataFilePath,"");
		//assertEquals(runner.labelName,"label");
		//assertEquals(runner.posLabelValue,"buggy");
		// finish testing
	}
	
	@Disabled // not needed in this class
	@BeforeEach
	void repetitiveSetup()
	{
		System.out.println("Set for each test");
	}
	
	// simple repetitive testing
	@Disabled
	@RepeatedTest(90)
	void regressiveTestRunner(RepetitionInfo repetitionInfo)
	{
		argsValueNumber = argsValueNumber--;
		argsValueString = String.valueOf(argsValueNumber);
		
		args[8] = argsValueString;
		
		System.out.println("Repetitions : " + repetitionInfo);
		
		// runner = new CLAMI();
		// runner.runner(args);
	}
	
	@Disabled
	@ParameterizedTest
	@ValueSource(strings = {"data/sample1.arff", "data/sampe2.arff", "..."})
	void testRunnerVariousInputs(String inputData)
	{
		System.out.println("Chaning input data : " + inputData);
		args[1] = inputData;
		
		// runner = new CLAMI();
		// runner.runner(args);
	
		
	}
	
	
}
