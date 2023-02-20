package Day_20230220;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek1753 {

	public static int V,E,start;
	public static ArrayList<Edge> list[];
	public static int[] distance;
	public static boolean[] visited;
	public static PriorityQueue<Edge> q = new PriorityQueue<Edge>(); //우선순위 큐
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		V = sc.nextInt();
		E = sc.nextInt();
		
		start = sc.nextInt();
		
		list = new ArrayList[V+1];
		visited = new boolean[V+1];
		distance = new int[V+1];
		
		for(int i=1; i<=V; i++) {
			list[i] = new ArrayList<Edge>();
		}
		for(int i=0; i<=V; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();
			
			list[u].add(new Edge(v,w));
		}
		
		q.add(new Edge(start,0));
		distance[start] = 0;
		
		while(!q.isEmpty()) {
			Edge current = q.poll();
			int c_v = current.vertex;
			
			if(visited[c_v]) {
				continue;
			}
			
			visited[c_v] = true;
			
			for(int i=0; i<list[c_v].size(); i++) {
				Edge tmp = list[c_v].get(i);
				int next = tmp.vertex;
				int value = tmp.value;
				
				if(distance[next] > distance[c_v] + value) {
					distance[next] = value + distance[c_v];
					q.add(new Edge(next, distance[next]));
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
		
	}
	
}
class Edge implements Comparable<Edge>{
	int vertex, value; // 정점, 가중치
	Edge(int vertex, int value){
		this.vertex = vertex;
		this.value = value;
	}
	public int compareTo(Edge e) {
		if(this.value > e.value) {
			return 1;
		} else {
			return -1;
		}
	}
}
