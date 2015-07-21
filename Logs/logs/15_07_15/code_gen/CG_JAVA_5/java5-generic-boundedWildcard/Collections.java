
public class Collections{
	public static <T> void copy(List<? super T> dest, List<? extends T> src){
		// TODO add implementation
	}

}

class superLong{
	public static <T> void copy(List<? super T> dest, List<? extends Comparable<? super Long>> src){
		// TODO add implementation
	}

}

class threadState{
	public static <T> void copy(List<? super T> dest, List<? extends Thread.State> src){
		// TODO add implementation
	}

}

