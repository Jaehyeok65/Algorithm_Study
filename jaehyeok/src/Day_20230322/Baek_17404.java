package Day_20230322;


import java.util.*;
import java.io.*;


public class Baek_17404 {
	
	
	static int N;
	static int map[][];
	static int dp[][];
	static final int INF = 1000 * 1000;
	static int result = INF;
	
	
	static void solve() {
		
		for(int k = 1; k <= 3; k++) {
			
			
			for(int j = 1; j <= 3; j++) {
				if(j == k) {
					dp[1][j] = map[1][j];
				}
				else {
					dp[1][j] = INF;
				}
			}
			
			for(int i = 2; i <= N; i++) {
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + map[i][1];
				dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + map[i][2];
				dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][3];
			}
			
			for(int i = 1; i <= 3; i++) {
				if(i != k) result = Math.min(result, dp[N][i]);
			}
		}
		
		System.out.print(result);
	
		
		
		
		
	}
	
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][4]; //1번은 빨강 2번은 초록 3번은 파랑
		
		dp = new int[N+1][4];
		
		StringTokenizer st;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			};
		}; //입력 완료
		
		solve();
		
		
		
		
		// TODO Auto-generated method stub

	}

}