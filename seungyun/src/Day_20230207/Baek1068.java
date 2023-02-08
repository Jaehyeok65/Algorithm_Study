package Day_20230207;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek1068 {

	static int N;
	static ArrayList<Integer>[] tree;
	static int answer = 0;
	static int del = 0;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		tree = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		int root = 0;
		for(int i=0; i<N; i++) {
			int p = sc.nextInt();
			if(p == -1) {
				root = i;
			} else {
				tree[i].add(p);
				tree[p].add(i);
			}
		}
		
		del = sc.nextInt();
		if(del == root) {
			System.out.println(0);
		} else {
			dfs(root);
			System.out.println(answer);
		}
		
	}

	public static void dfs(int node) {
		visited[node] = true;
		int cNode = 0;
		for(int i : tree[node]) {
			if(visited[i] == false && i != del) {
				cNode++;
				dfs(i);
			}
		}
		if(cNode == 0) {
			answer++;
		}
		
	}
}
