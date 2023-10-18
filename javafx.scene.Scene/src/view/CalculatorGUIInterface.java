package view;

import java.util.Stack;

public interface CalculatorGUIInterface {
	void affiche();
	void change(String accu);
	void change(Stack<Double> stackData);

}
