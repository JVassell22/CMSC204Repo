
public class Notation {
	
	static MyStack<String> stack = new MyStack<String>(100);
	static  MyQueue<String> queue = new MyQueue<String>(100);
	
	public Notation(int size) {
		stack = new MyStack<String>(size);
		queue = new MyQueue<String>(size);
	}

	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException {
		String str = "", val1 = "", val2 = "";
		char[] cArr = postfix.toCharArray();
		try {
			for(char s : cArr) {
				if(Character.isDigit(s)) {
					stack.push(String.valueOf(s));
				}
				else if(isOperator(s)) {
					val2 = stack.pop()+")";
					val1 = "("+stack.pop()+s;
					str = val1 + val2;
					stack.push(str);
				}
				else if(s != ' ') {
					throw new InvalidNotationFormatException();
				}
			}
			if(!stack.isEmpty()) {
				queue.enqueue(stack.pop());
			}
			return str;
		}
		catch(StackUnderflowException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
		catch(QueueOverflowException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
		catch(StackOverflowException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
		catch(InvalidNotationFormatException e) {
			System.out.println("An error occured64: " + e.getMessage());
		}
		return null;
	}
	
	public static String convertInfixToPostfix(String infix) {
		String str = "";
		try {
			char[] cArr = infix.toCharArray();
			for(char s : cArr) {
				if(Character.isDigit(s)) {
					queue.enqueue(String.valueOf(s));
				}
				else if(s == '(') {
					stack.push(String.valueOf(s));
				}
				else if(isOperator(s)) {
					while( stack.size() > 0 && isOperator(stack.top().toCharArray()[0])) {
						if(isHigherPrecedence(s,stack.top().toCharArray()[0])) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(String.valueOf(s));
				}
				else if(s == ')') {
					while(stack.top().toCharArray()[0] != '(' && isOperator(stack.top().toCharArray()[0])) {
						queue.enqueue(stack.pop());
						if(stack.size() < 1) {
							throw new InvalidNotationFormatException();
						}
					}
					if(stack.top().toCharArray()[0] == '(') {
						
						stack.pop();
					}
					else if(s != ' ') {
						throw new InvalidNotationFormatException();
					}
				}
			}
			if(stack.size() > 0) {
				while(isOperator(stack.top().toCharArray()[0])) {
					queue.enqueue(stack.pop());
				}
			}
			int x = queue.size();
			for(int i = 0; i < x;i++) {
					str += queue.dequeue();
			}
			
			return str;
		}
		
		catch(StackUnderflowException e) {	
			System.out.println("An error occured: " + e.getMessage());
			e.getStackTrace();
		}
		catch(StackOverflowException e) {	
			System.out.println("An error occured: " + e.getMessage());
		}
		catch(InvalidNotationFormatException e) {
			System.out.println("An error occured: " + e.getMessage());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	
	public static double evaluatePostfixExpression(String postfixExpr) throws StackUnderflowException {
		try {
			char[] cArr = postfixExpr.toCharArray();
			
			for(char s : cArr) {
				if(Character.isDigit(s)) {
					stack.push(String.valueOf(s));
				}
				else if(isOperator(s)) {
					if(stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					double first, second, result = 0;
					first = Double.parseDouble(stack.pop());
					second = Double.parseDouble(stack.pop());
					if(s == '+') {
						result = first+second;
					}
					else if(s == '-') {
						result = second-first;
					}
					else if(s == '*') {
						result = second*first;
					}
					else if(s == '/') {
						result = second/first;
					}
					stack.push(String.valueOf(result));
				}
				else if(s != ' ') {
					throw new InvalidNotationFormatException();
				}
			}
			return(Double.parseDouble(stack.pop()));
		}
		catch(StackUnderflowException e) {	
			System.out.println("An error occured: " + e.getMessage());
		}
		catch(StackOverflowException e) {	
			System.out.println("An error occured: " + e.getMessage());
		}
 	    catch(InvalidNotationFormatException e) {
			System.out.println("An error occured153: " + e.getMessage());
		}
		catch(Exception e) {
			System.out.println("An error occured: " + e.getMessage());
		}
		return 0;
	}
	
	private static boolean isOperator(char c) {
		if(c == '+' || c == '-'|| c == '*'|| c == '/') {
			return true;
		}
		return false;
	}
	private static boolean isHigherPrecedence(char operator, char operatorOnStack) {
		if(operator == '*' || operator == '/') {
			if(operatorOnStack == '*' || operatorOnStack == '/') {
				return true;
			}
			else if(operator == '+' || operator == '-') {
				return true;
			}
		}
		return false;
	}

}


