
public final class Wrapper<T>{
	private final class WrapperComparator<W extends Wrapper<? extends Comparable<T>>> implements Comparator<W>{
		public int compare(W lhs, W rhs){
			// TODO add implementation and return statement
		}

	}

	private final T theObject;

	public Wrapper(T t){
		// TODO add implementation
	}

	public T getWrapper(){
		// TODO add implementation and return statement
	}

	public <U extends T> Wrapper(Wrapper<U> w){
		// TODO add implementation
	}

	public <V extends Wrapper<? extends Comparable<T>>> Comparator<V> comparator(){
		// TODO add implementation
	}

}

