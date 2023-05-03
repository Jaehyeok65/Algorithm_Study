package Day_20230502;

import java.util.*;
public class Baek14888 {

	static int n;
	static int[] narr;
	static char[] carr;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		narr = new int[n];
		visited = new boolean[n-1];
		
		for(int i=0; i<n; i++) {
			int num = sc.nextInt();
			narr[i] = num;
		}
		String str = "";
		for(int i=0; i<4; i++) {
			int sa = sc.nextInt();
			if(i==0) {
				for(int j=0; j<sa; j++) {
					str += '+';
				}
			} else if(i==1) {
				for(int j=0; j<sa; j++) {
					str += '-';
				}
			} else if(i==2) {
				for(int j=0; j<sa; j++) {
					str += '*';
				}
			} else if(i==3) {
				for(int j=0; j<sa; j++) {
					str += '/';
				}
			}
		}
		carr = str.toCharArray();
		
		dfs(1,narr[0]);
		System.out.println(max);
		System.out.println(min);
	}
	 public static void dfs(int start, int sum) {
		 if(start == n) {
			 max = Math.max(max, sum);
			 min = Math.min(min, sum);
			 return;
		 }
		 for(int i=0; i<n-1; i++) {
			 if(!visited[i]) {
				 visited[i] = true;
				 dfs(start+1, cal(sum, narr[start], carr[i]));
				 visited[i] = false;
			 }
		 }
	 }
	 public static int cal(int a, int b, char c) {
		if(c == '+') {
			return a+b;
		} else if(c == '-') {
			return a-b;
		} else if(c == '*') {
			return a*b;
		} else if(c == '/') {
			if(a<0) {
				a *= -1;
				int result = a/b;
				result *= -1;
				return result;
				
			} 
//			else if(a == 0) {
//				return -1;
//			}
			return a/b;
		}
		return -1;
	 }
}
