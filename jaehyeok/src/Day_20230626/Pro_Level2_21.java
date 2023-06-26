package Day_20230626;

import java.util.*;

class Pro_Level2_21 {
    
    static boolean visited[];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    
    static void dfs(int node, int prev, int next) { //
        
        visited[node] = true; //해당 노드를 방문표시
        
        for(int i : list.get(node)) { //리스트에서 전선을 꺼내서
            if((node == prev && i == next) || (node == next && i == prev)) continue; //제거한 전선이라면 conitnue
            if(!visited[i]) { //방문하지 않았다면
                dfs(i,prev,next);
            }
        }
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }; //각 노드들에 리스트를 생성
        
        for(int node[] : wires) {
            int prev = node[0]; //이전 노드
            int next = node[1]; //다음 노드
            list.get(prev).add(next);
            list.get(next).add(prev);
        }; //그래프 형태로 연결 완료
        
        for(int node[] : wires) {
            int prev = node[0];
            int next = node[1]; //전선의 위치
            
            visited = new boolean[n+1]; //방문한 송전탑을 찾기 위해 방문해야하기 때문
            
            dfs(1, prev, next); //전선을 하나 제거하고 dfs 수행
            int cnt = 0;
            for(int i = 1; i < visited.length; i++) { //dfs를 수행하여 방문한 송전탑을 구함
                if(visited[i]) cnt++;
            }
            
            int tmp = (int)Math.abs(cnt - (n-cnt));
            
            answer = Math.min(answer, tmp);
        }
        
        
        return answer;
    }
}