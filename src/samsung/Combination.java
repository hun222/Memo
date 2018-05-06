package samsung;

import java.util.Stack;

public class Combination {
	static Stack<Integer> st;
	static int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	public static void main(String[] args) {
		st = new Stack();
		doCombination(arr.length,10,0);
	}
	
	static void show(){
		for(int i=0; i<st.size(); i++)
			System.out.print(st.get(i)+" ");
		System.out.println();
	}
	
	static void doCombination(int n, int r, int idx) {
		if(r==0) {
			show();
			return;
		}else if(n==r) {
			for(int i=0; i<n; i++)st.add(arr[i+idx]);
			show();
			for(int i=0; i<n; i++)st.pop();
		}else {
			st.add(arr[idx]);
			doCombination(n-1, r-1, idx+1);
			
			st.pop();
			doCombination(n-1, r, idx+1);
		}
	}
}
