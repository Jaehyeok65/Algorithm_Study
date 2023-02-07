package Day_20230207;


import java.util.*;
import java.io.*;



public class Baek_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[N+1]; //MAX가 90자리 이므로 int 범위 초과 == LONG으로 선언
		
		dp[0] = 0; //0은 올 수 없음
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.print(dp[N]);
		
		
		// TODO Auto-generated method stub

	}

}
