package Day_20230425;

import java.util.*;
public class Baek14500 {

	static int n,m;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		int max = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		System.out.println(max);
		String str = "eeeddee";
	
	}
	
	public static void bfs(int a, int b) {
		
	}
}
