
public class Apply{
	public static <T,S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args){
		// TODO add implementation
	}

}

class Shape{
	public void rotate(){
		// TODO add implementation
	}

	public void resize(int newSize){
		// TODO add implementation
	}

}

class Square extends Shape{
}

class FilledList<T> extends ArrayList<T>{
	public FilledList(Class<? extends T> klass, int size){
		// TODO add implementation
	}

}

class SimpleQueue<T> implements Iterable<T>{
	private LinkedList<T> storage = new LinkedList<T>();

	public void add(T t){
		// TODO add implementation
	}

	public T get(){
		// TODO add implementation and return statement
	}

	public Iterator<T> iterator(){
		// TODO add implementation
	}

}

class ApplyTest{
	List<Shape> shapes = new ArrayList<Shape>();

	List<Square> squares = new ArrayList<Square>();

	SimpleQueue<Shape> shapeQueue = new SimpleQueue<Shape>();

}

class Generics{
	static List<List<? extends Shape>> history = new ArrayList<List <? extends Shape>>();

	void drawShapeList(List<? extends Shape> shapes){
		// TODO add implementation
	}

}

