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
   

    @Override
    public void start(Stage primaryStage) {
    	
    
        
        // Create the controler (test)
        
        CalculatorControler controler = new CalculatorControler();
        
        VBox root = new VBox();
        Scene scene = new Scene(root, 400, 400);

        // Create the accumulator view
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

            // Set the link with the stack for each button being clicked
            digitButton.setOnAction(event -> {
                double value = Double.parseDouble(digitButton.getText());
                controler.addButtonValueToStack(value); 
            });
        }



        // Create buttons for operators
        Button addButton = new Button("+");
        Button subtractButton = new Button("-");
        Button multiplyButton = new Button("*");
        Button divideButton = new Button("/");
        Button equalsButton = new Button("=");

        buttonGrid.add(addButton, 3, 0);
        buttonGrid.add(subtractButton, 3, 1);
        buttonGrid.add(multiplyButton, 3, 2);
        buttonGrid.add(divideButton, 3, 3);
        buttonGrid.add(equalsButton, 2, 3);
        
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
        });

     
       


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
