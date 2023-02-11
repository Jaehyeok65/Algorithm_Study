package Day_20230211;

import java.util.*;
import java.io.*;



public class Baek_11660 {
	
	
	
	static int solve(int x1, int y1, int x2, int y2, int [][] map, int [][] dp) { //풀이
		
		if(x1 == x2 && y1 == y2) { //좌표가 같으면 해당 블록만 리턴하면 된다.
			return map[x1][y1];
		}
		
		int result = 0; //결과를 리턴할 변수 초기화
		
		for(int i = x1; i <= x2; i++) { //x1부터 x2까지의 행의 누적합 구하기
			result += (dp[i][y2] - dp[i][y1-1]); //i가 행 변수이므로 i를 행 인덱스에다가 대입하며, y1, y2 범위에 들어간 값만 계산해야하므로
		}
		
		return result;
		
		
		
		
	}

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입출력을 한번에 수행하기 위해
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		// N과 M을 입력받기 위해 
		st = new StringTokenizer(br.readLine());
		// N을 입력받음
		int N = Integer.parseInt(st.nextToken());
		// M을 입력받음
		int M = Integer.parseInt(st.nextToken());
		// 편의상 1 ~ N까지 인덱스로 접근하기 위해 N+1까지 메모리 할당
		int map[][] = new int[N+1][N+1];
		int dp[][] = new int[N+1][N+1]; //행별로 누적합을 저장함.
		// map 초기화
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = dp[i][j-1] + map[i][j]; //입력받음과 동시에 행 별 누적합을 저장함.
			}
		};
		// M개의 입력 테스트케이스를 받음 == 순서 x1, y1 , x2, y2
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()); 
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result = solve(x1,y1,x2,y2, map, dp); //입력받은 값을 전달하여 solve 메소드 수행
			sb.append(result+"\n");
		}
		
		System.out.print(sb.toString()); //결과 출력
		
		// TODO Auto-generated method stub

	}

}
