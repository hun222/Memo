package samsung;

public class Permutation {
	public static void main(String[] args) {
		int[] a = {6,5,4,3,2,1};
		int n = 6;
		
		next(a,n);
	}
	
	static void next(int[] a, int n) {
		int i = n-1;
		
		while(i>0 && a[i-1] >= a[i]) i--;
		
		if(i==0) {
			System.out.println("END");
			return;
		}
		
		int j = n-1;
		while(j>=i && a[i-1] >= a[j]) j--;
		
		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		
		for(int k=i; k<n-1; k++) {
			for(int z=i; z<n-1; z++) {
				if(a[z+1]<a[z]) {
					int t = a[z+1];
					a[z+1]	=	a[z];
					a[z]	=	t;
				}
			}
		}
		
		for(int k=0; k<n; k++)
			System.out.print(a[k]+" ");
	}
}
