package Day_20230329;

import java.util.*;
import java.io.*;


public class Baek_17069 {
	
	static int N; //맵의 크기
	static int map[][]; //맵
	static long dp[][][]; //메모라이징 배열 세번째 배열은 현재 파이프의 방향
	static long ans = 0;
	
	static void solve() {
		
		dp[1][2][0] = 1;
		
		for(int i = 1; i <= N; i++) {
			for(int j = 3; j <= N; j++) {
				if(map[i][j] == 1) continue;
				
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
				
				if(i == 1) continue;
				
				dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
				
				if(map[i-1][j]==1 || map[i][j-1]==1) continue;

                dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
 			}
		}
		
		ans = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		
		System.out.println(ans);
		
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		dp = new long[N+1][N+1][3];
		
		StringTokenizer st;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //map 입력 완료
		
		solve();
		
		// TODO Auto-generated method stub

	}

}
