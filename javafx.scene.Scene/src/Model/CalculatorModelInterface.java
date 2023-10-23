package Model;

/**
 * The `CalculatorModelInterface` defines the interface for the model of a calculator.
 * It includes methods for manipulating a stack and performing arithmetic operations.
 */
public interface CalculatorModelInterface {
    void push(double value);
    void pop();
    void clear();
    void swap();
    void drop();
    void add();
    void subtract();
    void divide();
    void opposite();
    void multiply();
    void enter();
}
