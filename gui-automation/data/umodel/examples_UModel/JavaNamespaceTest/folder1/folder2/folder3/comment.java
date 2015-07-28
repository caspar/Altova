package folder1.folder2.folder3;
/*Multiline Comment
		Line2
		Line3
		for class Test
*/

class Test2 {
	//Single Line Comment for method main
	
	public static void main(String[] args) {
	/*Multiline Comment
		Line2
		Line3
		before method body
	*/
		for (int i = 0; i < args.length; i++)
			System.out.print(i == 0 ? args[i] : " " + args[i]);
		System.out.println();
	}
}
