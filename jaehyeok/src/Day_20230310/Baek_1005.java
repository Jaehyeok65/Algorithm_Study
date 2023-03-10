package Day_20230310;

import java.util.*;
import java.io.*;




public class Baek_1005 {
	
	static int N; //건물의 개수
	static int T; //테스트 케이스 개수
	static int K; //규칙의 개수
	static StringBuilder sb = new StringBuilder();
	
	
	static void solve(ArrayList<ArrayList<Integer>> list, int weight[], int time[], int dp[], int target) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>(); //우선순위 큐 선언
		
		for(int i = 1; i <= N; i++) {
			if(weight[i] == 0) { //진입차수가 0인것부터 큐에 집어넣음
				pq.add(new Node(i, weight[i], time[i]));
			}
		}
		
		
		while(!pq.isEmpty()) { //큐가 빌때까지 반복
			
			Node n = pq.poll(); //먼저 지어야할 건물을 꺼내서
			
			for(int i : list.get(n.num)) { //지어야할 건물에 연결된 모든 노드들을 탐색함
				
				weight[i]--; //먼저 지어야할 건물이 사라졌기 때문에 진입차수를 하나씩 감소시키며
				
				dp[i] = Math.max(dp[i], time[i] + n.time); // 가장 마지막에 지어진 이후 건물을 지을 수 있으므로
				if(weight[i] == 0) { //진입차수가 0이라면 == 먼저 지어야할 건물이 없다면
					pq.add(new Node(i, weight[i], dp[i])); //
				}
				
			}
		}
		
		sb.append(dp[target] + "\n");
		
		
	}
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(T --> 0) {
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			K = Integer.parseInt(st.nextToken());
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			
			int time[] = new int[N+1];
			
			int weight[] = new int[N+1];
			
			int dp[] = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i <= N; i++) {
				list.add(new ArrayList<>()); //그래프 메모리 할당
			}
			
			for(int i = 1; i <= N; i++) { //건물을 짓는데 필요한 각 시간을 초기화해줌
				int tmp = Integer.parseInt(st.nextToken());
				time[i] = tmp;
				dp[i] = tmp; //건물을 현재까지 지어야하는 시간으로 초기화해줌
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken()); //먼저 지어야할 건물
				
				int y = Integer.parseInt(st.nextToken()); //나중에 지어야할 건물
				
				list.get(x).add(y); //건물의 선후 관계를 그래프로 지정해주며
				
				weight[y]++; //나중에 지어야할 건물의 진입차수를 증가시킴
			}
			
			int target= Integer.parseInt(br.readLine());
			
			solve(list, weight, time, dp, target);
		}
		
		System.out.print(sb.toString());
		// TODO Auto-generated method stub

	}

}


class Node implements Comparable<Node> {
	
	int degree; // 진입차수
	int num; //건물 번호
	int time; //건물을 짓는데 필요한 시간 == 누적 시간으로 가능
	
	public Node(int num, int degree, int time) {
		this.num = num;
		this.degree = degree;
		this.time = time;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.degree - n.degree;
	}
	
}
