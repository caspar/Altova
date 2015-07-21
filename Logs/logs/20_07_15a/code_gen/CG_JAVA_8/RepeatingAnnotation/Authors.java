package annotations;
@Repeatable(Authors.class) @interface Author{
	String value();

}

public @interface Authors{
	Author[] value();

}

