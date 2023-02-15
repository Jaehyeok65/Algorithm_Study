package Day_20230215;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Baek2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] A = new int[N];
		int max = 0;
		int min = 0;
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
			max = Math.max(max, A[i]);
		}
		
		while(min < max) {
			int mid = (min+max) /2;
			long sum = 0;
			for(int a : A) {
				if(a - mid >0) {
					sum+= (a-mid);
				}
			}
			if(sum >= M) {
				min = mid+1;
			} else{
				max = mid;
			} 
			
		}
		System.out.println(min-1);
		
	}

}
