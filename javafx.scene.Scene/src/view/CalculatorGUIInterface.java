package view;

import java.util.Stack;

/**
 * The `CalculatorGUIInterface` defines the interface for the graphical user interface (GUI) of a calculator.
 */
public interface CalculatorGUIInterface {
    /**
     * Displays the GUI for the calculator.
     */
    void affiche();

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
