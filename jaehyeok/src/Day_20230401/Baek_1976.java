package Day_20230401;


import java.util.*;
import java.io.*;



public class Baek_1976 {
	
	static int N; //도시의 수 == 정점
	static int M; //연결관계 == 간선
	static ArrayList<ArrayList<Edge>> map = new ArrayList<>(); //인접 리스트로 구현
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean visited[];
	
	
	static void solve() {
		
		
		Queue<Integer> que = new LinkedList<>();
		
		que.add(list.get(0)); // 큐에 첫 번째 방문할 지역을 집어 넣는다.
		
		while(!que.isEmpty()) {
			
			int visit = que.poll(); //큐에서 방문할 지역을 꺼낸 후
			visited[visit] = true; //방문 표시를 해준다.
			
			for(Edge e : map.get(visit)) { //방문한 지역과 연결된 길을 꺼내서
				if(e.weight == 0) continue; //길이 없다면 건너뛰며
				if(visited[e.next]) continue; //이미 방문한 지역이라면 건너뛰고
				
				que.add(e.next); //방문하지 않은 지역이라면 큐에 넣어서 다음에 방문하도록 한다.
				
			}
		}
		
		for(int i : list) {
			if(!visited[i]) { //여행계획에 포함된 지역을 방문하지 않았다면
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
		
		
	}
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
		}
		
		StringTokenizer st;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map.get(i).add(new Edge(j, Integer.parseInt(st.nextToken())));
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken())); //여행 계획 정보
		}
		//입력완료
		
		solve();
		
		// TODO Auto-generated method stub

	}

}

class Edge {
	
	int next;
	int weight; //연결정보
	
	public Edge(int next, int weight) {
		this.next = next;
		this.weight = weight;
	}
}
