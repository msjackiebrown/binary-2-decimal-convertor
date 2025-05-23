package com.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for binary-to-decimal conversion operations.
 * 
 * <p>Binary numbers are base-2 numbers, which means they only use two digits: 0 and 1.
 * Each position in a binary number represents a power of 2, starting from 2^0 (which is 1)
 * at the rightmost position, and increasing by a power of 2 as we move left.</p>
 * 
 * <p>For example, the binary number 1011 is calculated as:</p>
 * <ul>
 *   <li>1 × 2^3 = 1 × 8 = 8</li>
 *   <li>0 × 2^2 = 0 × 4 = 0</li>
 *   <li>1 × 2^1 = 1 × 2 = 2</li>
 *   <li>1 × 2^0 = 1 × 1 = 1</li>
 * </ul>
 * <p>Adding these up: 8 + 0 + 2 + 1 = 11 (decimal)</p>
 */
public class BinaryConverter {
    
    private static final Logger logger = LogManager.getLogger(BinaryConverter.class);
    
    /**
     * Converts a binary string to its decimal equivalent using Java's built-in Integer.parseInt method.
     * 
     * @param binaryString A string containing only 0s and 1s
     * @return The decimal (base-10) equivalent of the binary number
     * @throws IllegalArgumentException if the input is not a valid binary number
     */
    public static int binaryToDecimal(String binaryString) {
        // Validate input
        if (binaryString == null || binaryString.isEmpty()) {
            logger.error("Invalid binary input: null or empty string");
            throw new IllegalArgumentException("Binary string cannot be null or empty");
        }
        
        if (!binaryString.matches("[01]+")) {
            logger.error("Invalid binary input: {}", binaryString);
            throw new IllegalArgumentException("Binary string can only contain 0s and 1s");
        }
        
        // Using the built-in Integer.parseInt with base 2
        // This is more efficient than manual calculation
        int decimal = Integer.parseInt(binaryString, 2);
        logger.debug("Converted binary {} to decimal {}", binaryString, decimal);
        
        return decimal;
    }
    
    /**
     * Alternative implementation using mathematical operations (power of 2).
     * This method calculates the decimal value manually without using Integer.parseInt.
     * 
     * <p>The calculation follows these steps:</p>
     * <ol>
     *   <li>Initialize the result to 0</li>
     *   <li>For each digit in the binary number (from right to left):</li>
     *   <li>If the digit is 1, add 2^position to the result</li>
     *   <li>If the digit is 0, add 0 to the result</li>
     * </ol>
     * 
     * @param binaryString A string containing only 0s and 1s
     * @return The decimal (base-10) equivalent of the binary number
     * @throws IllegalArgumentException if the input is not a valid binary number
     */
    public static int binaryToDecimalMath(String binaryString) {
        // Validate input
        if (binaryString == null || binaryString.isEmpty()) {
            logger.error("Invalid binary input: null or empty string");
            throw new IllegalArgumentException("Binary string cannot be null or empty");
        }
        
        if (!binaryString.matches("[01]+")) {
            logger.error("Invalid binary input: {}", binaryString);
            throw new IllegalArgumentException("Binary string can only contain 0s and 1s");
        }
        
        int result = 0;
        int length = binaryString.length();
        
        // Process each digit from right to left (least significant to most significant)
        for (int i = 0; i < length; i++) {
            char digit = binaryString.charAt(length - 1 - i);
            
            // If the digit is '1', add the corresponding power of 2
            if (digit == '1') {
                result += Math.pow(2, i);
            }
        }
        
        logger.debug("Math method converted binary {} to decimal {}", binaryString, result);
        return result;
    }
}
