package Day_20230407;

import java.util.Scanner;

public class Baek1451 {

	static long[][] sum;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n+1][m+1];
		
		sum = new long[n+1][m+1];
		long ans = 0;
		
		for(int i=1; i<=n; i++) {
			String str = " " + sc.next();
			for(int j=1; j<=m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (long)map[i][j];
			}
		}
		
		// 세로 3개
		for(int i=1; i<=m-2; i++) {
			for(int j=i+1; j<=m-1; j++) {
				long r1 = sum(1,1,n,i);
				long r2 = sum(1,i+1,n,j);
				long r3 = sum(1,j+1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
			}
		}
		
		// 가로 3개
		for(int i=1; i<=n-2; i++) {
			for(int j=i+1; j<=n-1; j++) {
				long r1 = sum(1,1,i,m);
				long r2 = sum(i+1,1,j,m);
				long r3 = sum(j+1,1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
			}
		}

		// 왼쪽 세로 1개 오른쪽 가로 2개
		for(int i=1; i<=n-1; i++) {
			for(int j=1; j<=m-1; j++) {
				long r1 = sum(1,1,n,j);
				long r2 = sum(1,j+1,i,m);
				long r3 = sum(i+1,j+1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
				r1 = sum(1,1,i,j);
				r2 = sum(i+1,1,n,j);
				r3 = sum(1,j+1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
				 r1 = sum(1,1,i,m);
				 r2 = sum(i+1,1,n,j);
				 r3 = sum(i+1,j+1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
				 r1 = sum(1,1,i,j);
				 r2 = sum(1,j+1,i,m);
				 r3 = sum(i+1,1,n,m);
				if(ans < r1*r2*r3) {
					ans = r1*r2*r3;
				}
			}
		}
		
//		// 왼쪽 가로 2개 오른쪽 세로 1개
//		for(int i=1; i<=n-1; i++) {
//			for(int j=1; j<=m-1; j++) {
//				long r1 = sum(1,1,i,j);
//				long r2 = sum(i+1,1,n,j);
//				long r3 = sum(1,j+1,n,m);
//				if(ans < r1*r2*r3) {
//					ans = r1*r2*r3;
//				}
//			}
//		}
//		
//		// 위에 세로 1개 아래 두개
//		for(int i=1; i<=n-1; i++) {
//			for(int j=1; j<=m-1; j++) {
//				long r1 = sum(1,1,i,m);
//				long r2 = sum(i+1,1,n,j);
//				long r3 = sum(i+1,j+1,n,m);
//				if(ans < r1*r2*r3) {
//					ans = r1*r2*r3;
//				}
//			}
//		}
//		
//		// 위에
//		for(int i=1; i<=n-1; i++) {
//			for(int j=1; j<=m-1; j++) {
//				long r1 = sum(1,1,i,j);
//				long r2 = sum(1,j+1,i,m);
//				long r3 = sum(i+1,1,n,m);
//				if(ans < r1*r2*r3) {
//					ans = r1*r2*r3;
//				}
//			}
//		}
		System.out.println(ans);
	}
	
	public static long sum(int x1, int y1, int x2, int y2) {
		return sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
	}

}
