package Day_20230327;

import java.util.*;
public class Baek1747 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int len = 10000001;
		int[] A = new int[len];
		
		for(int i=2; i<len; i++) {
			A[i] = i;
		}
		
		for(int i=2; i<len; i++) {
			if(A[i] == 0) {
				continue;
			}
			
			for(int j= i+i; j<len; j+=i) {
				A[j] = 0;
			}
			
		}
		for(int i=n; i<len; i++) {
			if(A[i] != 0) {
				String str = Integer.toString(A[i]);
				int le = str.length();
				int cnt =0;
				int left = 0;
				int right = le-1;
				while(left < right) {
					if(str.charAt(left) == str.charAt(right)) {
						left += 1;
						right -= 1;
						cnt++;
					} else {
						break;
					}
				}
				if(cnt == le/2) {
					System.out.println(A[i]);
					break;
				}
			}
		}
		
		
	}

}
