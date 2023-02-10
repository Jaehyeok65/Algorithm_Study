package Day_20230210;

import java.util.Scanner;

public class Baek2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long dp[][] = new long[N+1][2];
		
		
		dp[1][1] = 1;
		dp[1][0] = 0;
		
		for(int i=2; i<=N; i++) {
			// 0은 1이나 0 뒤에 붙어도 상관없음
			dp[i][0] = dp[i-1][1] + dp[i-1][0]; 
			// 1은 0뒤에만 붙을 수 있음
			dp[i][1] = dp[i-1][0];
		}
		
		System.out.println(dp[N][0] + dp[N][1]);
	}

}
