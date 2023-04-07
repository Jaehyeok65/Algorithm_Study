package Day_20230407;

import java.util.*;
import java.io.*;




public class Baek_14676 {
	
	static int N;
	static int M;
	static int K;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static ArrayList<order> order = new ArrayList<>();
	static ArrayList<build> build = new ArrayList<>();
	static int weight[];
	static int current[];
	static String result = "King-God-Emperor";
	
	
	static void solve() {
		
		for(build b : build) {
			int create = b.create; //건물의 생성정보
			int num = b.num; //건물의 번호
			
			if(create == 1) { //건물의 생성정보에 따라 로직을 나눔 == 건물 생성
				if(!create(num)) { //생성로직이 false == 건물 생성이 불가능하다면 결과 출력 후 리턴
					System.out.println(result);
					return;
				}
			}
			else { // 건물 삭제
				if(!delete(num)) {
					System.out.println(result);
					return;
				}
			}
		}
		
		System.out.println(result);
	}
	
	static boolean create(int num) { //해당 건물의 번호를 매개변수로 받음
		if(weight[num] != 0) { //건물을 생성하려는데 가중치가 있다면 == 우선적으로 생성해야할 건물이 있다면
			result = "Lier!"; //결과에 Lier을 담은 후 리턴
			return false; 
		}
		else { //가중치가 0이라면 건물 생성이 가능한 것 == 건물을 지었으므로 해당 건물을 짓고 연결된 건물의 가중치를 감소시켜야함
			current[num]++; //현재 지어진 건물 번호 정보에 1을 증가시킴
			decrease(num);
			return true;
		}
	}
	
	static boolean delete(int num) { //마찬가지로 해당 건물의 번호를 매개변수로 받음
		if(current[num] == 0) { //현재 지어진 건물이 없다면 == 삭제할 수 없음
			result = "Lier!";
			return false;
		}
		else { //현재 지어진 건물이 있다면 == 지어진 건물을 1 감소시킨 후 연결된 건물의 가중치를 증가시켜야함
			current[num]--; //현재 지어진 건물 번호 정보에 1을 감소시킴
			increase(num);
			return true;
		}
	}
	
	static void decrease(int num) { //중복건설이 가능 == 중복 건설을 하여도 해당 가중치가 이미 감소되었다면 가중치를 감소시켜서는 안됨
		
		if(current[num] == 1) { //현재 지어진 건물 정보가 1일 때만 가중치를 감소시켜야함 == 중복 방지
			for(int i : list.get(num)) {
				weight[i]--;
			}
		}
	}
	
	static void increase(int num) { //중복건설이 가능 == 삭제를 하여도 이미 가중치가 증가되었다면 가중치를 증가시켜서는 안됨
		
		if(current[num] == 0) { //현재 지어진 건물 정보가 0일때만 가중치를 감소시켜야함
			for(int i : list.get(num)) {
				weight[i]++;
			}
		}
	}
	
	

	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N+1];
		
		current = new int[N+1];
		
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int prev = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list.get(prev).add(next);
			weight[next]++; //가중치를 증가시킴
		};
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int create = Integer.parseInt(st.nextToken()); //건물의 생성, 삭제 정보
			int num = Integer.parseInt(st.nextToken()); //건물의 번호
			build.add(new build(create,num));
		} //입력완료
		
		solve();
		
		
		// TODO Auto-generated method stub

	}

}

class order {
	
	int num; //건물 번호
	int order; //건물이 지어진 순서
	
	public order(int num, int order) {
		this.num = num;
		this.order = order;
	}
}

class build {
	
	int create;
	int num;
	
	public build(int create, int num) {
		this.create = create;
		this.num = num;
	}
}
