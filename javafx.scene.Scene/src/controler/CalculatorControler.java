package controler;

import java.util.Stack;

import Model.CalculatorModel;
import Model.CalculatorModelInterface;

public class CalculatorControler implements CalculatorControlerInterface {
	
	public CalculatorModel model;
	
	public CalculatorControler() {
        model = new CalculatorModel(); // Initialize the calculator model
    }

	@Override
	public void change(String accu) {
		// Method handling the changes on the accumulator due to the user's input and displaying it 
		
		System.out.println("Accumulator changed to: " + accu);
	}

	@Override
	public void change(Stack<Double> stackData) {
		// Method handling the changes on the stack due to the user's input and displaying it 
		
		System.out.println("Stack changed to: " + stackData);
	}
	
	// Method to add the value of a button to the stack
    public void addButtonValueToStack(double value) {
        model.push(value);
    }
	
	public void performOperation(String operation) {
	    // Check if the operation is a number represented as a string
	    try {
	        double number = Double.parseDouble(operation);
	        // Push the number onto the stack
	        model.push(number);
	    } catch (NumberFormatException e) {
	        // If it's not a number, then perform the operation
	        switch (operation) {
	            case "add":
	                model.add();
	                break;
	            case "subtract":
	                model.subtract();
	                break;
	            case "multiply":
	                model.multiply();
	                break;
	            case "divide":
	                model.divide();
	                break;
	            case "opposite":
	                model.opposite();
	                break;
	            case "equals":
	                model.getAccumulator();
	                break;
	            default:
	            	System.out.println("Invalid operation: " + operation);
	                break;
	        }
	    }
	}

	 
	  public static void main(String[] args) {
		  
		  CalculatorControler calculator = new CalculatorControler();
	        
		    calculator.performOperation("3");
	        calculator.performOperation("5");
	        calculator.performOperation("add");
	        calculator.performOperation("2");
	        calculator.performOperation("multiply");
	        calculator.performOperation("4");
	        calculator.performOperation("divide");
	        calculator.performOperation("1");
	        calculator.performOperation("subtract");
	        System.out.println(calculator.model.getAccumulator());
	        
	        
	    }

}
