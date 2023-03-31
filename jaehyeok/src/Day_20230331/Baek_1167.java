package Day_20230331;

import java.util.*;
import java.io.*;



public class Baek_1167 {
	
	static int N; //정점의 개수
	
	static ArrayList<ArrayList<Edge>> list = new ArrayList<>();
	
	static boolean visited[];
	
	static int ans = 0;
	
	static int far = 0;
	
	static int max = 0;
	
	
	
	static void solve() { //한 정점에서 가장 먼 정점을 찾은 후 해당 정점에서 가장 먼 정점을 찾으면 됨
		
		visited = new boolean[N+1];
		
		start(1);
		
		visited = new boolean[N+1];
		
		start(far);
		
		System.out.println(max);
		
		
		
	}
	
	
	static void start(int vertex) {
		//한 정점으로 부터 시작
		visited[vertex] = true;
		
		dfs(vertex, 0);
		
	}
	
	static void dfs(int vertex, int dis) { //dis는 현재까지의 거리
		
		if(dis > max) {
			max = dis;
			far = vertex;
		}
		
		for(Edge e : list.get(vertex)) { //해당 정점에서 연결된 간선을 꺼낸다
			
			if(!visited[e.next]) {
				visited[e.next] = true;
				dfs(e.next, dis + e.dis);
			}
			
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int prev = Integer.parseInt(st.nextToken());
			
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				if(next == -1) {
					break;
				}
				else {
					int dis = Integer.parseInt(st.nextToken());
					list.get(prev).add(new Edge(prev,next,dis));
				}
			}
		} //입력완료
		
		solve();
		// TODO Auto-generated method stub

	}

}

class Edge {
	
	int prev;
	int next;
	int dis;
	
	public Edge(int prev, int next, int dis) {
		this.prev = prev;
		this.next = next;
		this.dis = dis;
	}
}
