package Day_20230611;

import java.util.*;

class Pro_Level2_12 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            int tmp = map.getOrDefault(tangerine[i] , 0);
            if(tmp == 0) { //tmp가 키가 없음
                map.put(tangerine[i], 1);
            }
            else {
                map.put(tangerine[i], tmp + 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        int tmp = 0;
        for(int i : list) {
            answer++;
            tmp += i;
            if(tmp >= k) {
                break;
            }
        }
        return answer;
    }
}