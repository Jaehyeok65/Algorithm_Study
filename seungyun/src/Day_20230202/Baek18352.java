package Day_20230202;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 특정 거리의 도시 찾기
public class Baek18352 {

	static int N,M,K,X;
	static ArrayList<Integer>[] A;
	static List<Integer> answer;
	static int[] visit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // 도시 개수
		M = sc.nextInt(); // 도로 개수
		K = sc.nextInt(); // 거리정보
		X = sc.nextInt(); // 출발 도시의 번호
		
		A = new ArrayList[N+1];
		answer = new ArrayList<Integer>();
		
		for(int i=1; i<=N; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int S = sc.nextInt(); 
			int E = sc.nextInt();
			
			A[S].add(E);
		}
		visit = new int[N+1];
		
		for(int i=0; i<=N; i++) {
			visit[i] = -1;
		}
		
		bfs(X);
		for(int i=0; i<=N; i++) {
			System.out.println(visit[i]);
		}
		for(int i=0; i<=N; i++) {
			if(visit[i] == K) {
				answer.add(i);
			}
		}
		
		if(answer.isEmpty()) {
			System.out.println("-1");
		}
		else {
			Collections.sort(answer);
			for(int temp:answer) {
				System.out.println(temp);
			}
		}
		
	}

	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x); // 출발노드 더하기
		visit[x]++;
		while(!q.isEmpty()) {
			int nowX = q.poll();  
			for(int i : A[nowX]) {
				System.out.println(i);
				if(visit[i] == -1) {
					visit[i] = visit[nowX] + 1;
//					System.out.print(i);
					q.add(i);
				}
			}
			System.out.println("change" + q.peek());
		}
	}
}
