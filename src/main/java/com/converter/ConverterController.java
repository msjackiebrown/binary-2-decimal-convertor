package com.converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controller class for the Binary to Decimal Converter UI.
 * This class handles user interaction and validation for the JavaFX interface.
 */
public class ConverterController {
    
    private static final Logger logger = LogManager.getLogger(ConverterController.class);
    
    @FXML
    private TextField binaryInput;
    
    @FXML
    private TextField decimalResult;
    
    @FXML
    private Button convertButton;
    
    @FXML
    private Button clearButton;
    
    /**
     * Converts binary input to decimal when the Convert button is clicked.
     * Validates that the input contains only 0s and 1s.
     * 
     * @param event The action event triggered by clicking the Convert button
     */
    @FXML
    public void convertBinaryToDecimal(ActionEvent event) {
        String binaryValue = binaryInput.getText();
        logger.debug("Converting binary value: {}", binaryValue);
        
        // Validate input is a binary number
        if (binaryValue == null || binaryValue.isEmpty() || !binaryValue.matches("[01]+")) {
            logger.warn("Invalid binary input: {}", binaryValue);
            showAlert("Invalid Input", "Please enter a valid binary number (0s and 1s only)");
            return;
        }
        
        try {
            // Convert binary to decimal using the utility class
            int decimal = BinaryConverter.binaryToDecimal(binaryValue);
            decimalResult.setText(String.valueOf(decimal));
            logger.info("Converted binary {} to decimal {}", binaryValue, decimal);
        } catch (NumberFormatException e) {
            logger.error("Error converting binary to decimal", e);
            showAlert("Conversion Error", "The number is too large for an integer. Try a shorter binary number.");
        } catch (Exception e) {
            logger.error("Unexpected error during conversion", e);
            showAlert("Conversion Error", "An error occurred during conversion");
        }
    }
    
    /**
     * Clears all input fields when the Clear button is clicked.
     * 
     * @param event The action event triggered by clicking the Clear button
     */
    @FXML
    public void clearFields(ActionEvent event) {
        logger.debug("Clearing input fields");
        binaryInput.clear();
        decimalResult.clear();
    }
    
    /**
     * Display an alert dialog with the given title and message.
     * 
     * @param title The title of the alert dialog
     * @param message The message to display in the alert dialog
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
