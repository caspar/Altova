
class BufferEmpty extends Exception{
	BufferEmpty(){
		// TODO add implementation
	}

	BufferEmpty(String s){
		// TODO add implementation
	}

}

class BufferError extends Exception{
	BufferError(){
		// TODO add implementation
	}

	BufferError(String s){
		// TODO add implementation
	}

}

public interface Buffer{
	char get() throws BufferEmpty, BufferError;

}

