package samsung;

public class BigGong {
	public static void main(String[] args) {
		int val1 = 9;
		int val2 = 18;
		
		int r = 1;
		
		if(val2>val1) {
			int tmp = val2;
			val2 = val1;
			val1 = tmp;
		}
		while(r>0) {
			r = val1%val2;
			val1 = val2;
			val2 = r;
		}
		
		System.out.println(val1);
	}
}
