import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.*;

public class TypeAnnotation{
	//Type-Annotation:
	@Email String email = "caspar@nyu.edu";
	
	//Type-Casting:
	String str = "caspar.lant@altova.com";
	String email2 = (@Email String) str;
	
	public static void main(String[] args){
		System.out.println(getAnnotationsByType());
	}
}