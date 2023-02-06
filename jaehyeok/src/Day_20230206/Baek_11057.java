package Day_20230206;

import java.util.*;
import java.io.*;



public class Baek_11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //수의 길이
		
		//dp 저장 방식 지정  == 2차원 배열을 이용하여 첫 번째 배열에는 자릿수, 두번째 배열에는 1~9를 저장
		int dp[][] = new int[N+1][10];
		
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1; //길이가 1인 숫자들은 모두 1이므로 초기값 초기화해줌
		}
		
		//점화식 세우기 == N의 자릿수에 올 수 있는 수는 전의 자릿수(N-1)에서 J부터 9까지의 합입
		//== 즉 dp[i][j] = dp[i-1][j] + dp[i][j-1];
		for(int i = 1; i <= N; i++) { //배열의 첫 번째 인덱스는 자릿수 == 1부터 N까지
			dp[i][0] = 1; //각 자릿수의 0번째 인덱스는 1이므로
			for(int j = 1; j <= 9; j++) { //배열의 두 번째 인덱스는 0 ~ 9이므로
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007; //각 점화식을 계산할 때 10007을 나눠서 계산함
			}
		}
		
		int result = 0; //결과를 담을 변수
		
		for(int i = 0; i <= 9; i++) { //N번째 자릿수에 올 수 있는 오르막 수의 합을 result 변수에 더함
			result += dp[N][i];
		}
		
		System.out.print(result % 10007); //결과 출력 (주의) 결과도 10007로 나눠서 출력해야함
		
		
		
		// TODO Auto-generated method stub

	}

}