package Day_20230409;


import java.util.*;
import java.io.*;


public class Baek_1377 {
	
	static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		Num A[] = new Num[N+1]; //1부터 N까지 정렬해야 하므로
		
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			A[i] = new Num(num,i);
		}
		
		Arrays.sort(A, 1, N+1);
		
		int result = 0;
		for(int i = 1; i <= N; i++) {
			result = Math.max(result, A[i].index - i);
		};
		
		System.out.println(result + 1);
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}

class Num implements Comparable<Num> { 
	
	int num;
	int index;
	
	public Num(int num, int index) {
		this.num = num;
		this.index = index;
	}
	
	@Override
	public int compareTo(Num n) { //숫자를 기준으로 오름차순으로 정렬
		return num - n.num;
	}
}
