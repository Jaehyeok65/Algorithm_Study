package Day_20230404;

import java.util.*;

public class Baek1107 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[11];
		for(int i=0; i<10; i++) {
			arr[i] = i;
		}
		for(int i=0; i<m; i++) {
			int num = sc.nextInt();
			arr[num] = -1;
		}
	
		// String 배열를 통한 최솟값 구하기
		int result = Math.abs(n - 100);

		for(int i=0; i<=999999; i++) {
			String str = String.valueOf(i);
			int len = str.length();
			boolean isBreak = false;
			
			for(int j=0; j<len; j++) {
				if(arr[str.charAt(j)-'0'] == -1) { //고장난 버튼이라면
					isBreak = true;
					break;
				}
			}
			
			// 고장난 버튼이 아니라면
			if(!isBreak) {
				int min = Math.abs(n-i) + len;
				result = Math.min(min, result);
			}
		}
		System.out.println(result);
	}

}
