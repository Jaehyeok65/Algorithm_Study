package Day_20230411;

import java.util.*;

public class StringSort {

	public static void main(String[] args) {
		String[] str = {"C","A","R","E","Q","T","H","N","V","B"};
		
		for(int i=0; i<str.length; i++) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
		Arrays.sort(str);
		
		for(int i=0; i<str.length; i++) {
			System.out.print(str[i] + " ");
		}
		
		int result = 1;
		int base = 2;
		for(int i=0; i<10; i++) {
			result *= base;
			System.out.println(result);
		}
		System.out.println(result);
	}

}
