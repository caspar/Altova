import java.lang.reflect.*;
import java.lang.annotation.*;
import java.util.*;

public class RepeatingAnnotation{
	
	@Author(name = "Caspar")
  	@Author(name = "Altova")
	public static void method(){
		//Triggers a parsing error in UM Eclipse plug-in
		//System.out.println(this.getAnnotationsByType(Author.class));
		//System.out.println(this.isAnnotatio);
	}

	public static void main(String[] args){
		RepeatingAnnotation ra = new RepeatingAnnotation();
//		System.out.println(ra.getAnnotations());
		Author[] authors = ra.getAnnotationsByType(Authors.class);
		for (Author author : authors){
			System.out.println("Author=" + author.name());
		}
	}
}