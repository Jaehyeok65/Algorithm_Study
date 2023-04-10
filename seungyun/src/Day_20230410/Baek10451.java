package Day_20230410;

import java.util.*;
public class Baek10451 {
	
	static int n;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=0; i<tc; i++) {
			n = sc.nextInt();
			
			visited = new boolean[n+1];
			arr = new ArrayList[n+1];
			// 초기화
			for(int j=1; j<=n; j++) {
				arr[j] = new ArrayList<>();
			}
			
			for(int j=1; j<=n; j++) {
				int v = sc.nextInt();
				
				arr[j].add(v);
			}
			int cnt = 0;
			for(int j=1; j<=n; j++) {
				if(visited[j] == false) {
					bfs(j);
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i : arr[now]) {
				if(visited[i] == false) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}
