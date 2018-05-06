package solve;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class P6603 {
	static Stack<Integer> lotto = new Stack();
	static void go(int[] a, int idx, int cnt) {
		if(cnt == 6) {
			for(int i=0; i<6; i++)
				System.out.print(lotto.get(i)+" ");
			System.out.println();
			return;
		}
		
		if(idx == a.length) return;
		
		lotto.push(a[idx]);
		go(a, idx+1, cnt+1);
		lotto.pop();
		go(a, idx+1, cnt);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			int[] a = new int[n];
			
			if(n==0)
				return;
			
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			go(a,0,0);
			System.out.println();
		}
		
	}
}
