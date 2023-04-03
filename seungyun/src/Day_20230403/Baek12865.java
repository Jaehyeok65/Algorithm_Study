package Day_20230403;

import java.util.*;
public class Baek12865 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[n+1][k+1];
		
		int[] w = new int[n+1];
		int[] v = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			w[i] = sc.nextInt();
			v[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - w[i] >= 0) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
