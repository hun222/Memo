package samsung;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	static Queue<Integer> q;
	static int[] d = new int[100001];
	static boolean[] chk = new boolean[100001];
	public static void main(String[] args) {
		int a = 5;
		int b = 17;
		
		q = new LinkedList<>();
		q.add(a);
		bfs(a);
		
		System.out.println(d[17]);
	}
	
	static void bfs(int a) {
		
		while(!q.isEmpty()) {
			int now = q.remove();
			
			if(now-1 >= 0) {
				if(chk[now-1]==false) {
				
					q.add(now-1);
					d[now-1] = d[now]+1;
					chk[now-1] = true;
				}
			}
			if(now*2 <100001) {
				if(chk[now*2]==false) {
				
					q.add(now*2);
					d[now*2] = d[now]+1;
					chk[now*1] = true;
				}
			}
			if(now+1 <100001) {
				if(chk[now+1]==false) {
				
					q.add(now+1);
					d[now+1] = d[now]+1;
					chk[now+1] = true;
				}
			}
		}
	}
}
