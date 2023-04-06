package Day_20230406;


import java.util.*;
import java.io.*;


public class Baek_1937 {
	static int N;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static long dp[][];
	static int map[][];
	static long ans = 0;
	
	
	static void solve() {
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				ans = Math.max(ans,dfs(i,j));
			}
		}
		
		System.out.print(ans);
		
	}
	
	static long dfs(int y, int x) {
		
		if(dp[y][x] != 0) {
			return dp[y][x];
		}
		
		dp[y][x] = 1;
		
		for(int i = 0; i < 4; i++) { //방문한 지역으로부터 상하좌우 탐색
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			
			if(nextY < 1 || nextX < 1 || nextY > N || nextX > N) continue;
			
			if(map[nextY][nextX] > map[y][x]) {
				dp[y][x] = Math.max(dp[y][x], dfs(nextY,nextX) + 1);
				dfs(nextY,nextX);
			}
		}
		
		return dp[y][x];
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		dp = new long[N+1][N+1];
		StringTokenizer st;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력완료
		
		solve();
		
		// TODO Auto-generated method stub

	}

}