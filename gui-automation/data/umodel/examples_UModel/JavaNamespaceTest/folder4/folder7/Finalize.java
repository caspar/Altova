package folder4.folder7;
class Finalize {
	
	public int attribute = 5;

	public Finalize(int intParam) {
		attribute = intParam;
	}
	
	public void finalize() {
		System.out.println("Finalize method called.");		
	}
}