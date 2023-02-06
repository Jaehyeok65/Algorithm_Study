package Day_20230206;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek11725 {

	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] visited;
	static int[] answer;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new ArrayList[N+1];
		visited = new boolean[N+1];
		answer = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<N-1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a].add(b);
			map[b].add(a);
		}
		dfs(1);
		
		for(int i=2; i<=N; i++) {
			System.out.println(answer[i]);
		}
	}

	public static void dfs(int node) {
		visited[node] = true;
		for(int i : map[node]) {
			if(visited[i] == false) {
				answer[i] = node;
				dfs(i);
			}
		}
	}
}
