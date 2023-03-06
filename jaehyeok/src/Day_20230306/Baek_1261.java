package Day_20230306;

import java.util.*;
import java.io.*;




public class Baek_1261 {
	
	static int N; //세로
	static int M; //가로
	static int map[][];
	static boolean visited[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int result = Integer.MAX_VALUE;
	
	static void solve() {
		
		bfs(0,0);
		
		System.out.print(result);
	}
	
	
	static void bfs(int y, int x) {
		
		PriorityQueue<dot> que = new PriorityQueue<>();
		
		que.add(new dot(y,x,0));
		
		while(!que.isEmpty()) {
			
			dot d = que.poll();
			
			if(d.y == N-1 && d.x == M-1) {
				result = Math.min(result, d.depth);
				return;
			}
			
			for(int i = 0; i < 4; i++) {
				int nextY = d.y + dy[i];
				int nextX = d.x + dx[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= M || nextY >= N) continue;
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == 0) { //벽이 없는 경우 벽을 부수지 않고 방문함
					visited[nextY][nextX] = true;
					que.add(new dot(nextY,nextX,d.depth));
					
				}
				if(map[nextY][nextX] == 1) {
					visited[nextY][nextX] = true;
					que.add(new dot(nextY,nextX,d.depth + 1));
				}
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			};
		};
		
		solve();
		
		
		// TODO Auto-generated method stub

	}

}


class dot implements Comparable<dot> {
	
	int x;
	int y;
	int depth;
	
	public dot(int y, int x, int depth) {
		this.y = y;
		this.x = x;
		this.depth = depth;
	}
	
	@Override
    public int compareTo(dot o) {
        return depth - o.depth;
    }
}
