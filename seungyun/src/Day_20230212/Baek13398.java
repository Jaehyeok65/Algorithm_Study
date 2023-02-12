package Day_20230212;

import java.util.Scanner;

public class Baek13398 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int[] L = new int[N];
		L[0] = A[0];
		
		int result = L[0];
		
		for(int i=1; i<N; i++) {
			L[i] = Math.max(A[i], L[i-1] + A[i]);
			result = Math.max(result, L[i]);
		}
		
		int[] R = new int[N];
		R[N-1] = A[N-1];
		for(int i=N-2; i>=0; i--) {
			R[i] = Math.max(A[i], R[i+1]+A[i]);
		}
		
		// 하나를 뻇을 경우 최댓값와 기존값중 최댓값과 비교
		for(int i=1; i<N-1; i++) {
			result = Math.max(result, L[i-1]+R[i+1]);
		}
		System.out.println(result);
	}

}
