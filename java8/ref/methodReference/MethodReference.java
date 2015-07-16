package methodReference;

/*
 * @author Caspar Lant
 */

interface Item{
	public void constructor();
}

public class MethodReference {
	
	public static String staticMethodReference(){
		//static reference
		return "hello";
	}
	
	public MethodReference(){
		//constructor reference
	}
	
	public void instanceMethodReference(){
		
	}
	
	public static void main(String[] args){
//		MethodReference constructorReference = Item::new;
//		Item item = constructorReference.constructor(); 
	}
}
