package Model;

import java.util.Stack;

/**
 * The `CalculatorModel` class represents the model of a calculator. It contains methods for
 * manipulating a stack and an accumulator for performing arithmetic operations.
 */
public class CalculatorModel implements CalculatorModelInterface {

    // Attribute representing the stack of the calculator
    private Stack<Double> stack;

    // Attribute representing the accumulator of the calculator
    private double accumulator;

    /**
     * Constructs a new `CalculatorModel` object. Initializes the stack and accumulator.
     */
    public CalculatorModel() {
        stack = new Stack<>();
        accumulator = 0.0;
    }

    /**
     * Adds an element to the stack.
     *
     * @param value The value to be pushed onto the stack.
     */
    public void push(double value) {
        stack.push(value);
    }

    /**
     * Pops an element from the stack if it's not empty; otherwise, displays a message.
     */
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } else {
            System.out.println("The stack is empty");
        }
    }

    /**
     * Clears the stack and returns the value of the accumulator.
     *
     * @return The value of the accumulator.
     */
    public double calculate() {
        return accumulator;
    }

    /**
     * Swaps the two elements at the top of the stack if there are at least two elements;
     * otherwise, displays a message.
     */
    public void swap() {
        if (stack.size() >= 2) {
            double topElement = stack.pop();
            double secondTopElement = stack.pop();
            stack.push(topElement);
            stack.push(secondTopElement);
        } else {
            System.out.println("There are not enough elements to make a swap");
        }
    }

    /**
     * Removes the last element from the stack without returning it if the stack is not empty;
     * otherwise, displays a message.
     */
    public void drop() {
        if (!stack.isEmpty()) {
            int lastIndex = stack.size() - 1;
            stack.remove(lastIndex);
        } else {
            System.out.println("The stack is empty.");
        }
    }

    /**
     * Clears the accumulator.
     */
    public void clearAccumulator() {
        this.accumulator = 0;
    }

    /**
     * Adds the last two elements of the stack and puts the result back in the stack if there are
     * at least two elements; otherwise, displays a message.
     */
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

    /**
     * Subtracts the last two elements of the stack and puts the result back in the stack if there are
     * at least two elements; otherwise, displays a message.
     */
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

    /**
     * Divides the last two elements of the stack and puts the result back in the stack if there are
     * at least two elements; otherwise, displays a message. Division by zero is handled.
     *
     * @param
     */
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

    /**
     * Negates (changes the sign of) the last element on the stack if the stack is not empty;
     * otherwise, displays a message.
     */
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

    /**
     * Pushes the current accumulator value onto the stack.
     */
    public void enter() {
        stack.push(accumulator);
    }

    /**
     * Multiplies the last two elements of the stack and puts the result back in the stack if there are
     * at least two elements; otherwise, displays a message.
     */
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

    /**
     * Clears both the stack and the accumulator.
     */
    @Override
    public void clear() {
        stack.clear();
        accumulator = 0.0;
    }

    /**
     * Returns a copy of the stack.
     *
     * @return A copy of the stack.
     */
    public Stack<Double> getStack() {
        return stack;
    }

    /**
     * Returns a copy of the accumulator value.
     *
     * @return The value of the accumulator.
     */
    public double getAccumulator() {
        return accumulator;
    }
}
