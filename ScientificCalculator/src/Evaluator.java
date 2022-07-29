

public class Evaluator {
	int currentPos = -1;
	String expression;
	char ch;
	
	public Double evaluate(String exp) {
		resetValues(exp);		
		nextChar();
		Double x = evalAddSub();
		if(currentPos < expression.length())
			throw new RuntimeException("SYNTAX ERROR");
		return x;
	}

	private void nextChar() {	
		ch = ++currentPos < expression.length() ? expression.charAt(currentPos): ' ';
	}
	
	private boolean removeOperator(char op) {
		if(ch == op) {
			nextChar();
			return true;
		}
		return false;
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
				case "log":
					x = Math.log10(evalFactors());
					break;
				case "ln":
					x = Math.log(evalFactors());
					break;			
				default:
					throw new RuntimeException("SYNTAX ERROR - Unexpected: " + func);
			}
		}
		else {
			switch(ch) {
				case '√':
					removeOperator('√');
					x = Math.sqrt(evalFactors());
					break;
				default:
					throw new RuntimeException("SYNTAX ERROR - Unexpected: " + ch);
			}
		}
		
		if(removeOperator('E')) x *= Math.pow(10, evalFactors());
		if(removeOperator('²')) x = Math.pow(x, 2);
		if(removeOperator('^')) x = Math.pow(x, evalFactors());
		
		return x;
	}
	
	private void resetValues(String str) {
		expression = str;
		currentPos = -1;
		ch = ' ';
	}
	
}
