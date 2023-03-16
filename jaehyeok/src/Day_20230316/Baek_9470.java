package Day_20230316;


import java.util.*;
import java.io.*;


public class Baek_9470 {
	static StringBuilder sb = new StringBuilder();
	
	static void solve(ArrayList<ArrayList<Integer>> list, int[] weight, int K, int M, int P) {
		
		Queue<Integer> que = new LinkedList<>();
		
		int [] strahler = new int[M+1];
		
		Node [] strcount = new Node[M+1]; //각 인덱스에 들어온 값들을 저장
		
		for(int i = 1; i <= M; i++) {
			if(weight[i] == 0) {
				que.add(i);
				strahler[i] = 1; //처음 시작 노드는 1이므로 
			}
		};
		
		while(!que.isEmpty()) {
			
			int tmp = que.poll(); //노드를 빼서
			if(tmp == M) break; //바다와 만나는 노드라면 리턴
			
			for(int i : list.get(tmp)) {
				weight[i]--; //진입차수를 감소시킨 후
				strcheck(i, tmp, strcount, strahler, weight, que); //strahler을 결정하는 메소드를 수행한다
				
			}
		}
		
		
		
		sb.append(K + " " + strahler[M] +"\n");
	}
	
	static void strcheck(int index, int tmp, Node strcount[], int strahler[], int weight[], Queue<Integer> que) {
		if(strcount[index] == null) { //아무것도 없다면 == 들어온 것이 없다면
			strcount[index] = new Node(strahler[tmp], 1); //노드를 생성해서 참조해줌
		}
		else { //null이 아니라면 == 노드가 있다면
			Node n = strcount[index]; //기존에 있던 노드를 빼서 
			int tmpmax = Math.max(n.max, strahler[tmp]); //max값을 구한 후 tmpmax에 값을 저장한다.
			if(n.max == tmpmax) { //기존에 n.max와 tmpmax가 같다면
				n.maxcount += 1; //maxcount를 1 증가시킨다
			}
			else if(tmpmax > n.max){ //기존에 n.max가 tmpmax보다 작다면
				Node tmpnode = new Node(tmpmax,1); //새롭게 max값을 초기화해준다.
				strcount[index] = tmpnode;
			}
		}
		
		if(weight[index] == 0) {
			Node n = strcount[index];
			if(n.maxcount >= 2) {
				strahler[index] = strahler[tmp] + 1;
			}
			else if(n.maxcount < 2){
				strahler[index] = strahler[tmp];
			}
			que.add(index);
		}
	};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T; // 테스트 케이스 수
		
		T  = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		while(T --> 0) {
			
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken()); //테스트 케이스 번호
			
			int M = Integer.parseInt(st.nextToken()); //노드의 개수
			
			int P = Integer.parseInt(st.nextToken()); //간선의 개수
			
			ArrayList<ArrayList<Integer>> list = new ArrayList<>(); //연결리스트 선언
			
			for(int i = 0; i <= M; i++) {
				list.add(new ArrayList<>()); //연결리스트 초기화
			};
			
			int weight[] = new int[M+1]; //진입차수 배열 선언
			
			for(int i = 0; i < P; i++) { //간선 연결
				st = new StringTokenizer(br.readLine());
				
				int prev = Integer.parseInt(st.nextToken());
				
				int next = Integer.parseInt(st.nextToken());
				
				list.get(prev).add(next);
				
				weight[next]++;
			}
			
			solve(list, weight, K, M, P);
			
		}
		
		System.out.print(sb.toString());
		// TODO Auto-generated method stub

	}

}

class Node {
	
	int max; //들어온 값 중 최대 값 저장
	int maxcount; //들어온 값 중 최대 값 개수
	
	public Node(int max, int maxcount) {
		this.max = max;
		this.maxcount = maxcount;
	};
}

