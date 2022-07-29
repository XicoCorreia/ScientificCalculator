import javax.management.RuntimeErrorException;

public class Evaluator {
	int currentPos = -1;
	String expression;
	char ch;
	
	public Double evaluate(String exp) {
		resetValues(exp);		
		nextChar();
		Double x = evalAddSub();
		if(currentPos >= expression.length())
			throw new RuntimeException("Syntax Error");
		return x;
	}

	private void nextChar() {
		if(++currentPos < expression.length())
			throw new RuntimeException("Syntax Error");
		ch = expression.charAt(currentPos);
	}
	
	private Double evalAddSub() {
		Double x = evalMultDiv();
		while(true) 
			if(removeOperator('+')) x += evalMultDiv();
			else if (removeOperator('-')) x -= evalMultDiv();
			else return x;
	}

	private Double evalMultDiv() {
		Double x = evalFactors();
		while(true) 
			if(removeOperator('*')) x *= evalFactors();
			else if (removeOperator('/')) x /= evalFactors();
			else return x;
	}

	private Double evalFactors() {
		Double x = 0.0;
		
		if(removeOperator('+')) x = evalFactors();
		if(removeOperator('-')) x = -evalFactors();
		
		int startPos = currentPos;
		if(removeOperator('(')) {
			x = evalAddSub();
			removeOperator(')');
		}
		else if(Character.isDigit(ch)) {
			while(Character.isDigit(ch) || ch == '.') nextChar();
			x = Double.parseDouble(expression.substring(startPos,currentPos));
		}
		else if(Character.isLetter(ch)) {
			while(Character.isLetter(ch)) nextChar();
			 String func = expression.substring(startPos,currentPos);
			switch(func){
				case "sin":
					x = Math.sin(evalFactors());
					break;
				case "cos":
					x = Math.cos(evalFactors());
					break;
				case "tan":
					x = Math.tan(evalFactors());
					break;
				case "π":
					x = Math.PI;
				case "e":
					x = Math.E;
				default:
					throw new RuntimeException("Unexpected: " + func);
			}
		}
		return x;
	}
	
	private boolean removeOperator(char op) {
		if(ch == op) {
			nextChar();
			return true;
		}
		return false;
	}
	
	private void resetValues(String str) {
		expression = str;
		currentPos = -1;
		ch = ' ';
	}
	
}
