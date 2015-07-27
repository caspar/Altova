
public class Expression{
	int a = 2;

	int b = (a=3) * a;

	int c = geta () / (b=2);

	int d = b + (c - geta());

	int e = a++;

	int f = a--;

	int g = ++a;

	int h = --a;

	int i = +a;

	int l = -a;

	int m = ~a;

	boolean n = true;

	boolean o = !n;

	int p = a % b;

	String q = "going, ";

	String r = q + "gone";

	int s = 12 << 3;

	int t = 123 >> 4 + 122 >>> 3;

	boolean u = (1<3) || (1>3) || (3<=3) || (3>=3);

	boolean v = (a==b) && (e!=f);

	int z = 10 & 12;

	int aa = 10 | 12;

	boolean bb = (a>b)? true : false;

	public int geta(){
		// TODO add implementation and return statement
	}

}

