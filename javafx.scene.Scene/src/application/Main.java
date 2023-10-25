package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import controler.CalculatorControler;

/**
 * The `Main` class is the entry point for the RPN Calculator application.
 * It extends the JavaFX `Application` class to create a GUI for the calculator.
 */
public class Main extends Application {
    
    // Attributes

    // Label to display the result (accumulator)
    private Label accumulatorLabel;

    // Buffer to hold user input
    private String inputBuffer = "";

    /**
     * Getter for the input buffer.
     * @return The current contents of the input buffer.
     */
    public String getInputBuffer() {
        return inputBuffer;
    }

    @Override
    public void start(Stage primaryStage) {
        
        // Create the controller
        CalculatorControler controler = new CalculatorControler();
        
        // Create a vertical layout container VBox 
        VBox root = new VBox();
        
        // Create a new scene associated with the VBox container 
        Scene scene = new Scene(root, 220, 300);
        
        // Create a new label for the accumulatorLabel
        accumulatorLabel = new Label("Result: 0");
        
        // Set the minimum height for the accumulatorLabel
        accumulatorLabel.setMinHeight(40);

        // Create a grid for the buttons
        GridPane buttonGrid = new GridPane();
        
        // Set horizontal and vertical gaps between buttons
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);

        // Create numeric buttons (0-9), set the minimum size, add the buttons to the button grid, set the style and set the action
        for (int i = 9; i >= 0; i--) {
        	
        	//Create the button
            Button digitButton = new Button(Integer.toString(i));
            
            //Set the minimum size
            digitButton.setMinSize(40, 40);
            
            // Add each digit button to the grid
            buttonGrid.add(digitButton, (9 - i) % 3, (9 - i) / 3);
            
            //Set the button style
            digitButton.setStyle(
                "-fx-background-color: #3c4043; " + // Dark gray background color
                "-fx-text-fill: white; " + // White text color 
                "-fx-font-size: 18px;" // Font size
            );

            // Set the action for each button being clicked
            digitButton.setOnAction(event -> {
                // Append the clicked digit to the input buffer
                inputBuffer += digitButton.getText();
                // Update the accumulator label to show the current state of the input buffer
                accumulatorLabel.setText("Accumulator: " + inputBuffer);
            });
        }

        // Create buttons for arithmetic operators
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");
        
        //Set the minimum size for each operators button
        equalsButton.setMinSize(40, 40);
        addButton.setMinSize(40, 40);
        subtractButton.setMinSize(40, 40);
        divideButton.setMinSize(40, 40);
        multiplyButton.setMinSize(40, 40);

        // Add operator buttons to the grid
        buttonGrid.add(addButton, 3, 0);
        buttonGrid.add(subtractButton, 3, 1);
        buttonGrid.add(multiplyButton, 3, 2);
        buttonGrid.add(divideButton, 3, 3);
        buttonGrid.add(equalsButton, 2, 3);

        // Create a button for "Enter", set its size and add it to the grid 
        Button enterButton = new Button("Enter");
        enterButton.setMinSize(40, 40);
        buttonGrid.add(enterButton, 2, 4);

        // Create the "Clear" button, set its size and add it to the grid 
        Button clearButton = new Button("Clear");
        clearButton.setMinSize(40, 40);
        buttonGrid.add(clearButton, 3, 4);

        // Create the "Dot" button, set its size and add it to the grid 
        Button dotButton = new Button(".");
        dotButton.setMinSize(40, 40);
        buttonGrid.add(dotButton, 1, 3);

        // Add event handlers to operator buttons and the buttons Enter, Dot and Clear
        
        // Set the action for the Add button
        addButton.setOnAction(event -> {
            controler.performOperation("add"); // Call the controller's addition method
        });

        // Set the action for the Subtract button
        subtractButton.setOnAction(event -> {
            if (!inputBuffer.isEmpty()) { // Manage the case where we use the button to define a negative number 
                double value = Double.parseDouble(inputBuffer);
                double oppositeValue = -value;
                inputBuffer = String.valueOf(oppositeValue);
                accumulatorLabel.setText("Accumulator: " + inputBuffer);
            } else { // Manage the case where we use the button to perform the operation "subtract"
                controler.performOperation("subtract"); // Call the controller's subtraction method
            }
        });

        // Set the action for the Multiply button
        multiplyButton.setOnAction(event -> {
            controler.performOperation("multiply"); // Call the controller's multiplication method
        });

        // Set the action for the Divide button
        divideButton.setOnAction(event -> {
            controler.performOperation("divide"); // Call the controller's division method
        });

        // Set the action for the Equals button
        equalsButton.setOnAction(event -> {
            // Update the view with the new accumulator value
            double accumulatorValue = controler.calculate(); 
            accumulatorLabel.setText("Result: " + accumulatorValue); 
            controler.clearAccumulator(); // Clear the accumulator to start a potential new operation
            inputBuffer = ""; // Clear the input buffer for the next number
        });

        // Set the action for the Enter button
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
            } else {
                // Display an error message when the input buffer is empty
                accumulatorLabel.setText("Error: No number entered");
            }
        });

        // Set the action for the Dot button
        dotButton.setOnAction(event -> {
            // Append a dot (.) to the input buffer
            inputBuffer += ".";
            // Update the accumulator label to show the current state of the input buffer
            accumulatorLabel.setText("Accumulator: " + inputBuffer);
        });

        // Set the action for the Clear button
        clearButton.setOnAction(event -> {
            controler.clear(); // Call the controller's clear method
            inputBuffer = "";
            // Update the accumulator label to show the cleared accumulator
            accumulatorLabel.setText("Accumulator: 0");
        });

        // Set style for the buttons

        // Style for the equals button
        equalsButton.setStyle(
            "-fx-font-size: 15px; " + // Set the font size
            "-fx-background-color: #8ab4f9; " + // Set a background color 
            "-fx-text-fill: white;" // Set the text color to white
        );

        // Style for the "Clear" button
        clearButton.setStyle(
            "-fx-background-color: #B30000; "  + // Set the background color to red
            "-fx-text-fill: white;" // Set the text color to white 
        );

        // Set the style for operator buttons
        String operatorButtonStyle = "-fx-background-color: #5f6369; " + // Dark gray background color
            "-fx-text-fill: white; " + // White text color 
            "-fx-font-size: 18px;"; // Font size

        // Apply the style to the operator buttons
        addButton.setStyle(operatorButtonStyle);
        subtractButton.setStyle(operatorButtonStyle);
        multiplyButton.setStyle(operatorButtonStyle);
        divideButton.setStyle(operatorButtonStyle);
        equalsButton.setStyle(operatorButtonStyle);
        dotButton.setStyle(operatorButtonStyle);

        // Style for the "Enter" button as a dark green button
        String enterButtonStyle = "-fx-background-color: #006400; " + // Dark green background color
            "-fx-text-fill: white; ";  // White text color 

        // Apply the style to the Enter Button
        enterButton.setStyle(enterButtonStyle);

        // Create a border style for the label
        String labelBorderStyle = "-fx-border-color: #5f6369; " + // Dark gray border color
            "-fx-border-width: 2px; " + // Border width
            "-fx-border-radius: 5px;"; // Border corner radius

        // Set the style for the "Result" label
        accumulatorLabel.setStyle(
            "-fx-font-size: 14px; " + // Set the font size
            "-fx-font-weight: normal; " + // Set the font weight
            "-fx-padding: 5px; " + // Set the padding
            "-fx-background-color: #E0E0E0; " + // Set a light gray background color
            "-fx-background-insets: 0; " + // Remove background insets
            "-fx-background-radius: 0; " + // Remove background radius
            labelBorderStyle // Add the border style
        );
        
        // Set the minimum height for the accumulatorLabel
        accumulatorLabel.setMinHeight(40);

        // Add the views and button grid to the root VBox
        root.getChildren().addAll(accumulatorLabel, buttonGrid);

        // Set the scene for the primary stage, which defines the content to be displayed.
        primaryStage.setScene(scene);
        
        // Set the title of the primary stage, which appears in the window's title bar.
        primaryStage.setTitle("RPN Calculator");
        
        // Display the primary stage, showing the graphical user interface to the user.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

