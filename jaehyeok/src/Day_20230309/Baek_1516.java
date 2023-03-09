package Day_20230309;


import java.util.*;

import java.io.*;



public class Baek_1516 {
	
	static int N; //건물의 종류 수
	static int dp[];
	static int time[];
	static int weight[]; //진입차수를 저장할 배열
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	
	
	static void solve() {
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(weight[i] == 0) { //진입차수가 0이라는 것은 완성되었다는 뜻이므로
				dp[i] = time[i]; //dp배열에는 현재까지의 시간 정보를 담음
				pq.add(new Data(i, weight[i]));
			}
		}
		
		while(!pq.isEmpty()) {
			
			Data d = pq.poll();
			
			int num = d.num; //노드를 가져옴
			
			for(int i : list.get(num)) {
				weight[i]--; //진입차수를 줄이고
				
				dp[i] = Math.max(dp[i], dp[num]); //현재까지 최대 시간을 저장해야함 == 모든 건물이 다 지어져야만 지을 수 있으므로
				if(weight[i] == 0) { //진입차수가 0이 되었다면 큐에 넣어서 반복함
					dp[i] += time[i]; //진입차수가 0이 되었다는 것은 건물이 완성되었다는 것이므로 짓는 시간을 더해야함
					pq.add(new Data(i,weight[i]));
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(dp[i]);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		dp = new int[N+1];
		
		time = new int[N+1];
		
		weight = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[i] = t;
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) break;
				weight[i]++; //각 노드에 필요한 진입차수를 1증가시킴
				list.get(num).add(i);
			}
		}
		
		solve();
		
		
		// TODO Auto-generated method stub

	}

}

class Data implements Comparable<Data> {
	
	int degree;
	int num;
	
	@Override
    public int compareTo(Data n) { //진입차수 오름차순 정렬
        return this.degree - n.degree; 
    };
    
    public Data(int num, int degree) {
    	this.num = num;
    	this.degree = degree;
    }
	
}
