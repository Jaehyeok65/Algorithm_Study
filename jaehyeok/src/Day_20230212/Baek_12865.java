package Day_20230212;

import java.util.*;
import java.io.*;



public class Baek_12865 {
	
	static int N; //물건의 개수
	static int K; //버틸 수 있는 무게
	static int dp[][]; //인덱스는 물품의 개수와 버틸 수 있는 무게
	static int w[]; //무게를 저장할 배열
	static int v[]; //가치를 저장할 배열
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); //입력받기 위한 라이브러리
		//N과 K를 입력받음
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][K+1]; //k가 버틸 수 있는 무게이므로
		
		w = new int[N+1]; //N개의 물품이 있으므로
		
		v = new int[N+1]; //마찬가지로 N개의 물품이 있으므로
		
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			w[i] = Integer.parseInt(st.nextToken());
			
			v[i] = Integer.parseInt(st.nextToken()); //각 배열에 무게와 가치를 저장함
		};
		
		
		for(int i = 1; i <= N; i++) { //i는 각 물품의 번호 == w[i], v[i]를 통해 무게,가치 데이터 참조
			
			for(int j = 1; j <= K; j++) { //k는 배낭에 담을 수 있는 무게이므로 j는 현재 담을 수 있는 무게를 의미
				if(w[i] > j) { // 물품의 무게가 현재 담을 수 있는 무게보다 크다면
					dp[i][j] = dp[i-1][j]; //갱신이 안되었으므로 이전에 담고 있던 값을 그대로 복사
				}
				else { //물품의 무게를 담을 수 있다면
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); //값을 비교해서 더 큰 값을 저장
				}
				
			}
		}
		
		System.out.print(dp[N][K]); //결과 출력
		
		
		// TODO Auto-generated method stub

	}

}
