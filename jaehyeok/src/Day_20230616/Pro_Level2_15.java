package Day_20230616;

import java.util.*;

class Pro_Level2_15 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < discount.length-9; i++) {
            HashMap<String, Integer> map = new HashMap<>(); //개수와 이름
            for(int j = i; j < i + 10; j++) {
                if(map.containsKey(discount[j])) {
                    map.put(discount[j], map.get(discount[j]) + 1);
                }
                else {
                    map.put(discount[j], 1);
                }
            }
            boolean flag = true;
            for(int j = 0; j < want.length; j++) {
                if(map.containsKey(want[j])) {
                    if(map.get(want[j]) != number[j]) {
                        flag = false;
                        break;
                    }
                }
                else {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                answer++;
            }
        }
        return answer;
    }
}