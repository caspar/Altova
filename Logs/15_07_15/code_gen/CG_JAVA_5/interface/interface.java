
interface Colorable{
	void setColor(byte r, byte g, byte b);

}

class Point{
	int x;

	int y;

}

class ColoredPoint extends Point implements Colorable{
	byte r;

	byte g;

	byte b;

	public void setColor(byte rv, byte gv, byte bv){
		// TODO add implementation
	}

}

class Test{
	static Colorable c;

	public static void main(String[] args){
		// TODO add implementation
	}

}

