package methodReference;

//@author Caspar Lant

interface IsReferable{
	public void referenceDemo();
}

public class ReferenceDemo {
	
	public static void commonMethod(){
		
	}
	
	public void implement(){
		
		IsReferable demo = new IsReferable(){
			@Override 
			public void referenceDemo(){
				ReferenceDemo.commonMethod();
			}
		};
		
		demo.referenceDemo();
		
		//Lambda implementation
		IsReferable lambda = () -> ReferenceDemo.commonMethod();
		lambda.referenceDemo();

		//Method reference
		IsReferable reference = ReferenceDemo::commonMethod;
		reference.referenceDemo();
	}
}
