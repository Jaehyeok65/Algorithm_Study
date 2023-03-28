package Day_20230328;

import java.util.*;

public class Baek1167 {

	static int n;
	static ArrayList<Node>[] A;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		A = new ArrayList[n+1];
		visited = new boolean[n+1];
		distance = new int[n+1];
		
		//초기화
		for(int i=0; i<=n; i++) {
			A[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<n; i++) {
			int start = sc.nextInt();
			int end = 0;
			int value = 0;
			while(true) {
				end = sc.nextInt();
				if(end == -1) {
					break;
				}
				value = sc.nextInt();
				Node node = new Node(end, value);
				A[start].add(node);
			}
		}
		int max = 1;
		bfs(1);
		for(int i=2; i<=n; i++) {
			if(distance[max] < distance[i]) {
				max = i;
			}
		}
		distance = new int[n+1];
		visited = new boolean[n+1];
		bfs(max);
		Arrays.sort(distance);
		System.out.println(distance[n]);
	}
	
	static void bfs(int a) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) { // q가 비어있지 않다면
			int nowNode = q.poll();
			for(Node i : A[nowNode]) {
				int num = i.num;
				int value = i.val;
				if(visited[num] == false) {
					visited[num] = true;
					q.add(num);
					distance[num] = distance[nowNode] + value;
				}
			}
		}
	}

}

class Node{
	int num;
	int val;
	public Node(int num, int val) {
		this.num = num;
		this.val = val;
	}
}
