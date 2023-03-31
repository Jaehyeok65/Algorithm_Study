package Day_20230331;

import java.util.*;

public class Back7576 {

	static int m,n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<int[]> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		q = new LinkedList<>();
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	public static int bfs() {
		int answer = 0;
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >=n || nextY >= m) {
					continue;
				}
				
				if(map[nextX][nextY] == 0) {
					map[nextX][nextY] = map[nowX][nowY] + 1;
					q.add(new int[] {nextX, nextY});
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					return -1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				answer = Math.max(answer, map[i][j]);
			}
		}
		
		
		return answer-1;
		
	}

}
