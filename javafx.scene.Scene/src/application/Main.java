package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



import controler.CalculatorControler;

public class Main extends Application {
    private Label accumulatorLabel;
    private String inputBuffer = "";

    @Override
    public void start(Stage primaryStage) {
    	
    
        
        // Create the controler (test)
        
        CalculatorControler controler = new CalculatorControler();
        
        VBox root = new VBox();
        Scene scene = new Scene(root, 220, 300);

        accumulatorLabel = new Label("Result: 0");
        
        accumulatorLabel.setMinHeight(40);


       

        // Create a grid for the buttons
        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);

     // Create numeric buttons
        for (int i = 9; i >= 0; i--) {
            Button digitButton = new Button(Integer.toString(i));
            digitButton.setMinSize(40, 40);
            buttonGrid.add(digitButton, (9 - i) % 3, (9 - i) / 3);
            
            digitButton.setStyle(
                    "-fx-background-color: #3c4043; " + // Dark gray background color
                    "-fx-text-fill: white; " + // White text color for better visibility
                    "-fx-font-size: 18px;" // Font size
                );

            // Set the link with the stack for each button being clicked
            digitButton.setOnAction(event -> {
                // Append the clicked digit to the input buffer
                inputBuffer += digitButton.getText();
                // Update the accumulator label to show the current state of the input buffer
                accumulatorLabel.setText("Accumulator: " + inputBuffer);
            });
        }



        // Create buttons for operators
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");
        equalsButton.setMinSize(40, 40);
        addButton.setMinSize(40, 40);
        subtractButton.setMinSize(40, 40);
        divideButton.setMinSize(40, 40);
        multiplyButton.setMinSize(40, 40);

       
        
        buttonGrid.add(addButton, 3, 0);
        buttonGrid.add(subtractButton, 3, 1);
        buttonGrid.add(multiplyButton, 3, 2);
        buttonGrid.add(divideButton, 3, 3);
        buttonGrid.add(equalsButton, 2, 3);
        
     // Create a numeric button for "Enter"
        Button enterButton = new Button("Enter");
        enterButton.setMinSize(40, 40);
        buttonGrid.add(enterButton, 2, 4);
        
     // Create the "Clear" button
        Button clearButton = new Button("Clear");
        clearButton.setMinSize(40, 40);
        buttonGrid.add(clearButton, 3, 4);
        
     // Create the "Comma" button
        Button dotButton = new Button(".");
        dotButton.setMinSize(40, 40);
        buttonGrid.add(dotButton, 1, 3);
        
     // Add event handlers to operator buttons
        addButton.setOnAction(event -> {
            controler.performOperation("add"); // Call the controller's addition method
        });

        subtractButton.setOnAction(event -> {
            controler.performOperation("subtract"); // Call the controller's subtraction method
        });

        multiplyButton.setOnAction(event -> {
            controler.performOperation("multiply"); // Call the controller's multiplication method
        });

        divideButton.setOnAction(event -> {
            controler.performOperation("divide"); // Call the controller's division method
        });
        
        equalsButton.setOnAction(event -> {
       
         // Update the view with the new accumulator value
            double accumulatorValue = controler.calculate();; 
            accumulatorLabel.setText("Result: " + accumulatorValue); 
            
            controler.clearAccumulator();
        });
        
        enterButton.setOnAction(event -> {
            if (!inputBuffer.isEmpty()) {
                // Convert the input buffer to a numeric value and push it onto the stack
                double value = Double.parseDouble(inputBuffer);
                controler.addButtonValueToStack(value);
                
             // Clear the input buffer for the next number
                inputBuffer = "";
                
                // Update the accumulator label with the new accumulator value
                double accumulatorValue = controler.calculate();
                accumulatorLabel.setText("Accumulator: " + accumulatorValue);
         
            }
        });
        
        dotButton.setOnAction(event -> {
            // Append a dot (.) to the input buffer
            inputBuffer += ".";
            // Update the accumulator label to show the current state of the input buffer
            accumulatorLabel.setText("Accumulator: " + inputBuffer);
        });

        
        
        
     // Set the link with the controller for the "Clear" button being clicked
        clearButton.setOnAction(event -> {
            controler.clear(); // Call the controller's clear method
            inputBuffer = "";
            // Update the accumulator label to show the cleared accumulator
            accumulatorLabel.setText("Accumulator: 0");
        });
        
 // Set style for the buttons
        
        equalsButton.setStyle(
        	    "-fx-font-size: 15px; " + // Increase the font size
        	    "-fx-background-color: #8ab4f9; " + // Set a background color (blue in this example)
        	    "-fx-text-fill: white;" // Set the text color to white
        	);
        
        clearButton.setStyle(
        		"-fx-background-color: #B30000; "  + // Set the background color to red
        	    "-fx-text-fill: white;" // Set the text color to white for better visibility
        	);
        
     // Set the style for the operator buttons
        String operatorButtonStyle = "-fx-background-color: #5f6369; " + // Dark gray background color
                                   "-fx-text-fill: white; " + // White text color for better visibility
                                   "-fx-font-size: 18px;"; // Font size

        addButton.setStyle(operatorButtonStyle);
        subtractButton.setStyle(operatorButtonStyle);
        multiplyButton.setStyle(operatorButtonStyle);
        divideButton.setStyle(operatorButtonStyle);
        equalsButton.setStyle(operatorButtonStyle);
        dotButton.setStyle(operatorButtonStyle);
        
     // Set the style for the "Enter" button as a dark green button
        String enterButtonStyle = "-fx-background-color: #006400; " + // Dark green background color
                                "-fx-text-fill: white; ";  // White text color for better visibility
                             

        enterButton.setStyle(enterButtonStyle);
        
     // Create a border style for the label
        String labelBorderStyle = "-fx-border-color: #5f6369; " + // Dark gray border color
                                "-fx-border-width: 2px; " + // Border width
                                "-fx-border-radius: 5px;"; // Border corner radius

        // Set the style for the "Result" label
        accumulatorLabel.setStyle(
            "-fx-font-size: 14px; " + // Decrease the font size
            "-fx-font-weight: normal; " + // Remove bold font weight
            "-fx-padding: 5px; " + // Reduce the padding
            "-fx-background-color: #E0E0E0; " + // Set a light gray background color
            "-fx-background-insets: 0; " + // Remove background insets
            "-fx-background-radius: 0; " + // Remove background radius
            labelBorderStyle // Add the border style
        );
        accumulatorLabel.setMinHeight(40);




        // Add the views and button grid to the root VBox
        root.getChildren().addAll(accumulatorLabel, buttonGrid);

        primaryStage.setScene(scene);
        primaryStage.setTitle("RPN Calculator");
        primaryStage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
        
        
    }
}
