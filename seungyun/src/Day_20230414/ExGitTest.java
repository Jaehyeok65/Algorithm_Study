package Day_20230414;

import java.util.*;
public class ExGitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(gcd(9,21));
		
		int i=0;
		int sum=0;
		while(i<10) {
			i++;
			if(i%2==1)
				continue;
			sum += i;
			System.out.println(i);
		}
		System.out.println(sum);
	}
	
	public static int gcd(int a, int b) {
		int r = a % b;
		if(r==0) {
			return b;
		} else {
			return gcd(b, r);
		}
	}

}
