package controler;

import java.util.Stack;

/**
 * The `CalculatorControlerInterface` defines the interface for the controller in the calculator application.
 */
public interface CalculatorControlerInterface {

    /**
     * Signals a change in the accumulator due to user input.
     *
     * @param accu The updated accumulator value.
     */
    void change(String accu);

    /**
     * Signals a change in the stack due to user input.
     *
     * @param stackData The updated stack data.
     */
    void change(Stack<Double> stackData);
}
