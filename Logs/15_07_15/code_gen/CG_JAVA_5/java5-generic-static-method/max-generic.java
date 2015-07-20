
interface Comparable<A>{
	int compareTo(A that);

}

final class Byte implements Comparable<Byte>{
	private byte value;

	public Byte(byte value){
		// TODO add implementation
	}

	public byte byteValue(){
		// TODO add implementation and return statement
	}

	public int compareTo(Byte that){
		// TODO add implementation and return statement
	}

}

class Collections{
	public static <A extends Comparable<A>> A max(Collection<A> xs){
		// TODO add implementation and return statement
	}

}

final class Test{
	public static void main(String[] args){
		// TODO add implementation
	}

}

