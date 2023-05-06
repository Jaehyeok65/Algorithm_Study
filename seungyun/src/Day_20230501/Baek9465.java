package Day_20230501;

import java.util.*;
public class Baek9465 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0; tc<test_case; tc++) {
			int n = sc.nextInt();
			
			int[][] A = new int[3][n+1];
			int[][] dp = new int[3][n+1];
			
			for(int i=1; i<=2; i++) {
				for(int j=1; j<=n; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			
			dp[1][1] = A[1][1];
			dp[2][1] = A[2][1];
			
			int max = 0;
			for(int i=1; i<=2; i++) {
				for(int j=2; j<=n; j++) {
					dp[1][j] = Math.max(dp[2][j-1], dp[2][j-2]) + A[1][j];
					dp[2][j] = Math.max(dp[1][j-1], dp[1][j-2]) + A[2][j];
					max = Math.max(dp[1][j], dp[2][j]);
				}
			}
			
			sb.append(max + "\n");
		}
		System.out.println(sb);
	}

}
