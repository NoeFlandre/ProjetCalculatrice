package Model;

/**
 * The `CalculatorModelInterface` defines the interface for the model of a calculator.
 * It includes methods for manipulating a stack and performing arithmetic operations.
 */
public interface CalculatorModelInterface {
	/**
	 * Pushes the specified value onto the stack.
	 *
	 * @param value The value to be pushed onto the stack.
	 */
	void push(double value);

	/**
	 * Removes the top element from the stack and returns it.
	 */
	void pop();

	/**
	 * Clears the entire stack.
	 */
	void clear();

	/**
	 * Swaps the positions of the top two elements on the stack.
	 */
	void swap();

	/**
	 * Removes the top element from the stack without returning it.
	 */
	void drop();

	/**
	 * Adds the top two elements on the stack and pushes the result back onto the stack.
	 */
	void add();

	/**
	 * Subtracts the top element from the element below it and pushes the result onto the stack.
	 */
	void subtract();

	/**
	 * Divides the second-to-top element by the top element and pushes the result onto the stack.
	 */
	void divide();

	/**
	 * Changes the sign of the top element on the stack (makes it positive or negative).
	 */
	void opposite();

	/**
	 * Multiplies the top two elements on the stack and pushes the result onto the stack.
	 */
	void multiply();

	/**
	 * Indicates the completion of entering a numeric value onto the stack.
	 */
	void enter();

}
