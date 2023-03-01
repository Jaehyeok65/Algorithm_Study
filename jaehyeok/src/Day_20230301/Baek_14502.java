package Day_20230301;

import java.util.*;
import java.io.*;


public class Baek_14502 {
	
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0};
	static int map[][]; //0은 빈칸, 1은 벽, 2는 바이러스
	static int N; //세로 크기
	static int M; //가로 크기
	static int result = Integer.MIN_VALUE;
	
	
	static void solve() {
		dfs(0);
		
		System.out.print(result);
	}
	
	
	static void dfs(int depth) { // 깊이 우선 탐색으로 벽을 세우는 메소드
		if(depth == 3) {
			bfs(); //벽을 3개 세웠다면 bfs로 바이러스 유포
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(depth+1);
					map[i][j] = 0; //이후 로직을 수행해야하기 때문에 벽을 세운 후 다시 원래대로 돌려 놓음
				}
			}
		}
	}
	
	static void bfs() {
		
		Queue<Virus> que = new LinkedList<>(); //bfs를 수행하기 위해 큐를 선언
		
		int tmp[][] = new int[N][M]; //맵 원본에 수행하면 복잡해지므로 카피맵을 선언하여 카피맵으로 바이러스 진행
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		} //복사 완료
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 2) { //루프를 돌다가 바이러스를 만나면 큐에 추가함
					que.add(new Virus(i,j));
				}
			}
		}
		
		while(!que.isEmpty()) { //큐가 빌때까지 계속해서 반복진행 
			Virus v = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextY = v.y + dy[i];
				int nextX = v.x + dx[i];
				
				if(nextX < 0 || nextY < 0 || nextY >= N || nextX >= M) continue; //map의 범위를 벗어나면 안되므로
				if(tmp[nextY][nextX] == 0) {
					tmp[nextY][nextX] = 2; //2로 초기화(중복 큐 추가 방지)
					que.add(new Virus(nextY,nextX));
				}
			}
		}
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp[i][j] == 0) {
					count++;
				}
			}
		}
		
		result = Math.max(result, count);
		
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			};
		};
		
		solve();
		
		// TODO Auto-generated method stub

	}

}

class Virus {
	int x;
	int y;
	
	public Virus(int y, int x) {
		this.x = x;
		this.y = y;
	}
}
