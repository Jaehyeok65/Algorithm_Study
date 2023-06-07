package Day_20230607;

import java.util.*;

class Pro_Level2_10 {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]); //적을 차례대로 큐에다가 집어넣음
            
            if(pq.size() > k) { //큐의 사이즈가 무적권 사용횟수보다 커진다면 무적권 사용
                n -= pq.poll();
            }
            
            if(n < 0) {
                return i;
            }
        }
        
        return enemy.length;
    }
}