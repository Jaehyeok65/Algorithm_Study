package Day_20230324;


import java.util.*;
import java.io.*;


//초기 시도 == bfs로 모든 벽 탐색 == 시간 초과
//즉 탐색을 줄여야함 == 그룹화하여 탐색
public class Baek_16946 {
	
	static int N;
	static int M;
	static char map[][];
	static int group[][];
	static int groupcount[][];
	static boolean visited[][];
	static int dx[] = {0,0,-1,1};
	static int dy[] = {-1,1,0,0}; //상하좌우
	static StringBuilder sb = new StringBuilder();
	
	
	static void solve() {
		
		int groupindex = 2; //그룹 인덱스는 0과 1로된 인덱스와 구분하기 위해 2부터 시작
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == '0' && group[i][j] == 0) {
					bfs(i,j, groupindex++); //그룹 번호 부여
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == '1') {
					countsolve(i,j);
				}
				else {
					sb.append("0");
				}
			}
			sb.append('\n');
		}
		
		System.out.print(sb.toString());
		
	}
	
	static void countsolve(int y, int x) {
		
		HashSet<Integer> set = new HashSet<>();
		
		int count = 1;
		for(int i = 0; i < 4; i++) {
			
			int nextY = y + dy[i];
			int nextX = x + dx[i];
			
			if(nextY < 1 || nextX < 1 || nextY > N || nextX > M) continue; //범위를 벗어난다면 continue
			if(map[nextY][nextX] == '0' && !set.contains(group[nextY][nextX])) {
				count += groupcount[nextY][nextX];
				set.add(group[nextY][nextX]);
			}
		}
		
		sb.append(count%10);
		
	}
	
	
	static void bfs(int y, int x, int index) {
		
		Queue<dot> que = new LinkedList<>();
		Queue<dot> countque = new LinkedList<>();
		
		que.add(new dot(y,x));
		countque.add(new dot(y,x));
		
		group[y][x] = index;
		
		int count = 1; //그룹의 개수
		
		while(!que.isEmpty()) {
			
			dot d = que.poll();
			
			for(int i = 0; i < 4; i++) {
				int nextY = d.y + dy[i];
				int nextX = d.x + dx[i];
				
				if(nextY < 1 || nextX < 1 || nextY > N || nextX > M) continue;
				if(visited[nextY][nextX]) continue;
				
				if(map[nextY][nextX] == '0' && group[nextY][nextX] == 0) {
					visited[nextY][nextX] = true;
					group[nextY][nextX] = index;
					count++;
					que.add(new dot(nextY,nextX));
					countque.add(new dot(nextY,nextX));
				}
			}
		}
		
		while(!countque.isEmpty()) {
			dot d = countque.poll();
			groupcount[d.y][d.x] = count;
		}
	}
	
	
	
	
	
		
		
	
	

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N+1][M+1];
		
		group = new int[N+1][M+1];
		
		groupcount = new int[N+1][M+1];
		
		visited = new boolean[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String s = br.readLine();
			for(int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1); 
				group[i][j] = s.charAt(j-1) - '0';
			}
		}
		
		solve();
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}

class dot {
	
	int y;
	int x;
	
	public dot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}
