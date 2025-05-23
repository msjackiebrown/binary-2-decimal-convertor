package com.converter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Main application class for the Binary to Decimal Converter
 */
public class BinaryDecimalConverterApp extends Application {
    
    private static final Logger logger = LogManager.getLogger(BinaryDecimalConverterApp.class);
    
    @Override
    public void start(Stage primaryStage) {
        try {
            logger.info("Starting Binary to Decimal Converter application");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/converter.fxml"));
            Parent root = loader.load();
            
            primaryStage.setTitle("Binary to Decimal Converter");
            primaryStage.setScene(new Scene(root, 600, 400));
            primaryStage.show();
            
            logger.info("Application UI loaded successfully");
        } catch (IOException e) {
            logger.error("Failed to start application", e);
        }
    }
    
    public static void main(String[] args) {
        logger.info("Launching Binary to Decimal Converter application");
        launch(args);
    }
}
