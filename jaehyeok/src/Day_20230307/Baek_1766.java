package Day_20230307;

import java.util.*;

import java.io.*;




public class Baek_1766 {
	
	static int N; //문제 개수 정보
	static int M; //먼저 푸는 것이 좋은 개수 정보
	static PriorityQueue<Node> que = new PriorityQueue<>();
	static Queue<Integer> result = new LinkedList<>();
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //2차원 리스트로 구현
	static int weight[]; //진입차수 저장 배열
	
	
	static void solve() { //문제해결 메소드
		
		for(int i = 1; i <= N; i++) { //진입차수가 0인 노드부터 큐에다가 집어넣음
			if(weight[i] == 0) {
				que.add(new Node(i,weight[i]));
			}
		}
		
		while(!que.isEmpty()) { //큐가 빌 때까지 반복하며 해당 노드를 빼면 노드에 연결된 다른 노드의 진입차수를 1 감소시킴(가리키는 노드가 사라졌으므로)
			
			Node n = que.poll();
			result.add(n.data);
			
			 for (Integer i : list.get(n.data)) {
	                weight[i]--;

	                if (weight[i] == 0) {
	                    que.add(new Node(i,weight[i]));
	                }
	         }
		}
		
		
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		// M개의 줄을 입력 받음
		
		weight = new int[N+1];
		
		for(int i = 0; i <= N; i++) { //중요 == IndexOutOfBoundsException 예외가 발생하지 않게 N+1을 초기화해줘야함
			list.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int num1 = Integer.parseInt(st.nextToken()); //먼저 풀어야하는 문제 번호
			
			int num2 = Integer.parseInt(st.nextToken()); //나중에 풀어야하는 문제 번호
			
			list.get(num1).add(num2);
			
			weight[num2]++; //진입차수를 증가시킴
		}; //입력 완료
		
		solve();
		
		
		
		// TODO Auto-generated method stub

	}

}

class Node implements Comparable<Node> {
	
	int degree; //진입차수
	int data; //
	
	@Override
    public int compareTo(Node n) { //진입차수 오름차순 정렬
		if(this.degree == n.degree) {
			return this.data - n.data; //진입차수가 같다면 가능한 쉬운 것부터 문제 해결
		}
        return this.degree - n.degree; 
    };
    
    public Node(int data, int degree) {
    	this.data = data;
    	this.degree = degree;
    }
}
