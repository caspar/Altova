
public class GenericStackTest<T> implements Iterable<T>{
	private class GenericStackTestIterator implements Iterator<T>{
		int index;

		GenericStackTestIterator(){
			// TODO add implementation
		}

		public boolean hasNext(){
			// TODO add implementation and return statement
		}

		public T next(){
			// TODO add implementation and return statement
		}

		public void remove(){
			// TODO add implementation
		}

	}

	protected int MIN_SIZE = 4;

	private T[] data;

	private int top;

	public GenericStackTest(){
		// TODO add implementation
	}

	public T pop(){
		// TODO add implementation and return statement
	}

	public void push(T item){
		// TODO add implementation
	}

	public boolean isEmpty(){
		// TODO add implementation and return statement
	}

	public void dump(){
		// TODO add implementation
	}

	public int capacity(){
		// TODO add implementation and return statement
	}

	public int size(){
		// TODO add implementation and return statement
	}

	public Iterator<T> iterator(){
		// TODO add implementation
	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

