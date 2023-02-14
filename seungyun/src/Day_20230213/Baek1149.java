package Day_20230213;

import java.util.Scanner;

public class Baek1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] A = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=3; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		dp[0][0] = dp[0][1] = dp[0][2] = dp[0][3] = 0;
		for(int i=1; i<=N; i++) {
			dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + A[i][1];
			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + A[i][2];
			dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + A[i][3];
		}
		
		int result = Math.min(dp[N][3], Math.min(dp[N][1], dp[N][2]));
		
		System.out.println(result);
	}

}
