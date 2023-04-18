package Day_20230417;
// dp

import java.util.*;
public class Baek11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 1;
		
		int r = 1;
		while(true) {
			n = n - 1;
			if(n == 0) {
				break;
			}
			if(n < r) {
				break;
			}
			sum += combi(n, r);
			r = r + 1;
		}
		int answer = sum % 10007;
		System.out.println(answer);
	}
	
	public static int combi(int n , int r) {
		if(n==r) {
			return 1;
		} else if(r==1) {
			return n;
		}
		return combi(n-1, r-1) + combi(n-1,r);
	}

}
