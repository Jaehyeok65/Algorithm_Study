package Day_20230428;

import java.util.*;
// 다시풀기
public class Baek1916 {

	static int n,m;
	static ArrayList<Node>[] arr;
	static int start, end;
	static int min;
	static int[] dist; // 시작점에서 각 정점으로 가는 최단거리
	static boolean[] check; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new ArrayList[n+1];
		dist = new int[n+1];
		check = new boolean[n+1];
		//초기화
		for(int i=0; i<=n; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<n; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<m; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int v = sc.nextInt();
			
			arr[s].add(new Node(e,v));
		}
		
		start = sc.nextInt();
		end = sc.nextInt();
		min = 1000001;
		int d = dfs(start, end);
		System.out.println(d);
	}
	
	public static int dfs(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[n+1];
		pq.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.num;
			
			if(check[cur] == false) {
				check[cur] = true;
				
				for(Node node : arr[cur]) {
					if(!check[node.num] && dist[node.num] > dist[cur] + node.value) {
						dist[node.num] = dist[cur] + node.value;
						pq.add(new Node(node.num, dist[node.num]));
					}
				}
			}
		}
		return dist[end];
	}
}

class Node implements Comparable<Node>{
	int num;
	int value;
	
	public Node(int num, int value) {
		this.num = num;
		this.value = value;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
		// 음수면 o가 큰거 양수면 o가 작은거 0이면 o랑 같은거
	}
}
