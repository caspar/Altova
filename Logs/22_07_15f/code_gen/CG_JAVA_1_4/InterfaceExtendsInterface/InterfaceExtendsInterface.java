
interface InterfaceA{
	int integer = 0;

	void printSomething();

	String getClassName();

	int getIntegerAttribute();

}

interface InterfaceB extends InterfaceA{
	int attribute = 0;

	Integer returnAttAsInteger();

}

