package Day_20230506;

import java.util.*;
import java.io.*;

public class Pro_Level2_1 {
	
	
	
	
	static void solution(int [][] target) {
		
		int answer = 0;
		
		Arrays.sort(target, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			}
			return o1[1] - o2[1];
		}); //마지막 좌표 오름차순으로 정렬
		
		int end = target[0][1];
		answer++;
		
		for(int [] s : target) {
			if(s[0] >= end) {
				end = s[1];
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	

	public static void main(String[] args) {
		
		int arr[][] = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		solution(arr);
		// TODO Auto-generated method stub

	}

}
