package Day_20230204;


import java.util.*;
import java.io.*;


public class Baek_5568 {
	
	
	static HashSet<String> hash = new HashSet<>();
	static String[] arr;
	static boolean[] visited;
	
	public static void solve(int N, int k) { //리스트는 배열, k는 뽑아야할 개수
		
		combi(N,k,"");
		
		System.out.println(hash.size());
		
	};
	
	public static void combi(int length, int end, String target) {
		if(end == 0) {
			hash.add(target);
			return;
		}
		
		for(int i = 0; i < length; i++) { //자기 자신을 제외하고 뽑기 방법이 없을까?
			if(visited[i]) continue;
			visited[i] = true;
			combi(length,end-1,target+arr[i]);
			visited[i] = false;
		};
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); //N을 입력받음
		
		int k = Integer.parseInt(br.readLine()); //k를 입력받음
		
		arr = new String[N];
		
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		};
		
		
		solve(N,k);
		
		
		// TODO Auto-generated method stub

	}

}
