
abstract class Point{
	int x = 1;

	int y = 1;

	void move(int dx, int dy){
		// TODO add implementation
	}

	abstract void alert();

}

abstract class ColoredPoint extends Point{
	int color;

}

class SimplePoint extends Point{
	void alert(){
		// TODO add implementation
	}

}

