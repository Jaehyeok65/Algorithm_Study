package Day_20230216;

import java.util.Arrays;
import java.util.Scanner;

//다시풀기 이해못함
public class Baek2110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		
		int[] home = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			home[i] = sc.nextInt();
		}
		Arrays.sort(home); // 정렬
		
		int max = 0;
		int left =1;
		int right = home[N] - home[1]; //최대거리
		int d = 0;
		int ans = 0;
		
		while(left <= right) {
			int mid = (left+right) / 2;
			int start = home[1];
			int count =1; //공유기 설치 gap저장
			
			for(int i=1; i<=N; i++) {
				d = home[i] -start;
				if(d >= mid) {
					count++;
					System.out.print(home[i]);
					start = home[i];
				}
			}
			
			if(count >= C) {
				ans = mid;
				left = mid +1;
			} else {
				right = mid -1;
			}
		}
		System.out.println(ans);
		
		
	}

}
