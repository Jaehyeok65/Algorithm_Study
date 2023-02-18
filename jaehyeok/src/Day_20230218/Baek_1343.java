package Day_20230218;

import java.util.*;
import java.io.*;



public class Baek_1343 {
	
	static final String poli1 = "AAAA";
	static final String poli2 = "BB"; //변할 일이 없는 수이므로 final로 선언함
	
	static void solve(String target) { //문제 해결 메소드
		
		//고안한 방법 == 문자열을 "XXXX"를 "AAAA"로 치환한 다음, "XX"를 "BB"로 치환하여 결과를 출력하며, 치환된 결과에 "X"가 남아있다면 -1을 출력한다.
		
		String tmp1 = target.replaceAll("XXXX", poli1); //앞에서부터 루프하며 만족하는 조건을 모두 변환함
		String tmp2 = tmp1.replaceAll("XX", poli2); //마찬가지
		
		if(tmp2.contains("X")) { //치환된 결과에 "X"가 포함되어 있다면 -1 출력
			System.out.print(-1);
		}
		else { //포함되어 있지 않으면 정상적으로 치환을 완료한 것이므로 결과 출력
			System.out.print(tmp2);
		}
	}
	
	
	

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine(); //입력받은 문자열을 poli1, poli2로 치환할 것
		
		solve(target); //문제해결 메소드 호출
		
		
		
		
		// TODO Auto-generated method stub

	}

}