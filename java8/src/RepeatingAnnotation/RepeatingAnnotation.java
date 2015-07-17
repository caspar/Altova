public class RepeatingAnnotation{
	
	@Author(value = "Caspar")
  	@Author(value = "Altova")
	public void method(){
		//Triggers a parsing error in UM Eclipse plug-in
	}
}