package Day_20230202;


import java.util.*;
import java.io.*;



public class Back_1874 {
	
	static int N; //1부터 N까지의 수가 주어짐
	static ArrayList<Integer> list = new ArrayList<>();
	static Stack<Integer> stack = new Stack<>(); //스택을 만듬
	static StringBuilder sb = new StringBuilder();
	static int current = 1; //현재 수열의 값
	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			list.add(Integer.parseInt(br.readLine())); //N개의 수열을 입력받아서 리스트에 추가함.
		};
		
		for(int i : list) {
			
			while(current <= i) { //현재 수열의 값이 i보다 작다면
				stack.push(current);
				sb.append("+\n"); //+를 빌더에 넣음
				current++; //넣은 후 현재 값을 증가 시킴
			}
			
			if(current == i) { //현재 수열의 값과 i(나열해야 할 수열의 값)가 같다면
				stack.pop(); //스택에서 pop을 수행 한 후
				sb.append("-\n"); //-를 빌더에 넣음
				continue; //pop을 수행했으므로 continue를 하여 아래 로직 무시
			}
			if(stack.peek() != i) { //스택에 맨 상단 값과 다음에 나열해야 할 수열의 값이 다르다면 나열이 불가하므로 No 출력 후 시스템 종료
				System.out.print("NO");
				System.exit(0);
			}
			else { //스택에 맨 상단 값과 다음에 나열해야 할 수열의 값이 같다면
				stack.pop();
				sb.append("-\n");
			}
		}
		
		System.out.print(sb.toString());
		
		// TODO Auto-generated method stub

	}

}
