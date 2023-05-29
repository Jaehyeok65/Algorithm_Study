package Day_20230529;

import java.util.LinkedList;
import java.util.Queue;

public class Pro_Level2_5 {
	
	 public static int solution(int[] queue1, int[] queue2) {
	        
	        int answer = 0;
	        
	        Queue<Integer> que1 = new LinkedList<>();
	        Queue<Integer> que2 = new LinkedList<>();
	        long que1sum = 0;
	        long que2sum = 0;
	        
	        for(int i = 0; i < queue1.length; i++) {
	            que1.add(queue1[i]);
	            que2.add(queue2[i]);
	            que1sum += queue1[i];
	            que2sum += queue2[i];
	        }; //리스트에 배열을 담으며 두 배열의 합계를 변수에 저장함
	        
	        long target = (que1sum + que2sum);
	        if(target % 2 == 1) return -1;
	        
	        while(true) {
	            if(que1sum == que2sum) {
	                break;
	            }
	            else if(answer > (que1.size() + que2.size()) * 2) {
	                return -1;
	            } //종료 조건 생성
	            
	            if(que1sum > que2sum) { //que1이 더 크다면 균형을 맞춰야하기 때문에 que2로 삽입
	                que1sum -= que1.peek();
	                que2sum += que1.peek();
	                que2.add(que1.poll());
	            }
	            else if(que1sum < que2sum) {
	                que2sum -= que2.peek();
	                que1sum += que2.peek();
	                que1.add(que2.poll());
	            }
	            
	            answer++;
	            
	        }
	        
	        return answer;
	    }
	
	public static void main(String[] args) {
		
		int arr1[] = {1,2,1,2};
		int arr2[] = {1,10,1,2};
		
		int result = solution(arr1,arr2);
		
		System.out.println(result);
		// TODO Auto-generated method stub

	}
}



