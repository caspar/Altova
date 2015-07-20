
public class TypesafeEnum{
	public enum Rank{
		DEUCE,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	}

	public enum Suit{
		CLUBS,
		DIAMONDS,
		HEARTS,
		SPADES
	}

	private final Rank rank;

	private final Suit suit;

	private static final List<TypesafeEnum> protoDeck = new ArrayList<TypesafeEnum>();

	private TypesafeEnum(Rank rank, Suit suit){
		// TODO add implementation
	}

	public Rank rank(){
		// TODO add implementation and return statement
	}

	public Suit suit(){
		// TODO add implementation and return statement
	}

	public String toString(){
		// TODO add implementation and return statement
	}

	public static ArrayList<TypesafeEnum> newDeck(){
		// TODO add implementation
	}

}

