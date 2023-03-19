package Day_20230319;

import java.util.*;
import java.io.*;



public class Baek_2467 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1]; // 1부터 N까지로 인덱스 설정하기 위해
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		};
		
		int start = 1;
		int end = N; //앞에서부터의 포인터와 뒤에서부터의 포인터 선언
		
		int min = Integer.MAX_VALUE; //두 용액의 0에 가까운 값을 찾기위해 초기에는 가장 첫번째, 마지막 인덱스의 합을 구함
		
		int prev = 0;
		int next = 0; //출력할 값의 prev, next 변수 선언
		
		while(start < end) { //start가 end보다 작다면
			
			
			int sum = arr[start] + arr[end];
			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				prev = arr[start];
				next = arr[end];
			}
			if(sum >= 0) {
				end--;
			}
			else {
				start++;
			}
		}
		
		System.out.print(prev + " " + next);
		
		
		// TODO Auto-generated method stub

	}

}
