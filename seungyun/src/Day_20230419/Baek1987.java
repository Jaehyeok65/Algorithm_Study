package Day_20230419;
// bfs

import java.util.*;
public class Baek1987 {

	static int r,c;
	static char[][] map;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static boolean[] visited;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		map = new char[r][c];
		visited = new boolean[26];
		for(int i=0; i<r; i++) {
			String str = sc.next();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited[map[0][0]-65] = true;
		
		System.out.println(dfs(0,0,1));
	}
	
	public static int dfs(int a, int b, int cnt) {
		for(int i=0; i<4; i++) {
			int nextX = a + dx[i];
			int nextY = b + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
				continue;
			}
			
			int k = map[nextX][nextY] - 65;
			if(visited[k] == false) {
				visited[k] = true;
				dfs(nextX,nextY, cnt+1);
				visited[k] = false;
			}
		}
		
		answer = Math.max(answer, cnt);
		return answer;
	}

}
