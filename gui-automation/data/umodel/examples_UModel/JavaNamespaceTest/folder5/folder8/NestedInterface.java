package folder5.folder8;
// outer interface
interface OuterInterface{
	
	int integer = 0;
	
	void printSomething(String something);
	
	String getClassName();
	
	int getIntegerAttribute();
	
	// nested interfaces
	interface NestedInterface {
		// blah
	}

	// nested classes
	static class AStaticNestedClass {
		// blah
    }

    class InnerClass {
        // blah
    }

	
}