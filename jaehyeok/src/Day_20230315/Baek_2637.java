package Day_20230315;


import java.util.*;
import java.io.*;


public class Baek_2637 {
	
	static int N; //개수
	static int M; //관계 개수
	static boolean part[]; //기본부품인지 중간부품인지 구분용
	static int dp[]; //각 번호 당 필요한 기본 부품의 수를 저장함
	static int weight[];
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	
	
	static void solve() {
		
		
		Queue<Integer> que = new LinkedList<>();
		
		que.add(N); //N에 필요한 부품 수를 알아야 하므로 N을 집어넣은 후 필요한 노드들을 얻어오는 방식
		dp[N] = 1;
		
		while(!que.isEmpty()) {
			
			int tmp = que.poll();
			
			for(Node n : list.get(tmp)) { //리스트에 연결된 간선을 꺼내서
				
				weight[n.num]--; //진입차수를 감소시키고
				dp[n.num] += dp[tmp] * n.count; //부품 개수만큼 만들어야 하므로 n.count를 곱해줌
				if(weight[n.num] == 0) { //진입차수가 0이 된다면 큐에다가 집어넣음
					que.add(n.num);
				}
				
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(!part[i]) {
				System.out.println(i + " " + dp[i]);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		part = new boolean[N+1];
		
		dp = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		};
		
		weight = new int[N+1];
		
		M = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int X = Integer.parseInt(st.nextToken());
			
			if(!part[X]) { //X를 만드는데 필요하다는 것은 기본부품이 아니라 중간부품이라는 뜻
				part[X] = true;
			}
			
			int Y = Integer.parseInt(st.nextToken());
			
			int K = Integer.parseInt(st.nextToken());
			// 중간부품 X를 만드는데 부품번호 Y가 K개 필요하다
			
			list.get(X).add(new Node(Y,K)); //그래프의 연결 관계 == X를 만드는데 Y가 필요하므로 X에 Y를 추가하며 X를 만드는데 필요한 개수 저장
			
			weight[Y]++; //X의 진입차수를 증가시킴
		}
		
		solve();
		
		
		
		
		// TODO Auto-generated method stub

	}

}

class Node {
	
	int num;
	int count;
	
	public Node(int num, int count) {
		this.num = num;
		this.count = count;
	}
}
