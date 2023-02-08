package Day_20230208;

import java.util.*;
import java.io.*;

public class Baek_10844 {
	
	static final int mod = 1000000000; // 나눔수
	static long result = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //길이를 입력받음 (0 < N <= 100)
		
		if(N == 0 || N > 100) System.exit(1); //올 수 없는 수가 오면 시스템 종료
		
		long dp[][] = new long[N+1][10]; //첫 번째 인덱스는 작거나 같으므로 N+1까지 메모리 할당 두번째 인덱스는 각 자릿수(0~9)
		//주의 == 길이가 100이므로 int형 범위를 초과하기 때문에 long형으로 선언해야함
		dp[1][0] = 0; //0부터는 시작할 수 없으므로
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1; // 1 ~ 9까지는 계단수는 1이므로
		}
		
		for(int i = 2; i <= N; i++) { //i는 루프 주기 == 자릿수가 2 ~ N (max == 100)
			for(int j = 0; j < 10; j++) { //j는 0 ~ 9(계단 수에 각 자릿수가 들어가는 경우의 수를 dp배열에 저장)
				if(j == 0) { //j가 0인 경우는 1밖에 올수 없음(인접한 수가 1밖에 없으므로)
					dp[i][j] = dp[i-1][j+1] % mod;
				}
				else if(j == 9) { //마찬가지로 j가 9인 경우는 8밖에 올 수 없음(인접한 수가 8밖에 없으므로)
					dp[i][j] = dp[i-1][j-1] % mod;
				}
				else { //2 ~ 8까지는 양 옆에 인접한 수가 있음
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] % mod;
				}
			}
		};
		
		for(int i = 0; i < 10; i++) { //길이가 N인 경우의 수를 구해야하므로 0 ~ 9까지 각 경우의 수를 더함
			result += dp[N][i];
		};
		
		System.out.print(result % mod); //나머지 연산을 수행한 후 결과 출력
		
		// TODO Auto-generated method stub

	}

}
