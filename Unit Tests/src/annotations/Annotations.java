package annotations;

public class Annotations {

	//Type Annotation
	@Email String email = "caspar.lant@altova.com";
	
	@Deprecated
	public void deprecatedMethod(){
		//One annotation, no parsing error
	}
	
	@Author(value = "Caspar")
	//@Author(value = "Altova")
	public void repeatingAnnotation(){
		//Triggers a parsing error in UM Eclipse plugin
	}
	
	public void typeAnnotation(){
		String str = "caspar@nyu.edu";
		@SuppressWarnings("unused")
		String email = (@Email String) str; //type-cast
	}
	
	public static void main(String[] args){
		Annotations an;
		an = new /*@Constructor*/ Annotations();
		an.repeatingAnnotation();
	}
}
