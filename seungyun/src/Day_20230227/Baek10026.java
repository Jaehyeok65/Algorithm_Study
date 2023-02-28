package Day_20230227;

import java.util.Scanner;

public class Baek10026 {

	static int n;
	static int[] dx = {0,1,0,-1}; // 우하좌상
	static int[] dy = {1,0,-1,0};
	static Character[][] map;
	static boolean[][] visited;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new Character[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		cnt =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 'R') {
					map[i][j] = 'G';
				}
			}
		}
		
		int ccnt =0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] == false) {
					colordfs(i,j);
					ccnt++;
				}
			}
		}
		System.out.println(cnt +" " + ccnt);

	}
	
	static void dfs(int a, int b) {
		visited[a][b] = true;
		for(int i=0; i<4; i++) {
			int nowX = a + dx[i];
			int nowY = b + dy[i];
			
			if(nowX <0 || nowY <0 || nowX >=n || nowY >=n) {
				continue;
			}
			if(visited[nowX][nowY] == true) {
				continue;
			}
			
			if(map[a][b] == map[nowX][nowY]) {
				dfs(nowX,nowY);
			}
		}
	}
	static void colordfs(int a, int b) {
		visited[a][b] = true;
		for(int i=0; i<4; i++) {
			int nowX = a + dx[i];
			int nowY = b + dy[i];
			
			if(nowX <0 || nowY <0 || nowX >=n || nowY >=n) {
				continue;
			}
			if(visited[nowX][nowY] == true) {
				continue;
			}
			
			if(map[a][b] == map[nowX][nowY]) {
				dfs(nowX,nowY);
			}
		}
	}
}
