package Day_20230214;

import java.util.*;
import java.io.*;


public class Baek_2847 {
	
	static int N; //주어지는 보기의 수
	static int [] arr; //순차 리스트가 자료 밀도가 높아 검색이 더 빠르기 때문에 배열로 선언함
	
	static void solve() { //문제 해결 로직 == 배열 끝에서 부터 루프를 돌면서 각 인덱스의 값 차이가 1씩 나도록 감소시킴?
		
		int count = 0; //감소시킨 횟수
		
		for(int i = N-1; i >= 1; i--) { // 배열의 크기가 N이므로 마지막 인덱스는 N-1이며, i-1까지 비교하므로 i >= 1해야 오류가 안난다.
			int currentlevel = arr[i]; // 이해하기 쉽게 현재레벨 변수 할당
			int prevlevel = arr[i-1]; // 마찬가지로 이전레벨 변수 할당
			if(sizeCompare(currentlevel, prevlevel)) { //현재 레벨의 점수가 높다면 감소시킬 필요가 없으므로 conitnue
				continue;
			}
			count += (Math.abs(currentlevel - prevlevel) + 1); //두 레벨의 점수차이의 절대값 + 1만큼 감소시키면 점수가 1만큼만 차이 날것
			arr[i-1] = currentlevel - 1; //이전 값을 현재 값과 1만큼만 차이나게 재할당해줌
		}
		
		System.out.print(count); //결과 출력
		
	}
	
	static boolean sizeCompare(int current, int prev) { //현재 크기보다 이전 크기가 큰지, 작은지를 판별함
		if(current > prev) { //레벨별로 점수가 높아야 하므로, 점수가 같아도 안됨.
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N]; //배열 초기화
		
		for(int i = 0; i < N; i++) { //배열에 값을 할당
			arr[i] = Integer.parseInt(br.readLine());
		};
		
		solve(); //문제 해결 메소드 실행
		
		// TODO Auto-generated method stub

	}

}
