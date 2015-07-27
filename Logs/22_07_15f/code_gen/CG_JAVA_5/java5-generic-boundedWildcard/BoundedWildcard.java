
class TwoD{
	int x;

	int y;

	TwoD(int a, int b){
		// TODO add implementation
	}

}

class ThreeD extends TwoD{
	int z;

	ThreeD(int a, int b, int c){
		// TODO add implementation
	}

}

class FourD extends ThreeD{
	int t;

	FourD(int a, int b, int c, int d){
		// TODO add implementation
	}

}

class Coords<T extends TwoD>{
	T[] coords;

	Coords(T[] o){
		// TODO add implementation
	}

}

public class BoundedWildcard{
	static void showXY(Coords<?> c){
		// TODO add implementation
	}

	static void showXYZ(Coords<? extends ThreeD> c){
		// TODO add implementation
	}

	static void showAll(Coords<? extends FourD> c){
		// TODO add implementation
	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

