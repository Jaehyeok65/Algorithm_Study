package Day_20230317;

import java.util.*;
import java.io.*;


public class Baek_2611 {
	
	static int N; //지점 N == 노드의 개수
	static int M; //간선 개수
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	static int weight[];
	static int dp[];
	static int parant[];
	
	
	static void solve() {
		
		Queue<Integer> que = new LinkedList<>();
		
		que.add(1); //1번 노드부터 시작하므로 1번을 큐에다가 추가함
		
		while(!que.isEmpty()) {
			
			int n = que.poll();
			
			if(n == 1 && weight[n] == 0) break;
			
			for(Edge e : list.get(n)) { //큐에서 꺼낸 노드와 연결된 간선들을 꺼내 e에 저장한다.
				
				weight[e.next]--; //간선을 꺼냈으므로 도착 노드의 진입차수를 감소시키고
				
				if(dp[e.next] < dp[n] + e.score) {
					dp[e.next] = dp[n] + e.score;
					parant[e.next] = n;
				}
				
				if(weight[e.next] == 0) { //진입차수를 감소시켜서 0이 된다면
					que.add(e.next);
				}
				
			}
		}
		
		System.out.println(dp[1]);
		
		print(parant[1],1);
		
		System.out.print(1);
		
		
	}
	
	static void print(int x, int s) {
		if(x == s) {
			System.out.print(x + " ");
			return;
		}
		print(parant[x], s);
		System.out.print(x + " ");
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st; 
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		weight = new int[N+1];
		
		dp = new int[N+1];
		
		parant = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int p = Integer.parseInt(st.nextToken()); //시작 노드
			
			int q = Integer.parseInt(st.nextToken()); //도착 노드
			
			int r = Integer.parseInt(st.nextToken()); //점수 == 가중치
			
			list.get(p).add(new Edge(p,q,r)); //리스트의 간선에 도착 노드 정보와 점수를 담아서 추가함
			
			weight[q]++; //도착노드의 진입차수를 증가시킴
		}
		
		solve();
		
		
		// TODO Auto-generated method stub

	}

}


class Edge {
	
	int prev; //이전 노드의 번호
	int next; //도착 노드번호 정보
	int score; //점수 == 가중치
	
	public Edge(int prev, int next, int score) {
		this.prev = prev;
		this.next = next;
		this.score = score;
	}
}
