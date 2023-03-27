package Day20230327;

import java.util.*;

public class Baek2468 {

	static int n;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1}; //상우하좌
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		
		int max = 0;
		int answer = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				max = Math.max(max, map[i][j]);
			}
		}
		int cnt =0;
		for(int k=0; k<=max; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(map[i][j] <= k) {
						visited[i][j] = true;
					}
				}
			}
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(visited[i][j] == false) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);
			cnt =0;
			visited = new boolean[n][n];
		}
		
		System.out.println(answer);
	}

	static public void dfs(int a, int b) {
		visited[a][b] = true;
		for(int i=0; i<4; i++) {
			int nowX = a + dx[i];
			int nowY = b + dy[i];
			
			if(nowX < 0 || nowY < 0 || nowX >= n || nowY >= n) {
				continue;
			}
			if(visited[nowX][nowY] == true) {
				continue;
			}
			
			dfs(nowX, nowY);
		}
	}
}
