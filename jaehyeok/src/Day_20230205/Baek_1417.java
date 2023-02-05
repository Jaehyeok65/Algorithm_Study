package Day_20230205;


import java.util.*;
import java.io.*;



public class Baek_1417 {
	static int N;
	static int result = 0;
	
	static boolean check(int vote[]) { //배열에서 자신보다 높은 득표 수를 가진 사람이 있는지 체크
		for(int i = 2; i <= N; i++) {
			if(vote[1] <= vote[i]) { //득표 수가 같아도 안되므로
				return false; //자신이 가장 높지 않으므로
			}
		}
		return true; //자신이 가장 높으므로 true 리턴
	}
	
	static void solve(int vote[]) {
		while(!check(vote)) { //true가 나온다면 종료
			take(vote);
		}
		System.out.println(result);
	}
	
	static void take(int vote[]) { //루프를 돌면서 가장 높은 사람의 표를 뺏음
		int max = vote[1];
		int maxindex = 1;
		for(int i = 2; i <= N; i++) { //루프를 돌면서 가장 표를 많이 받은 사람을 찾음(표가 같아도 안되므로 = 포함)
			if(vote[i] >= max) {
				max = vote[i];
				maxindex = i;
			}
		}
		vote[maxindex]--; //가장 표를 많이 받은 사람의 표를 깎고
		vote[1]++; //1번의 표를 올림
		result++;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int vote[] = new int[N+1]; //투표를 배열로 받음
		
		for(int i = 1; i <= N; i++) {
			vote[i] = Integer.parseInt(br.readLine());
		} //입력
		
		solve(vote);
		// TODO Auto-generated method stub

	}

}
