package Annotations;
public class ReflectionTester{
	public ReflectionTester(){
		// TODO add implementation
	}

	public void testAnnotationPresent(PrintStream out) throws IOException{
		// TODO add implementation
	}

	public void testInheritedAnnotation(PrintStream out) throws IOException{
		// TODO add implementation
	}

	public void testGetAnnotation(PrintStream out) throws IOException, NoSuchMethodException{
		// TODO add implementation
	}

	public void printAnnotations(AnnotatedElement e, PrintStream out) throws IOException{
		// TODO add implementation
	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

class Sub extends Super{
	public void print(PrintStream out) throws IOException{
		// TODO add implementation
	}

}

@InProgress class Super{
	public void print(PrintStream out) throws IOException{
		// TODO add implementation
	}

}

@Documented @Retention(RetentionPolicy.RUNTIME) @interface GroupTODO{
	public enum Severity{
		CRITICAL,
		IMPORTANT,
		TRIVIAL,
		DOCUMENTATION
	}

	Severity severity() default Severity.IMPORTANT;

	String item();

	String assignedTo();

	String dateAssigned();

}

@Documented @Retention(RetentionPolicy.RUNTIME) @Inherited @interface InProgress{
}

