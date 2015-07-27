
class NewType{
	int num;

	char code;

	NewType(int a, char b){
		// TODO add implementation
	}

}

interface TypeInterface{
}

class Default{
	int val = 2;

	int x = 3;

	int y = 4;

	char code = 'a';

	NewType n = new NewType(val,code);

	TypeInterface i;

	int[] a = new int [3];

	NewType[] nta = new NewType [5];

	float[][] matrix = new float[3][3];

	float[][] triang = new float[100][];

	int[] b = { 0, 1, 2, 3 };

	public Default(){
		// TODO add implementation
	}

	public Default(int val){
		// TODO add implementation
	}

}

