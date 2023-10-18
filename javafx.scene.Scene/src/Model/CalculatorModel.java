package Model;

import java.util.Stack;

public class CalculatorModel implements CalculatorModelInterface {
	// Attribute representing the stack of the calculator
	private Stack<Double> stack;
	// Attribute representing the accumulator of the calculator
	private double accumulator;
    
	// Constructor of the class CalculatorModel
	public CalculatorModel() {		
		stack = new Stack<>();
		accumulator = 0.0;
    }
	
	// Method to add an element in the stack
    public void push(double value) {
    	stack.push(value);
        
    }
    
 // Method to pop an element out of the stack
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } 
        else {
            System.out.println("The stack is empty");
        }
    }
    
 // Method to clear the stack 
    public void clear() {
        stack.clear();
    }
    
 // Method to swap the two elements at the top of the stack 
    public void swap() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            stack.push(topElement);
            stack.push(secondTopElement);
        } 
        else {
            System.out.println("There are not enough elements to make a swap");
        }
    }
    
    // Method to remove the last element from the stack without returning it
    public void drop() {
        if (!stack.isEmpty()) {
            int lastIndex = stack.size() - 1;
            stack.remove(lastIndex);
        } else {
            System.out.println("The stack is empty.");
        }
    }
    
    
 // Method to add the last two elements of the stack and put the result back in the stack
    public void add() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            double result = topElement + secondTopElement;
            stack.push(result);
            accumulator = stack.peek();
   
        } else {
            System.out.println("There are not enough elements in the stack to add");
        }
    }
    
 // Method to subtract the last two elements of the stack and put the result back in the stack
    public void subtract() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            double result = secondTopElement - topElement;
            stack.push(result);
            accumulator = stack.peek();

        } else {
            System.out.println("There are not enough elements in the stack to subtract.");
        }
    }
    
 // Method to divide the last two elements of the stack and put the result back in the stack
    public void divide() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            if (topElement != 0) {
                double result = secondTopElement / topElement;
                stack.push(result);
                accumulator = stack.peek();

            } else {
                System.out.println("Division by zero is not allowed.");
            }
        } else {
            System.out.println("There are not enough elements in the stack to divide.");
        }
    }
    
 // Method to negate (change sign) of the last element on the stack
    public void opposite() {
        if (!stack.isEmpty()) {
            double topElement = stack.pop();
            double result = -topElement;
            stack.push(result);
            accumulator = stack.peek();

        } else {
            System.out.println("The stack is empty.");
        }
    }

 // Method to multiply the last two elements of the stack and put the result back in the stack
    public void multiply() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            double result = secondTopElement * topElement;
            stack.push(result);
            accumulator = stack.peek();
        } else {
            System.out.println("There are not enough elements in the stack to multiply.");
        }
    }

 // Return a copy of the stack
    public Stack<Double> getStack() {
        return stack;
    }
 
 // Return a copy of the accumulator
    public double getAccumulator() {
        return accumulator;
    }



}
