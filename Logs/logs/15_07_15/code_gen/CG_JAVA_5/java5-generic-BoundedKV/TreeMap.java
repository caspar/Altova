
public class TreeMap<Key extends Comparable<Key>,Data>{
	private static class Entry<K,V>{
		K key;

		V value;

		Entry<K,V> left = null;

		Entry<K,V> right = null;

		Entry<K,V> parent;

	}

	private transient Entry<Key,Data> root = null;

	private Entry<Key,Data> getEntry(Key key){
		// TODO add implementation
	}

	public boolean containsKey(Key key){
		// TODO add implementation and return statement
	}

}

