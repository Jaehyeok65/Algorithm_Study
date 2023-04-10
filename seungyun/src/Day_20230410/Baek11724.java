package Day_20230410;

import java.util.*;
public class Baek11724 {

	static int n,m;
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		// 연결요소의 개수
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			
			arr[v].add(e);
			arr[e].add(v);
		}
		int cnt = 0;
		for(int i=1; i<=n; i++) {
			if(visited[i] == false) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);
		if(visited[a]) {
			return;
		} else {
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

}
