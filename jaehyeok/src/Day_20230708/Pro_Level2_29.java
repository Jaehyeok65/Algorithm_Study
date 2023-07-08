package Day_20230708;

import java.util.*;

class Pro_Level2_29 {
	
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize == 0) {
            return 5 * cities.length;
        }
        
        Queue<String> que = new LinkedList<>();
        
        
        for(int i = 0; i < cities.length; i++) {
            String tmp = cities[i].toUpperCase();
            
            if(que.contains(tmp)) { //큐에 들어있다면 == 캐시 hit
                answer += 1;
                que.remove(tmp);
            }
            else { //큐에 들어있지 않다면 == 캐시 miss
                answer += 5;
                
                if(que.size() >= cacheSize) {
                    que.poll();
                }
            }
            
            que.add(tmp);
            
        }
        return answer;
    }
}