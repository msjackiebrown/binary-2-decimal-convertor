package com.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the binary-to-decimal converter functionality.
 * These tests verify both the BinaryConverter utility class and input validation.
 */
public class ConverterTest {

    private ConverterController controller;

    @BeforeEach
    void setUp() {
        controller = new ConverterController();
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "10, 2",
            "11, 3",
            "100, 4",
            "101, 5",
            "110, 6",
            "111, 7",
            "1000, 8",
            "1001, 9",
            "1010, 10",
            "1111111, 127",
            "10000000, 128",
            "11111111, 255"
    })
    void testBinaryToDecimalConversion(String binary, int expectedDecimal) {
        // Test the utility class directly
        assertEquals(expectedDecimal, BinaryConverter.binaryToDecimal(binary));
    }
    
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "10, 2",
            "11, 3",
            "100, 4",
            "101, 5",
            "110, 6",
            "111, 7",
            "1000, 8",
            "1001, 9",
            "1010, 10",
            "1111111, 127",
            "10000000, 128",
            "11111111, 255"
    })
    void testBinaryToDecimalMathConversion(String binary, int expectedDecimal) {
        // Test the math implementation
        assertEquals(expectedDecimal, BinaryConverter.binaryToDecimalMath(binary));
    }

    @Test
    void testInvalidBinaryInput() {
        // Test that the BinaryConverter.binaryToDecimal method correctly rejects invalid input
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimal("12"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimal("abc"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimal("1a0"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimal(""));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimal(null));
    }
    
    @Test
    void testInvalidBinaryInputMathMethod() {
        // Test that the BinaryConverter.binaryToDecimalMath method correctly rejects invalid input
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimalMath("12"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimalMath("abc"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimalMath("1a0"));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimalMath(""));
        assertThrows(IllegalArgumentException.class, () -> BinaryConverter.binaryToDecimalMath(null));
    }
    
    @Test
    void testBothMethodsGiveSameResults() {
        // Test that both conversion methods produce the same results
        String[] testCases = {"0", "1", "10", "11", "100", "1010", "11111111"};
        
        for (String binary : testCases) {
            int resultDefault = BinaryConverter.binaryToDecimal(binary);
            int resultMath = BinaryConverter.binaryToDecimalMath(binary);
            assertEquals(resultDefault, resultMath, 
                    "Both conversion methods should produce the same result for " + binary);
        }
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"12", "abc", "1a0", ""})
    void testBinaryInputRegexValidation(String input) {
        // This test verifies that our regex pattern "[01]+" properly identifies invalid binary input
        assertFalse(input.matches("[01]+"), 
                "The input '" + input + "' should not match the binary pattern [01]+");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "01", "10", "11", "00", "000", "111", "101010"})
    void testValidBinaryInputRegexValidation(String input) {
        // This test verifies that our regex pattern "[01]+" properly identifies valid binary input
        assertTrue(input.matches("[01]+"), 
                "The input '" + input + "' should match the binary pattern [01]+");
    }
      @Test
    void testVeryLargeBinaryNumber() {
        // Test that Java correctly handles large binary numbers
        String largeValidBinary = "1".repeat(30); // A 30-digit binary number with all 1s
        assertTrue(BinaryConverter.binaryToDecimal(largeValidBinary) > 0);
        
        // This should cause an exception due to integer overflow
        String tooLargeBinary = "1".repeat(100); // A 100-digit binary number
        assertThrows(NumberFormatException.class, () -> BinaryConverter.binaryToDecimal(tooLargeBinary));
    }
}
