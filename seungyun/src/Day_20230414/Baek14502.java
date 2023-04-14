package Day_20230414;

import java.util.*;

// 연구소
public class Baek14502 {

	static int n,m;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		wall(0);
		System.out.println(max);
	}
	
	public static void wall(int wcnt) {
		if(wcnt == 3) {
			bfs();
			return;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					wall(wcnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		int[][] savemap = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				savemap[i][j] = map[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(savemap[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) { // q가 비어있지 않다면
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				
				if(savemap[nextX][nextY] == 0){
					savemap[nextX][nextY] = 2;
					q.add(new int[] {nextX, nextY});
				}
				
			}
		}

		count(savemap);
	}
	public static void count(int[][] savemap) {
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(savemap[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(cnt, max);
		
	}
}
