
interface CombinedComparable<T> extends Comparable<String>{
	int compareTo(T other);

}

public class ObjectStore<T extends CombinedComparable<T>>{
	private void h(T t){
		// TODO add implementation
	}

}

