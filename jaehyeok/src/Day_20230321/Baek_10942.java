package Day_20230321;

import java.util.*;
import java.io.*;



public class Baek_10942 {
	
	static int N; 
	static int arr[];
	static int M;
	static int S;
	static int E;
	static StringBuilder sb = new StringBuilder();
	
	
	static boolean solve(int left, int right) {
		while(left <= right) {
			if(arr[left] != arr[right]) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		};
		
		M = Integer.parseInt(br.readLine());
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			
			E = Integer.parseInt(st.nextToken());
			
			if(solve(S,E)) {
				sb.append("1 \n");
			}
			else {
				sb.append("0 \n");
			}
		}
		
		System.out.print(sb.toString());
		
		// TODO Auto-generated method stub

	}

}
