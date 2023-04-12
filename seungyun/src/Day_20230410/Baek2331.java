package Day_20230410;

import java.util.*;
public class Baek2331 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int P = sc.nextInt();
		int[] visited = new int[10000];
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(A);
		String num = String.valueOf(A);
		while(true) {
			int sum = 0;
			for(int i=0; i<num.length(); i++) {
				sum += Math.pow((num.charAt(i) - '0'),P);
			}
			
			if(arr.contains(sum)) {
				int index = arr.indexOf(sum);
				System.out.println(index);
				break;
			}
			num = String.valueOf(sum);
			arr.add(sum);
		}
		
	}

}
