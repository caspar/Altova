/**
 * @author Oracle Inc.
 * @author Caspar Lant
 */
// public class Calculator extends Machine{
// 	
// 	interface IntegerMath{
// 		int operation(int a, int b);
// 	}
// 	
// 	public int binaryOperation(int a, int b, IntegerMath op){
// 		return op.operation(a, b);
// 	}
// 	
// 	public int addition(int a, int b){
// 		return a + b;
// 	}
// 	
// 	public static void main(String... args){
// 		Calculator calc = new Calculator();
// 		IntegerMath addition    = (a, b) -> a + b;
// 		IntegerMath subtraction = (a, b) -> a - b;
// 		System.out.println("40 + 2 = " + calc.binaryOperation(40, 2, addition));
// 		System.out.println("40 - 2 = " + calc.binaryOperation(40, 2, subtraction));
// 	}
// }
