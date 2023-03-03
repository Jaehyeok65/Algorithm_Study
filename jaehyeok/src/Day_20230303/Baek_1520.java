package Day_20230303;



import java.util.*;
import java.io.*;


public class Baek_1520 {
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0}; //상하좌우
	static int M;
	static int N;
	static int map[][]; //입력받을 그래프
	static int dp[][]; //방문 체크
	
	
	static void solve() {
		
		System.out.print(dfs(0,0));
		
	}
	
	static int dfs(int y, int x) {
		
		if(y == M - 1 && x == N - 1) {
			return 1;
		}
		
		if(dp[y][x] != -1) { //메모제이션 -1이 아니라면 이미 방문한 지점이므로 탐색을 하지 않고 리턴함
			return dp[y][x];
		}
		
		dp[y][x] = 0; //0으로 초기화해주면서 이미 방문한 지점임을 알림
		for(int i = 0; i < 4; i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			if(nextY < 0 || nextX < 0 || nextY >= M || nextX >= N) continue; //map의 범위에서 벗어나면 안되므로
			if(map[nextY][nextX] >= map[y][x]) continue; //항상 내리막길로만 이동해야 하므로
			dp[y][x] += dfs(nextY,nextX);
		}
		
		return dp[y][x];
	}
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //세로 크기
		
		N = Integer.parseInt(st.nextToken()); //가로 크기
		
		map = new int[M][N]; //M이 세로, N이 가로 이므로
		
		dp = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		solve();
		
		
		
		
		// TODO Auto-generated method stub

	}

}
