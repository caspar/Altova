
@Retention(RetentionPolicy.RUNTIME) @interface MyAnno{
	String str();

	int val();

}

@Retention(RetentionPolicy.RUNTIME) @interface What{
	String description();

}

public @What(description = "An annotation test class") @MyAnno(str = "Meta2", val = 99) class Meta2{
	public static @What(description = "An annotation test method") @MyAnno(str = "Testing", val = 100) void myMeth(){
		// TODO add implementation
	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

