package Day_20230324;

import java.util.Scanner;

// 런타임에러
public class Baek1456 {

	public static void main(String[] args) {
		// 2-> 4 3-> 9 5-> 25 2->8
		
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		long[] A = new long[10000001];
		
		for(int i=2; i<A.length; i++) {
			A[i] = i;
		}
		
		for(int i=2; i<=Math.sqrt(A.length); i++) {
			if(A[i] == 0) {
				continue;
			}
			
			for(int j= i+i; j<b; j+=i) {
				A[j] = 0;
			}
		}
		
		int[] B = new int[(int) (b+1)];
		int cnt =0;
		
		for(int i=2; i<10000001; i++) {
			if(A[i] != 0) {
				long temp = A[i];
				while((double)A[i] <= (double)b/(double)temp) {
					if((double)A[i] >= (double)a/(double)temp) {
						cnt++;
					}
					temp = temp * A[i];
				}
			}
		}
		System.out.println(cnt);
	}

}
