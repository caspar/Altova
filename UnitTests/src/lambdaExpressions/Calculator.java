package lambdaExpressions;

/*
 * @author Oracle Java Tutorials
 * @author Caspar Lant
 */
public class Calculator {

	@FunctionalInterface
	interface IntegerMath{ //functional interface
		int operation(int a, int b); 
	}
	
	public int binaryOperation(int a, int b, IntegerMath op){
		return op.operation(a, b);
	}
	
	public static void main(String... args){
		Calculator calc = new Calculator();
		IntegerMath addition    = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("15 + 3 = " + calc.binaryOperation(15, 3, addition));
		System.out.println("15 - 3 = " + calc.binaryOperation(15, 3, subtraction));
	}
}
