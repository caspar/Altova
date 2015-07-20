
public class EnumAdvanceTest{
	public static void main(String[] args){
		// TODO add implementation
	}

}

class Card{
	public final Suit suit;

	public final CardValue value;

	public Card(Suit s, CardValue v){
		// TODO add implementation
	}

	public String toString(){
		// TODO add implementation and return statement
	}

}

enum Suit{
	CLUBS(Color.BLACK),
	DIAMONDS(Color.RED),
	HEARTS(Color.RED),
	SPADES(Color.BLACK)
	;
	private Color color;

	Suit(Color color){
		// TODO add implementation
	}

	public Color getColor(){
		// TODO add implementation and return statement
	}

}

enum CardValue{
	ACE(1, 1, 11),
	DEUCE(2, 2),
	THREE(3, 3),
	FOUR(4, 4),
	FIVE(5, 5),
	SIX(6, 6),
	SEVEN(7, 7),
	EIGHT(8, 8),
	NINE(9, 9),
	TEN(10, 10),
	JACK(11, 10),
	QUEEN(12, 10),
	KING(13, 10)
	;
	private int order;

	private int value;

	private int otherValue;

	CardValue(int order, int value){
		// TODO add implementation
	}

	CardValue(int order, int value, int otherValue){
		// TODO add implementation
	}

	public int getOrder(){
		// TODO add implementation and return statement
	}

	public int getValue(){
		// TODO add implementation and return statement
	}

	public int getOtherValue(){
		// TODO add implementation and return statement
	}

	public boolean hasOtherValue(){
		// TODO add implementation and return statement
	}

}

