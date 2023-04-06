package Day_20230404;

import java.util.Scanner;

public class Baek1476 {

	public static void main(String[] args) {
		// E 15 S 28 M 19
		Scanner sc = new Scanner(System.in);
	
		int E,S,M;
		
		E = sc.nextInt();
		S = sc.nextInt();
		M = sc.nextInt();
		
		int answer = 1;
		int basuE = 0;
		int basuS = 0;
		int basuM = 0;
		int year = 0;
		
		while(true) {
			basuE++;
			basuS++;
			basuM++;
			year++;
			if(basuE > 15) {
				basuE = 1;
			}
			if(basuS > 28) {
				basuS = 1;
			}
			if(basuM > 19) {
				basuM = 1;
			}
			if(basuE == E && basuS == S && basuM == M) {
				break;
			}
		}
		System.out.println(year);
		
		
	}

}
