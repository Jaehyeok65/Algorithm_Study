package Day_20230213;

import java.util.*;
import java.io.*;




public class Baek_1213 { //풀다가 도저히 예외를 못 찾겠어서 접근방식만 블로그 참고 == 삽질하고 있었다는 것을 알게 됨
	
	static HashMap<Character, Integer> hash = new HashMap<>(); //팰린드롬으로 만드려면, 각 알파벳 수의 짝이 맞아야 하므로
	
	static Boolean isPalin(String s) { //팰린드롬으로 만들 수 있는지 체크함.
		
		int odd = 0; //홀수가 몇 개인지 체크
		
		for(int i = 0; i < s.length(); i++) { //루프를 돌면서 각 알파벳과 개수를 hashmap에 집어넣음
			char tmp = s.charAt(i);
			hash.put(tmp, hash.getOrDefault(tmp, 0) + 1); //알파벳을 key, 개수를 value로 하여 map에 집어넣음
		}
		
		for(char key : hash.keySet()) { //hash에 들어있는 값을 찾아
			if(hash.get(key) % 2 == 1) { //홀수라면 odd++;
				odd++;
			}
		}
		
		if(odd > 1) { //홀수가 두 개 이상이라면 팰린드롬을 만들 수 없다는 뜻
			return false;
		}
		else { //홀수가 두 개 이상이 아니라면 팰린드롬을 만들 수 있다는 뜻임
			return true;
		}
		
	}
	
	static void solve(String s) {
		
		
		if(isPalin(s)) {
			Palin();
			// 알파벳을 팰린드롬으로 사전에 맞게 배치하여 출력하는 메소드 정의
		}
		else {
			System.out.print("I'm Sorry Hansoo");
		}
	}
	
	static void Palin() { //해쉬맵에 저장된 알파벳을 사전 순으로 가장 앞서게 출력함
		
		ArrayList<Character> list = new ArrayList<>(); //key를 사전순으로 정렬하기 위한 리스트
		
		for(char key : hash.keySet()) {
			list.add(key);
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder(); //결과를 담을 StringBuilder 선언
		
		String tmp = "";
		for(char key : list) {
			if(hash.get(key) % 2 == 1) { //홀수라면 따로 빼놓음
				tmp = String.valueOf(key);
			}
			for(int i = 0; i < hash.get(key) / 2; i++) { //루프를 돌면서 절반만 Builder에 추가(나머지 절반은 reverse로 추가)
				sb.append(key);
			}
		}
		
		
		String result = sb.toString(); //sb.reverse()를 수행하면 주소 참조로 인해, 바뀌어버리므로
		
		
		
		System.out.print(result + tmp + sb.reverse().toString()); //추가한 builder에 홀 수를 추가한 후 reverse하여 추가
	}
	
	
	
	
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine(); //팰린드롬으로 바꿔줄 문자열을 입력받음
		
		solve(s);
		
		
		// TODO Auto-generated method stub

	}

}
