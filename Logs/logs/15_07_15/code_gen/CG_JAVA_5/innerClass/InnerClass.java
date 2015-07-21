
class HasStatic{
	static int j = 100;

}

class Outer{
	class Inner extends HasStatic{
		int x = 3;

		int y = 4;

	}

	static class NestedButNotInner{
		static int z = 5;

	}

	interface NeverInner{
	}

}

