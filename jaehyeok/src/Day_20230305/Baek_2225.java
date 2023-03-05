package Day_20230305;


import java.util.*;
import java.io.*;
	


public class Baek_2225 {
	
	static int N;
	static int K;
	static final int mod = 1000000000;
	
	static void solve() { //문제 해결 메소드
		
		int dp[][] = new int[N+1][K+1]; //N은 구해야하는 수 , K는 더해야하는 수
		
		for(int i = 1; i <= N; i++) {
			dp[i][1] = 1; //K가 1인 경우 자기 자신만이 올 수 있으므로 1로 초기화해줌
		};
		
		for(int i = 1; i <= K; i++) {
			dp[1][i] = i; //N이 1인 경우 나머지 자리수는 0이 채우므로
		};
		
		for(int i = 2; i <= N; i++) {
			for(int j = 2; j <= K; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod;
			};
		};
		
		System.out.print(dp[N][K]);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		solve();
		// TODO Auto-generated method stub

	}

}
