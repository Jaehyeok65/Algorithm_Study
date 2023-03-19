package Day_20230319;

import java.util.*;
import java.io.*;




public class Baek_1806 {
	
	static int N; //수열의 길이
	static int S; //합이 S가 넘어야함
	static int arr[]; //입력받을 수열
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		};
		
		
		int start = 0;
		int end = 0; //한방향으로 이동하기 때문에 포인터를 같이 두며 start <= end이어야함
		
		int sum = 0; //합을 구하기 위한 변수
		while(start <= N && end <= N) { //start가 N보다 커진다면 루프를 멈춘다
			if(sum >= S && result > end - start) result = end - start;
			
			
			if(sum < S) sum += arr[end++];
			else {
				sum -= arr[start++];
			}
		}
		
		
		System.out.println(result == Integer.MAX_VALUE ? "0" : result);
		
		// TODO Auto-generated method stub

	}

}
