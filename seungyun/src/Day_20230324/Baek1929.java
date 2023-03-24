package Day_20230324;

import java.util.Scanner;

public class Baek1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int[] A = new int[b+1];
		
		for(int i=2; i<=b; i++) {
			A[i] = i;
		}
		
		for(int i=2; i<=b; i++) {
			if(A[i] == 0) {
				continue;
			}
			for(int j = i+i; j<=b; j+=i) {
				A[j] = 0;
			}
		}
		
		for(int i=a; i<=b; i++) {
			if(A[i] != 0) {
				System.out.println(i);
			}
		}
	}

}
