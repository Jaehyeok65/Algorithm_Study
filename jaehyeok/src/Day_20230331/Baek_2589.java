package Day_20230331;

import java.util.*;
import java.io.*;


public class Baek_2589 {
	
	
	static int N;
	static int M;
	static int dy[] = {-1,1,0,0};
	static int dx[] = {0,0,-1,1}; //상하좌우
	static char map[][];
	static boolean visited[][];
	static int ans = 0;
	
	
	static void solve() {
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 'L') {
					bfs(i,j);
				}
			}
		}
		
		System.out.print(ans);
		
		
	}
	
	
	static void bfs(int y, int x) {
		
		Queue<dot> que = new LinkedList<>();
		
		que.add(new dot(y,x,0));
		
		visited = new boolean[N+1][M+1];
		
		visited[y][x] = true;
		
		int distance = 0;
		
		while(!que.isEmpty()) {
			
			dot d = que.poll();
		
			distance = Math.max(distance, d.dis);
			for(int i = 0; i < 4; i++) {
				int nextY = d.y + dy[i];
				int nextX = d.x + dx[i];
				
				if(nextY < 1 || nextX < 1 || nextY > N || nextX > M) continue;
				if(visited[nextY][nextX]) continue;
				if(map[nextY][nextX] != 'L') continue;
				visited[nextY][nextX] = true;
				que.add(new dot(nextY, nextX , d.dis + 1));
			}
		}
		
		ans = Math.max(ans, distance);
		
		
	}

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][M+1]; 
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1);
			};
		}
		//입력완료
		
		solve();
		
		// TODO Auto-generated method stub

	}

}


class dot {
	
	int y;
	int x;
	int dis; //현재까지의 거리
	
	public dot(int y, int x, int dis) {
		this.y = y;
		this.x = x;
		this.dis = dis;
	}
}