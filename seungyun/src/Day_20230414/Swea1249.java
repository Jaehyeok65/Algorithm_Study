package Day_20230414;

import java.util.*;
// 다시풀기
public class Swea1249 {

	static int n;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static int min;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int k=1; k<=tc; k++) {
			n = sc.nextInt();
			
			map = new int[n][n];
			visited = new boolean[n][n];
			min = Integer.MAX_VALUE;
			for(int i=0; i<n; i++) {
				String str = sc.next();
				for(int j=0; j<n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			bfs(0,0,0);
			System.out.println("#" + k + " " + min);
		}
	}

	public static void bfs(int a, int b, int cnt) {
		Queue<int[]> q = new LinkedList<>();
		
		q.add(new int[] {a,b,cnt});
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			int count = now[2];
			int savecnt = count;
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
					continue;
				}
				
				if(visited[nextX][nextY] == false) {
					visited[nextX][nextY] = true;
					count += map[nowX][nowY];
					q.add(new int[] {nextX, nextY, count});
				}
				
				if(nextX == n-1 && nextY == n-1) {
					min = Math.min(min, count);
					continue;
				}
			}
		}
	}
}
