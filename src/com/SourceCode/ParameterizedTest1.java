package com.SourceCode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTest1 {

	// runs as many as input sources
	
	// 1. ValueSource (short, byte, int,... String, Class)
	@ParameterizedTest
	@ValueSource(ints = {1,2,3,4})
	//@ValueSource(strings = {"first string", "second string"})
	void simpleParameterizedTest(int argument)
	{
		assertTrue(argument > 0 && argument < 5);
	}
	
	// 2. EnumSource
	@ParameterizedTest
	@EnumSource(TimeUnit.class)
	void testWithEnumSource(TimeUnit timeUnit)
	{
		assertNotNull(timeUnit);
	}
	/*
	//EnumSource(with mode)
	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, mode = EXCLUDE, names = { "DAYS", "HOURS" })
	void testWithEnumSourceExclude(TimeUnit timeUnit) {
	    assertFalse(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
	    assertTrue(timeUnit.name().length() > 5);
	}
	*/
	
	// 3. MethodSource
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithSimpleMethodSource(String argument)
	{
		assertNotNull(argument);
	}
	
	// Factory method providing arguments : should return Stream/Iterable/Iterator or array of arguments.
	// Also, they must be static (unless annotated with @TestInstance(LifeCycle.PER_CLASS);
	static Stream<String> stringProvider()
	{
		return Stream.of("foo", "bar");
	}
	
	// 4. CsvSource
	@ParameterizedTest
	@CsvSource({"foo, 1", "bar, 2", "'baz, qux',3"})
	void testWithCsvSource(String first, int second)
	{
		assertNotNull(first);
		assertNotEquals(0, second);
	}
	
	
	// 4-1. CsvFileSource
	// Can use CSV files from the classpath. Each line from the CSV file is one invocation for a test
	@Disabled
	@ParameterizedTest
	@CsvFileSource(resources = "/two-column.csv", delimiter = ',')
	void testWithCsvFileSource(String first, int second)
	{
		assertNotNull(first);
		assertNotEquals(0, second);
		/* CSV file examples below
		 * 
		 * Country, reference
		 * Korea, 1
		 * Japan, 2
		 * Poland, 3
		 * "United States of America", 4
		 */
	}
	
	
	// 5. ArgumentsSource (?)
	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void testWithArgumentsSource(String argument) {
	    assertNotNull(argument);
	}

	public class MyArgumentsProvider implements ArgumentsProvider {

	    @Override
	    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
	        return Stream.of("foo", "bar").map(Arguments::of);
	    }
	}
	
	@RepeatedTest(10)
	void repeatedTest() //RepetitionInfo repetitionInfo
	{
		//assertEquals(5, repetitionInfo.getTotalRepetitions());
	}
	
}
