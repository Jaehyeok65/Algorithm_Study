package Day_20230205;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek1707 {
	
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static int[] check;
	static boolean bool;
	
	//이분 그래프
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int test_case=0; test_case<tc; test_case++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			map = new ArrayList[V+1];
			visit = new boolean[V+1];
			check = new int[V+1];
			bool = true;
			
			for(int i=1; i<=V; i++) {
				map[i] = new ArrayList<Integer>();
			}
			
			for(int e=0; e<E; e++) {
				int S = sc.nextInt();
				int F = sc.nextInt();
				
				map[S].add(F);
				map[F].add(S);
			}
			
			for(int i=1; i<=V; i++) {
				if(bool) {
					dfs(i);
				} else {
					break;
				}
			}
			
			if(bool) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
			
		}
	}
	
	public static void dfs(int x) {
		visit[x] = true;
		
		for(int i : map[x]) {
			if(!visit[i]) {
				check[i] = (check[x]+1) %2;
				dfs(i);
			}
			else if(check[x] == check[i]) {
				bool = false;
			}
		}
	}
}
