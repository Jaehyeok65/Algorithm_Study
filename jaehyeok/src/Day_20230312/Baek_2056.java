package Day_20230312;

import java.util.*;

import java.io.*;



public class Baek_2056 {
	
	
	static int N; //수행해야할 작업
	static int time[]; //각 작업에 걸리는 시간
	static int result[]; //각 작업 완료까지 걸린 시간
	static int weight[]; //가중치 배열
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	
	static void solve() {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			result[i] = time[i];
			
			if(weight[i] == 0) {
				pq.add(new Node(i,weight[i]));
			}
		}
		
		while(!pq.isEmpty()) {
			
			Node n = pq.poll();
			
			for(int i : list.get(n.num)) {
				weight[i]--; //진입차수를 감소시킴
				
				result[i] = Math.max(result[i], result[n.num] + time[i]); //선행작업이 모두 완료되어야 작업이 가능하므로
				if(weight[i] == 0) { //진입차수가 감소하여 0이된 노드가 있다면
					pq.add(new Node(i,weight[i])); //큐에 집어넣음
				}
			}
		}
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}
		
		System.out.print(max);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		time = new int[N+1];
		
		result = new int[N+1];
		
		weight = new int[N+1];
		
		int k; //선행 개수
		
		StringTokenizer st; 
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int t = Integer.parseInt(st.nextToken()); //먼저 나오는 수는 걸리는 시간
			
			time[i] = t;
			
			k = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < k; j++) {
				int next = Integer.parseInt(st.nextToken());
				//그래프 간선 연결 (주의 진입차수 진출차수 구분을 명확히해야함 == 다음에 나온 작업이 끝나야 작업이 가능하므로 next에서 i를 연결시켜줌)
				list.get(next).add(i); 
				weight[i]++; //진입차수를 1증가시킴
			}
		}
		
		solve();
		
		// TODO Auto-generated method stub

	}

}

class Node implements Comparable<Node> {
	
	int degree; // 진입차수
	int num; //건물 번호
	
	public Node(int num, int degree) {
		this.num = num;
		this.degree = degree;
	}
	
	@Override
	public int compareTo(Node n) {
		return this.degree - n.degree;
	}
	
}
