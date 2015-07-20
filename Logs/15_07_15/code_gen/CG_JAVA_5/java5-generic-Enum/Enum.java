
public abstract class Enum<E extends Enum<E>> implements Comparable<E>, Serializable{
	private final String name;

	private final int ordinal;

	public final String name(){
		// TODO add implementation and return statement
	}

	public final int ordinal(){
		// TODO add implementation and return statement
	}

	protected Enum(String name, int ordinal){
		// TODO add implementation
	}

	public String toString(){
		// TODO add implementation and return statement
	}

	public final boolean equals(Object other){
		// TODO add implementation and return statement
	}

	public final int hashCode(){
		// TODO add implementation and return statement
	}

	protected final Object clone() throws CloneNotSupportedException{
		// TODO add implementation and return statement
	}

	public final int compareTo(E o){
		// TODO add implementation and return statement
	}

	public final Class<E> getDeclaringClass(){
		// TODO add implementation
	}

	public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name){
		// TODO add implementation and return statement
	}

}

