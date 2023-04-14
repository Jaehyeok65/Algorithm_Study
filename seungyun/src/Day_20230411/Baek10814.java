package Day_20230411;

import java.util.*;

public class Baek10814 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		
		// 배열 2개로 푸는 법 시간초과
//		int[] age = new int[n];
//		String[] name = new String[n];
//		
//		for(int i=0; i<n; i++) {
//			age[i] = sc.nextInt();
//			name[i] = sc.next();
//		}
		// 버블정렬
//		for(int i=0; i<n-1; i++) {
//			for(int j=0; j<n-1; j++) {
//				if(age[j] > age[j+1]) {
//					int temp = age[j];
//					age[j] = age[j+1];
//					age[j+1] = temp;
//					
//					String str = name[j];
//					name[j] = name[j+1];
//					name[j+1] = str;
//				}
//			}
//		}
		
		//Comparator
		String[][] arr = new String[n][2];
		for(int i=0; i<n; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			arr[i][0] = String.valueOf(age);
			arr[i][1] = name;
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				if(s1[0] == s2[0]) {
					return 1;
				} else {
					return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}

}
