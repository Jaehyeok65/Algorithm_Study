package Day_20230402;

import java.util.*;
import java.io.*;


public class Baek_1068 {
	
	static int N; //노드의 개수
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int target;
	static int ans = 0;
	static boolean visited[];
	static int start = 0; //시작 노드
	
	static void solve() {
		
		dfs(start); //탐색 시작
		
		System.out.println(ans); //결과 출력
		
	}
	
	static void dfs(int index) {
		if(index == target) {
			return;
		}
		
		visited[index] = true; //방문을 하며
		
		boolean flag = true; //방문한 노드가 있는지 확인하는 flag 변수
		for(int i : list.get(index)) { //방문한 노드와 관련된 노드들을 순차적으로 방문한다.
			if(!visited[i] && i != target) { //방문하지 않았으며 방문할 다음 노드가 삭제될 노드가 아닐경우 방문
				flag = false; //방문을 했으므로 false로 초기화하고
				dfs(i); //반복을 돌린다.
			}
		}
		if(flag) { //방문할 인접노드가 없다는 것은 리프노드라는 뜻
			ans++; //카운트 증가
		}
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}; //리스트 초기화
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int current = 0; //현재 노드
		while(st.hasMoreTokens()) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent != -1) {
				list.get(parent).add(current); //트리는 위에서 아래로 내려오므로
			}
			else {
				start = current;
			}
			current++; //현재 노드의 번호를 증가시킴
		}; //입력완료
		
		target = Integer.parseInt(br.readLine());
		
		solve();
		
		// TODO Auto-generated method stub

	}

}