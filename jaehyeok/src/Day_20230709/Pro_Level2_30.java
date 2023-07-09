package Day_20230709;

import java.util.*;

class Pro_Level2_30 {
	
    public int[] solution(int n, String[] words) {
        
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>(); //set을 사용해서 중복 체크
        int index = 0;
        int people = 0;
        int num = 0;
        
        set.add(words[0]); //첫번째 중복확인을 위해 set에 집어넣음
        for(int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String current = words[i];
            
            if(!set.contains(current)) { //현재 포인터가 set에 없다면 중복되지 않은 것이므로
                set.add(current); //set에 집어넣음
            }
            else { //현재 포인터가 set에 있다면 중복이므로
                index = i + 1; //인덱스를 저장하고
                break; //break
            }
            
            String last = prev.substring(prev.length()-1);
            String first = current.substring(0,1);
            
            if(!last.equals(first)) {
                index = i + 1;
                break;
            }
        }
        
        if(index == 0) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        people = index % n == 0 ? n : index % n;
        num = (int) Math.ceil((double)index / (double)n);
        
        answer[0] = people;
        answer[1] = num;
        

        return answer;
    }
}