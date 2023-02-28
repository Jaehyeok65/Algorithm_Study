package Day_20230228;


import java.util.*;
import java.io.*;



public class Baek_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
		
		ArrayList<Integer> distance = new ArrayList<>(); //요소 간의 거리 차이를 담을 리스트 선언
		
		while(st.hasMoreTokens()) {//입력받은 수를 리스트에 추가
			list.add(Integer.parseInt(st.nextToken()));
		};
		
		Collections.sort(list); // 거리합의 최소값을 구해야 하므로 오름차순으로 정렬함.
		
		for(int i = 1; i < list.size(); i++) { //정렬된 요소들의 거리 차이를 distance 리스트에 추가함.
			distance.add(list.get(i) - list.get(i-1));
		};
		
		if(K >= N) { //기지국이 센서의 개수보다 같거나 크다면 거리합은 0(각 기지국이 센서를 커버할 수 있으므로)
			System.out.print(0);
		}
		else { //기지국의 개수가 센서의 개수보다 작다면 최소 거리합을 구해야함
			Collections.sort(distance); //마찬가지로 거리차이도 오름차순으로 정렬함
			int result = 0; //결과를 출력할 변수를 0으로 초기화
			for(int i = 0; i < (distance.size()-(K-1)); i++) { //기지국의 개수만큼 센서를 커버할 수 있으므로
				result += distance.get(i);
			};
			System.out.print(result);
		}
	
		// TODO Auto-generated method stub

	}

}
