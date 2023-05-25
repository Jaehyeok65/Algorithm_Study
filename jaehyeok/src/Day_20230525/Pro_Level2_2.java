package Day_20230525;

import java.util.*;


public class Pro_Level2_2 {
	//i번째 집은 물류창고에서 i만큼 떨어져있으며
	//또한 i번째 집은 j번째 집과 j - i 만큼 떨어져있음
	//최소 이동거리 == 그리디 알고리즘 or 정렬
	static int cap; //트럭에 최대로 실을 수 있는 물류택배 개수
	static int n;
	static int del[] = {1,0,2,0,1,0,2};
	static int pick[] = {0,2,0,1,0,2,0};
	

	public static void main(String[] args) {
		
		cap = 2;
		n = 7; //집의 개수
		long answer = 0;
		int currentdel = 0;
		int currentpick = 0;
		
		for(int i = n-1; i >= 0; i--) {
			if(del[i] > 0 || pick[i] > 0) { //둘 중 하나라도 있다면 이 집까지 와야하므로
					int tmp1 = i;
					while(true) {
						if(tmp1 < 0) {
							break;
						}
						if(currentdel + del[tmp1] > cap) { //현재 개수와 담을 개수가 최대 적재량보다 크다면 break
							if(currentdel < cap) { //현재 적재한 물품이 최대보다 작다면 더 담을 수 있으므로
								del[tmp1] -= cap - currentdel;
							}
							break;
						}
						currentdel += del[tmp1];
						del[tmp1] = 0;
						tmp1--;
					}
					currentdel = 0; //다시 0으로 초기화
				
					int tmp2 = i;
					while(true) {
						if(tmp2 < 0) {
							break;
						}
						if(currentpick + pick[tmp2] > cap) {
							if(currentpick < cap) { //현재 적재한 물품이 최대보다 작다면 더 담을 수 있으므로
								pick[tmp2] -= cap - currentpick;
							}
							break;
						}
						currentpick += pick[tmp2];
						pick[tmp2] = 0;
						tmp2--;
					}
					currentpick = 0; //다시 0으로 초기화
				
				answer += (i+1) * 2;
				
			}
		}
		
		System.out.print(answer);
		
		
		
		
		
		// TODO Auto-generated method stub

	}

}
