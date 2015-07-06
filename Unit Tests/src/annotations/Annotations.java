package annotations;

import java.lang.annotation.*;
public class Annotations {

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
//		String str = "c.lant@altova.com";
//		String email = (@Email String) str; //type-cast
//		String email = (@Email String) "casparlant@gmail.com";
	}
	
	public static void main(String[] args){
		Annotations an;
		an = new @Constructor Annotations();
		an.repeatingAnnotation();
	}
}
