package Siver3;

import java.util.Scanner;

//11659 구간 합 구하기 ㄱㄱ
public class Ex11659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N+1];
		int[] sarr = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
			sarr[i] = sarr[i-1] + arr[i];
		}
		int sum=0;
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			sum = sarr[b] - sarr[a-1];
			System.out.println(sum);
		}
		
	}

}
