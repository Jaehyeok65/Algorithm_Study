package Day_20230317;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek13032 {

		static int n,m;
		static ArrayList<Integer>[] map;
		static boolean[] visited;
	    static boolean arrive;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); // 사람수
		m = sc.nextInt(); // 관계수
		
		map = new ArrayList[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			map[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			map[a].add(b);
			map[b].add(a);
		}
		
		int count;
		for(int i=0; i<n; i++) {
			count = 1;
			dfs(i,count);
			if(arrive) {
				break;
			}
		}
		if(arrive) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
	
	public static void dfs(int index, int cnt) {
		if(cnt == 5) {
			arrive = true;
			return;
		}
		visited[index] = true;
		
		for(int i=0; i<map[index].size(); i++) {
			int value = map[index].get(i);
			if(visited[value] == false) {
				dfs(value, cnt+1);
			}
		}
		visited[index] = false;
	}

}
