package Day_20230328;

import java.io.*;
import java.util.*;



public class Baek_17070 {
	static int N; //크기
	static int map[][]; //맵
	static int dy[] = {0,1,1};
	static int dx[] = {1,0,1}; //이동방향 == 가로, 세로, 오른쪽 아래 대각선
	static int ans = 0;
	

	static void solve() {
		
		
		start(1,2,0); //파이프의 끝 부분의 좌표를 인수로 함
		
		System.out.print(ans);
	}
	
	
	static void start(int y, int x, int index) { //index는 현재 파이프가 가로인지, 세로인지, 대각선인지를 판별함
		if(y == N && x == N) {
			ans++;
			return; // 끝 좌표에 도달하면 리턴함
		}
		
		
		for(int i = 0; i < 3; i++) {
			
			int nextY = y + dy[i];
			int nextX = x + dx[i]; //파이프의 이동
			
			if(check(nextY, nextX, index, i)) {
				start(nextY,nextX,i); //마지막으로 연결한 게 현재 파이프 모습이 되므로 i를 index에다가 인수로 줌
			}
			
		}
		
	}
	
	static boolean check(int y, int x, int index, int i) {
		if(index == 0) { //index가 0일때는 파이프가 가로일 때이므로 가로와 대각선으로 밖에 이동하지 못함
			if(i == 0) { //가로로 이동할 경우
				if(!mapcheck(y,x)) return false; //범위에서 벗어난다면 false 리턴 
				if(!isMove(y,x,i)) return false; //이동가능한 범위가 아니라면 false 리턴
			}
			else if(i == 1) {
				return false;
			}
			else {
				if(!mapcheck(y,x)) return false;
				if(!isMove(y,x,i)) return false;
			}
		}
		else if(index == 1) { //index가 1일때는 파이프가 세로일 때이므로 세로와 대각선으로 밖에 이동하지 못함
			if(i == 0) {
				return false;
			}
			else if(i == 1) {
				if(!mapcheck(y,x)) return false; //범위에서 벗어난다면 false 리턴 
				if(!isMove(y,x,i)) return false; //이동가능한 범위가 아니라면 false 리턴
			}
			else {
				if(!mapcheck(y,x)) return false; //범위에서 벗어난다면 false 리턴 
				if(!isMove(y,x,i)) return false; //이동가능한 범위가 아니라면 false 리턴
			}
		}
		else { //index가 2일때는 파이프가 대각선일 때이므로 모두 이동가능
			if(!mapcheck(y,x)) return false; //범위에서 벗어난다면 false 리턴 
			if(!isMove(y,x,i)) return false; //이동가능한 범위가 아니라면 false 리턴
		}
		
		return true;
	}
	
	static boolean mapcheck(int y, int x) {
		if(y < 1 || x < 1 || y > N || x > N) return false; //map의 범위에서 벗어나면 false 리턴
		return true;
	}
	
	static boolean isMove(int y, int x, int i) { //이동할 수 있는지를 판별함
		if(i == 0) { //가로로 이동할 경우 다음 칸만 확인하면됨
			if(map[y][x] == 1) return false;
		}
		else if(i == 1) { //세로로 이동할 경우 밑에 칸만 확인하면됨
			if(map[y][x] == 1) return false;
		}
		else { //대각선으로 이동할 경우 세칸을 확인해야함
			if(map[y][x] == 1 || map[y-1][x] == 1 || map[y][x-1] == 1) return false;
		}
		
		return true;
		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		
		StringTokenizer st;
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}; //입력완료
		
		solve();
		
		
		
		// TODO Auto-generated method stub

	}

}
