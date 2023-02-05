package Day_20230202;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Baek1325 {

	static int N,M;
	static ArrayList<Integer>[] map;
	static int[] answer;
	static boolean[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new ArrayList[N+1];
		answer = new int[N+1];
		visit = new boolean[N+1];
		
		for(int i=0; i<=N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt();
			int E = sc.nextInt();
			
			map[S].add(E);
		}
		
		for(int i=1; i<=N; i++) {
			visit = new boolean[N+1];
			bfs(i);
		}
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max, answer[i]);
		}
		
		for(int i=1; i<=N; i++) {
			if(answer[i] == max) {
				System.out.print(i + " ");
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		visit[x] = true; // 방문했으면 +1
		while(!q.isEmpty()) {
			int nowX = q.poll();
			for(int i : map[nowX]) {
				if(!visit[i]) { // 방문 안했으면
					visit[i] = true;
					answer[i]++;
					q.add(i);
				}
			}
		}
	}

}
