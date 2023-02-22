package Day_20230222;

import java.util.*;
import java.io.*;
	

public class Baek_18310 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //크기를 입력받음
		
		ArrayList<Integer> list = new ArrayList<>(); //입력받은 수를 저장할 리스트 선언
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) { // 다음 요소가 있으면
			list.add(Integer.parseInt(st.nextToken())); // 리스트에 추가
		};
		
		Collections.sort(list); // 각 집과 최소가 되려면 정렬 한 후 가운데 값을 구하면 최소가 됨
		
		int mid = (N-1) / 2; //list는 0부터 시작하므로 가운데 값을 구하기 위해 1을 빼줌
		
		System.out.print(list.get(mid));
		// TODO Auto-generated method stub

	}

}
