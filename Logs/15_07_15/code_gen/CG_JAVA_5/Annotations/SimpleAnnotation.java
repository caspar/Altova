
public @Documented @Retention(RetentionPolicy.RUNTIME) @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE}) @interface SimpleAnnotation{
	String value();

}

