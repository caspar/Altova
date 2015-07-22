
@Target(METHOD) @Retention(RUNTIME) @Repeatable(Schedules.class) @interface Schedule{
	String second() default "0";

	String minute() default "0";

	String hour() default "0";

	String dayOfMonth() default "*";

	String month() default "*";

	String dayOfWeek() default "*";

	String year() default "*";

	String timezone() default "";

	String info() default "";

	boolean persistent() default true;

}

public @Target(METHOD) @Retention(RUNTIME) @interface Schedules{
	Schedule[] value();

}

