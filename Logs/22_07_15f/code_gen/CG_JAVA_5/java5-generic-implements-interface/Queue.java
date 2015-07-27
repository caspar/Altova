
interface Priority{
	int getPriority();

}

class B implements Priority{
	public int getPriority(){
		// TODO add implementation and return statement
	}

}

public class Queue<E extends B>{
	E[] queue;

}

