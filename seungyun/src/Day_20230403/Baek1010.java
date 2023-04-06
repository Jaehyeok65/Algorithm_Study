package Day_20230403;

import java.util.Scanner;

public class Baek1010 {

	static int[][] dp = new int[31][31];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int k=0; k<tc; k++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			System.out.println(combi(m,n));
		}
	}
	static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		else if(n == r || r == 0) {
			return dp[n][r] = 1;
		} else {
			return dp[n][r] = combi(n-1, r-1) + combi(n-1, r);
		}
	}

}
