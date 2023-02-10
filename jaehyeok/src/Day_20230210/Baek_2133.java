package Day_20230210;

import java.util.*;
import java.io.*;



public class Baek_2133 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //경우의 수 (1 <= N <= 30)
		
		int dp[] = new int[31]; // N <= 30이므로 31까지 메모리 할당
		
		dp[1] = 0;
		
		dp[2] = 3; // 3 X 2 경우의 수는 3이므로
		
		dp[3] = 0; //홀수라면 타일로 채울 수 있는 경우의 수가 없으므로
		
		for(int i = 4; i <= N; i++) {
			if(i % 2 == 1) { //N이 홀수라면 
				dp[i] = 0; //홀수라면 타일로 채울 수 있는 경우의 수가 없음
			}
			else { //N이 짝수라면 
				dp[i] = dp[i-2] * 3 + 2; //N - 2에서 3가지 경우의 수를 추가할 수 있으므로 [i-2] * 3에 예외 2개를 더해줌
				if(i >= 6) { //N이 6이상일 때, 예외가 늘어남 == 칸이 늘어나므로 예외가 왼쪽, 오른쪽에 올 수 있으므로
					int tmp = 0; //예외 루프를 돌면서 예외 수를 tmp 변수에 담음
					for(int j = 0; j <= i-4; j += 2) { //j는 2씩 증감시켜 if문으로 홀 수 조건 체크를 하지 않음
						tmp += dp[j] * 2; //전전 경우의 수에 예외가 양쪽에 추가되므로 2를 곱하여 예외를 tmp 변수에 추가함.
					}
					dp[i] += tmp; //현재 경우의 수에 루프를 돌면서 추가된 예외 케이스들은 더해줌
				}
			}
		}
		
		System.out.print(dp[N]);
		
		
		// TODO Auto-generated method stub

	}

}
