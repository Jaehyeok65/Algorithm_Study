package Day_20230408;

import java.util.*;
import java.io.*;



public class Baek_21276 {
	
	static int N; //사람 수
	static int M; //기억하는 정보의 개수
	static HashMap<String, Integer> map = new HashMap<>(); //조상의 이름을 키로하며, index를 value로 한다
	static HashMap<String, Integer> indegree = new HashMap<>();
	static ArrayList<ArrayList<String>> list = new ArrayList<>();
	
	
	static void solve() {
		
		ArrayList<String> first = new ArrayList<>(); //가문 시조 출력 용
		ArrayList<Write> second = new ArrayList<>(); //자식 정보 출력 용
		Queue<String> que = new LinkedList<>();
		
		for(String s : indegree.keySet()) {
			if(indegree.get(s) == 0) {
				first.add(s);
				que.add(s); //차수가 0인 것부터 큐에다가 집어넣음
			}
		} //가문의 개수와 시조를 구함
		
		while(!que.isEmpty()) {
			
			String target = que.poll(); //차수가 0인 노드를 꺼낸 후
			ArrayList<String> son = new ArrayList<>();
			int index = map.get(target); //해당 이름에 해당하는 인덱스를 가져온다 
			
			for(String tmp : list.get(index)) { //해당 노드의 자손들을 가져온다.
				int currentindegree = indegree.get(tmp); //해당 자손의 차수를 가져온다.
				if(--currentindegree == 0) { //차수를 1감소시킨 것이 0이라면 자식 관계.
					son.add(tmp);
					que.add(tmp);
				}
				indegree.put(tmp, currentindegree); //차수를 갱신한다.
			}
			Collections.sort(son);
			second.add(new Write(target, son.size(), son));
		}
		
		Collections.sort(first); //사전 순으로 출력해야 하므로 정렬 수행
		Collections.sort(second);
		
		System.out.println(first.size());
		for(String s : first) {
			System.out.print(s + " ");
		};
		System.out.println("");
		StringBuilder sb = new StringBuilder();
		for(Write w : second) {
			sb.append(w.name + " " + w.size + " ");
			for(String s : w.list) {
				sb.append(s + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
		
		
		
		
	}

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) { //처음 가중치는 0이므로
			String tmp = st.nextToken();
			indegree.put(tmp, 0);
			map.put(tmp, i);
		};
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String x = st.nextToken();
			String y = st.nextToken(); //x의 조상 중 y가 있다는 뜻
			list.get(map.get(y)).add(x); //y가 조상이며
			int currentindegree = indegree.get(x);
			indegree.put(x, currentindegree + 1);
		}
		//입력완료
		
		solve();
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}


class Write implements Comparable<Write>{
	
	String name;
	int size;
	ArrayList<String> list;
	
	public Write(String name, int size, ArrayList<String> list) {
		this.name = name;
		this.size = size;
		this.list = list;
	}
	
	@Override
	public int compareTo(Write w) {
		return name.compareTo(w.name);
	}
}
