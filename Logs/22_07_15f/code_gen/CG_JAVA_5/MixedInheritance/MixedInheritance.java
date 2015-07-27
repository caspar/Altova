
interface MProvides{
	void func();

}

interface MRequires{
	int getValue();

}

class Mixin implements MProvides{
	private final MRequires parent;

	public Mixin(MRequires parent){
		// TODO add implementation
	}

	public void func(){
		// TODO add implementation
	}

}

class Parent{
	public int val;

	public void P(int value){
		// TODO add implementation
	}

	public int getValue(){
		// TODO add implementation and return statement
	}

}

class Child extends Parent implements MRequires{
	private final MProvides mixin;

	public Child(int value){
		// TODO add implementation
	}

	public void func(){
		// TODO add implementation
	}

}

class newChild extends Parent implements MRequires, MProvides{
	public void func(){
		// TODO add implementation
	}

	public int getValue(){
		// TODO add implementation and return statement
	}

}

class ASSClass{
	Child ch1;

}

