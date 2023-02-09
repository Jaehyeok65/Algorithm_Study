package Day_20230209;

import java.util.*;
import java.io.*;



public class Baek_1904 {
	static final int mod = 15746; //나눔수

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[N+1]; //메모제이션할 배열을 만듬
		
		if(N == 1) {
			System.out.print(1);
			System.exit(0);
		}
		else if(N == 2) { //N이 1일 때와 2일 때 예외처리를 해주지 않으면 밑에 dp[1], dp[2]에 접근할 때 ArrayIndexofBounds 에러 발생
			System.out.print(2);
			System.exit(0);
		}
		
		dp[1] = 1; // N이 1일 때 예외처리를 해주지 않으면 dp = new int[2]가 되며
		dp[2] = 2; // 즉 dp[2] = 2가 되는데 배열의 길이가 2이므로 에러가 발생하는 것.
		
		//점화식 찾기 == 1과 00을 붙여서 길이가 N인 수를 만들면 되므로 이전 길이(N-1)에 1을 붙이며, 전전 길이(N-2)에 00을 붙이면 됨
		//즉 점화식 == dp[i-2] + dp[i-1]
		for(int i = 3; i <= N; i++) { //4까지 메모제이션을 했으므로 5부터 N까지 배열 반복
			dp[i] = dp[i-2] + dp[i-1]; //모든 가짓수를 더해 메모제이션 배열에 저장함
			dp[i] %= mod;
		}
		
		System.out.println(dp[N]); //출력 형태에 맞게 mod를 나눈 나머지를 출력함
		
		// TODO Auto-generated method stub

	}

}
