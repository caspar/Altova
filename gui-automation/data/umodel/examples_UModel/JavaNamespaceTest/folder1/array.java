package folder1;
class Test {
	static int[] ia;
	static int[] ib;
	public static void main(String[] args) {
		ia = new int[3];
		ib = new int[6];
		System.out.println(ia.getClass() == ib.getClass());
		System.out.println("ia has length=" + ia.length);
	}
}

