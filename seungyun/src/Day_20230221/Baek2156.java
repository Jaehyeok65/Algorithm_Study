package Day_20230221;

import java.util.Scanner;

public class Baek2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] po = new int[N+1];
		for(int i=1; i<=N; i++) {
			po[i] = sc.nextInt();
		}
		
		po[0] = 0;
		Integer[] dp = new Integer[N+1];
		dp[0] = 0;
		dp[1] = po[1];
		if(N>1) {
			dp[2] = po[1] + po[2];
		}
		for(int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-1],(Math.max((dp[i-3]+po[i-1]+po[i]), (dp[i-2]+po[i]))));
		}
		
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}

}
