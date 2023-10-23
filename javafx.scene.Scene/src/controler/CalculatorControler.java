package controler;

import java.util.Stack;
import Model.CalculatorModel;
import Model.CalculatorModelInterface;

/**
 * The `CalculatorControler` class acts as a controller in the calculator application.
 * It handles user input, performs calculations, and communicates with the model.
 */
public class CalculatorControler implements CalculatorControlerInterface {

    private CalculatorModel model;

    /**
     * Constructs a new `CalculatorControler` object and initializes the calculator model.
     */
    public CalculatorControler() {
        model = new CalculatorModel();
    }

    /**
     * Signals a change in the accumulator due to user input and displays it.
     *
     * @param accu The updated accumulator value.
     */
    @Override
    public void change(String accu) {
        System.out.println("Accumulator changed to: " + accu);
    }

    /**
     * Signals a change in the stack due to user input and displays it.
     *
     * @param stackData The updated stack data.
     */
    @Override
    public void change(Stack<Double> stackData) {
        System.out.println("Stack changed to: " + stackData);
    }

    /**
     * Adds the value of a button to the stack.
     *
     * @param value The value to be added to the stack.
     */
    public void addButtonValueToStack(double value) {
        model.push(value);
    }

    /**
     * Calculates the result based on the current state of the model.
     *
     * @return The result of the calculation.
     */
    public double calculate() {
        return model.calculate();
    }

    /**
     * Signals an "Enter" operation to the model.
     */
    public void enter() {
        model.enter();
    }

    /**
     * Clears the accumulator in the model.
     */
    public void clearAccumulator() {
        model.clearAccumulator();
    }

    /**
     * Clears the model and the accumulator.
     */
    public void clear() {
        model.clear();
        model.clearAccumulator();
    }

    /**
     * Performs an operation based on user input. If the operation is a number, it's pushed onto the stack;
     * otherwise, it performs the corresponding operation.
     *
     * @param operation The operation to be performed.
     */
    public void performOperation(String operation) {
        try {
            double number = Double.parseDouble(operation);
            model.push(number);
        } catch (NumberFormatException e) {
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
                default:
                    System.out.println("Invalid operation: " + operation);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Main method for the CalculatorControler class (not used in this application).
    }
}
