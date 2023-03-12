package Day_20230312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_3665{
	
	static int T, N, M;
	static Queue<Integer> queue;
	static StringBuilder ans = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		while(T--> 0) {
			
			
			queue = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			int[] inDegree = new int[N+1];
			boolean arr[][] = new boolean[N+1][N+1];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				int now = Integer.parseInt(st.nextToken());
				inDegree[now] = i; // 진입 차수는 등수대로 저장
				for (int j=1;j<=N;j++) {
					if (j!=now && !arr[j][now]) arr[now][j] = true;
				}
			}
			
			M = Integer.parseInt(br.readLine());
			for (int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				swap(from, to, inDegree, arr); // 순위 변경
			}
			
			ans.append(topology(inDegree, arr)+"\n");
		}
		System.out.println(ans);
	}
	
	static void swap(int from, int to, int[] inDegree, boolean[][] arr) {
		if (!arr[from][to]) { 
			arr[from][to] = true;
			arr[to][from] = false;
			inDegree[from]--;
			inDegree[to]++;
		}
		else {
			arr[from][to] = false;
			arr[to][from] = true;
			inDegree[from]++;
			inDegree[to]--;
		}
	}
	
	static String topology(int inDegree[], boolean arr[][]) {
		sb = new StringBuilder();
		for (int i=1;i<=N;i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		
		for (int i=1;i<=N;i++) {
			// 사이클이 발생하면 IMPOSSIBLE
			if (queue.isEmpty()) return "IMPOSSIBLE"; 
			else if (queue.size()>1) return "?"; 
			
			int now = queue.poll();
			sb.append(now+" ");
			
			for (int j=1;j<=N;j++) { 
				if (arr[now][j]) { // 이동할 수 있는 정점 
					arr[now][j] = false;
					if (--inDegree[j] == 0) queue.add(j); 
				}
			}
		}
		return sb.toString();
	}
}