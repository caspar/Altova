
public class Card implements Comparable, java.io.Serializable{
	public enum Rank{
		deuce,
		three,
		four,
		five,
		six,
		seven,
		eight,
		nine,
		ten,
		jack,
		queen,
		king,
		ace
	}

	public enum Suit{
		clubs,
		diamonds,
		hearts,
		spades
	}

	private final Rank rank;

	private final Suit suit;

	private static List<Card> sortedDeck = new ArrayList<Card>(52);

	private Card(Rank rank, Suit suit){
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

	public int compareTo(Object o){
		// TODO add implementation and return statement
	}

	public static List<Card> newDeck(){
		// TODO add implementation
	}

}

