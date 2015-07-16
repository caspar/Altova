package methodReference;
import java.util.Arrays;

public class Thing {
	//Must simplistically illustrate method reference
	
	public static void main(String... args){
		String[] words = {"bb", "aaa", "c"};
		Arrays.sort(words, (s1, s2) -> s1.length() - s2.length()); //sorts arrays based on length
		System.out.println(Arrays.toString(words));
	}

}
