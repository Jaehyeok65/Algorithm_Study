package Day_20230304;

import java.util.*;
import java.io.*;


public class Baek_12904 {
	
	static String A;
	static String B;
	
	
	static void solve() { //문제해결 메소드
		
		//첫번째로 떠오른 방법 == T의 맨 뒤가 A면 A를 지우고, B면 B를 지운 다음에 문자열을 뒤집음
		while(A.length() < B.length()) { //A와 B의 길이가 같아질때까지 반복
			if(B.substring(B.length()-1).equals("A")) { //1번 연산 수행
				first();
			}
			else { //2번 연산 수행
				second();
			}
		}
		
		if(A.equals(B)) { //문자열의 길이가 같아지면 연산을 마친것 == A와 B가 같다면 바꿀 수 있으므로 1 출력
			System.out.print("1");
		}
		else { //다르다면 바꿀 수 없으므로 0 출력
			System.out.print("0");
		}
		
	}
	
	static void first() { //1번 연산 == 문자열 뒤에 A를 추가하는 것이므로, 맨 마지막 문자가 A이면 A를 지움
		B = B.substring(0,B.length()-1);
	}
	
	static void second() { //2번 연산 == 문자열을 뒤집고 B를 추가하는 것이므로, 맨 마지막 문자가 B이면 B를 지우고 문자열을 뒤집음
		B = B.substring(0,B.length()-1);
		StringBuffer sb = new StringBuffer(B);
		B = sb.reverse().toString();
	}

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = br.readLine();
		
		B = br.readLine(); //예제 케이스를 입력받음
		
		solve();
		
		
		// TODO Auto-generated method stub

	}

}
