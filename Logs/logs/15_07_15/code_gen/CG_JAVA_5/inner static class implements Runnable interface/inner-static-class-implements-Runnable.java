
public class Safelock{
	static class Friend{
		private final String name;

		private final Lock lock = new ReentrantLock();

		public Friend(String name){
			// TODO add implementation
		}

		public String getName(){
			// TODO add implementation and return statement
		}

		public boolean impendingBow(Friend bower){
			// TODO add implementation and return statement
		}

		public void bow(Friend bower){
			// TODO add implementation
		}

		public void bowBack(Friend bower){
			// TODO add implementation
		}

	}

	static class BowLoop implements Runnable{
		private Friend bower;

		private Friend bowee;

		public BowLoop(Friend bower, Friend bowee){
			// TODO add implementation
		}

		public void run(){
			// TODO add implementation
		}

	}

	public static void main(String[] args){
		// TODO add implementation
	}

}

