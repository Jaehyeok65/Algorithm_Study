package Day_20230624;

import java.util.*;

class Pro_Level2_20 {
    
    static int answer = 0;
    
    static void dfs(int [][] dungeons, boolean visited[], int index, int k, int count)      {
        // 던전을 루프 돌면서  최소 피로도 소모 피로도를 비교
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || k - dungeons[i][0] < 0) {
                //루프를 돌면서 방문했거나 최소 방문 피로도가 안되면 continue
                continue;
            }
            visited[i] = true;
            dfs(dungeons, visited, i, k - dungeons[i][1], count + 1);
            visited[i] = false;
        }
        //모든 지점을 다 돌아 for문이 종료되면 answer 갱신
        answer = Math.max(answer, count);
        

    }
    
    
    public int solution(int k, int[][] dungeons) {
        boolean visited[] = new boolean[dungeons.length]; // 던전의 개수만큼 배열 생성
        
        for(int i = 0; i < dungeons.length; i++) { //각 인덱스로 부터 dfs 시작해야함
            dfs(dungeons, visited, i, k, 0);
        }
        
        return answer;
        
    }
}