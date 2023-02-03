package Day_20230203;

import java.util.*;
import java.io.*;

class node {
	
	private int data;
	private int order;
	
	
	public node(int data, int order) {
		this.data = data;
		this.order = order;
	}
	
	public int getData() {
		return this.data;
	}
	
	public int getOrder() {
		return this.order;
	}
}

public class Baek_1966 {
	
	static int T; //테스트 케이스 수
	static int N; //문서의 개수 
	static int M; //타겟
	static StringBuilder sb = new StringBuilder();
	


	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			Queue<node> que = new LinkedList<>();
			ArrayList<Integer> list = new ArrayList<>(); //중요도 리스트
			int count = 0;
			while(st1.hasMoreTokens()) {
				int important = Integer.parseInt(st1.nextToken());
				list.add(important);
				que.add(new node(important,count++)); //초기 순서와 중요도를 큐에다가 삽입
			};
			
			Collections.sort(list,Collections.reverseOrder()); //중요도가 큰 순서대로 정렬함.
			
			int index = 0; //리스트의 인덱스
			int result = 0; //인쇄되는 순서
			while(!que.isEmpty()) {
				node target = que.poll(); //큐에서 꺼낸 후
				
				if(target.getData() == list.get(index)) { //큐에서 꺼낸 데이터의 중요도를 체크하여 중요도가 가장 높다고 나온다면 인쇄
					list.remove(index); //인쇄했으므로 중요도 리스트에서 제거한 후
					result++; //인쇄를 했으므로 인쇄한 순서를 증가시킴
					if(target.getOrder() == M) { //인쇄한 것이 찾던 것인지 확인하여 맞다면
						sb.append(result + "\n"); //출력할 데이터에 추가한 후
						break; //break하여 다음 테스트케이스로 넘어감
					}
				}
				else { //큐에서 꺼낸 데이터의 중요도가 가장 높지 않다면
					que.add(target); //큐의 맨뒤에 집어넣음
				}
			}
		}
		
		System.out.print(sb.toString());
		
		// TODO Auto-generated method stub

	}

}
