
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME) @interface debug{
	boolean devbuild() default false;

	int counter();

}

public class MetaTest{
	final boolean production = true;

	public @debug(devbuild=production,counter=1) void testMethod(){
		// TODO add implementation
	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

