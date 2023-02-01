package Day_20230201;

import java.util.*;
import java.io.*;


public class Back_2606 {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean visited[];
	static int result = 0;
	
	
	public static void solve(int i) {
		visited[i] = true;
		
		for(int j : list.get(i)) {
			if(!visited[j]) {
				solve(j);
			}
		}
	}
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		visited = new boolean[N+1]; //방문 체크
		
		for(int i = 1; i <= N + 1; i++) {
			list.add(new ArrayList<>());
		};
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list.get(prev).add(next);
			list.get(next).add(prev);
		}; //간선 추가
		
		solve(1);
		
		for(int i = 2; i <= N; i++) {
			if(visited[i]) {
				result++;
			}
		}
		
		System.out.print(result);
		
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}