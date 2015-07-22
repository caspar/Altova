
@Repeatable(Authors.class) @interface Author{
	String name() default "Caspar";

}

public @interface Authors{
	Author[] value();

}

