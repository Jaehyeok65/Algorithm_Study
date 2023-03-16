package Day_20230316;


import java.util.*;
import java.io.*;



public class Baek_14567 {
	
	static int N; // 과목의 수
	static int M; // 선수 조건의 수
	static int weight[];
	static int result[]; //결과를 담을 배열
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	static void solve() {
		
		
		Queue<Integer> que = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(weight[i] == 0) { //진입차수가 0인 번호부터 큐에다가 집어넣는다
				que.add(i);
				result[i] = 1; //처음에 진입차수가 0이라는 것은 선수과목이 없다는 것이므로 한학기째에 들을 수 있다
			}
		}
		
		while(!que.isEmpty()) {
			
			int tmp = que.poll(); // 큐에 들어있는 선수과목을 꺼낸다
			
			for(int i : list.get(tmp)) { // 선수과목에 연결된 모든 과목들을 꺼내서 i로 받는다
				weight[i]--; //꺼낸 과목들의 진입차수를 감소시키고(선수과목이 없어졌으므로)
				result[i] = Math.max(result[i], result[tmp]); //선수과목을 무조건 다 들어야만 수강할 수 있으므로 최대값을 저장한다
				if(weight[i] == 0) { //진입차수가 0이라면 == 선수과목이 없다면 
					que.add(i); //큐에다가 집어넣는다
					result[i] += 1; //수강당시 학기를 추가해야하므로 1을 더한다
				}
				
			}
		}
		
		for(int i = 1; i <= N; i++) {
			sb.append(result[i] + " ");
		}
	}
	

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];
		
		result = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>()); 
		};
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int prev = Integer.parseInt(st.nextToken());
			
			int next = Integer.parseInt(st.nextToken()); //prev가 next의 선수과목이므로 prev를 들어야만 next를 들을 수 있다
			
			list.get(prev).add(next); //prev를 들어야만 next를 들을 수 있으므로 next 방향으로 간선 추가
			
			weight[next]++; //next의 진입 차수를 1증가시킨다
		}
		
		solve();
		
		System.out.print(sb.toString());
		
		
		// TODO Auto-generated method stub

	}

}
