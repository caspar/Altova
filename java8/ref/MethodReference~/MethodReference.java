//@author Caspar Lant

interface IsReferable{
	public void methodReference();
}

public class MethodReference {
	
	public static void commonMethod(){
		
	}
	
	public void implement(){
		
		IsReferable demo = new IsReferable(){
			@Override 
			public void methodReference(){
				MethodReference.commonMethod();
			}
		};
		
		demo.methodReference();
		
		//Lambda implementation
		IsReferable lambda = () -> MethodReference.commonMethod();
		lambda.methodReference();

		//Method reference
		IsReferable reference = MethodReference::commonMethod;
		reference.methodReference();
	}
}
