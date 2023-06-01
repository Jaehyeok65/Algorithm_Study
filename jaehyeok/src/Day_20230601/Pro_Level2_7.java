package Day_20230601;

import java.util.*;

public class Pro_Level2_7 {
	
	static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    static int ans = 0;
    
    static ArrayList<Integer> solution(String[] maps) {
    
        String map[][] = new String[maps.length][maps[0].length()]; //2차원배열 생성
        boolean visited[][] = new boolean[maps.length][maps[0].length()];
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].substring(j,j+1);
            }
        } //주어진 문제를 2차원 배열로 생성
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(!map[i][j].equals("X") && !visited[i][j]) { //식량이 있다면
                    ans = 0; //다음 루프를 위해 0으로 초기화
                    dfs(i,j, map, visited); //dfs 수행
                    list.add(ans);
                }
            }
        }
        
        if(list.size() > 0) {
            Collections.sort(list);
        }
        else {
            list.add(-1);
        }
        return list;
        
    }
    
    static void dfs(int y, int x, String[][] map, boolean[][] visited) {
        visited[y][x] = true; //방문표시
        
        ans += Integer.parseInt(map[y][x]);
        
        for(int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            
            if(nextY < 0 || nextX < 0 || nextY >= visited.length || nextX >= visited[0].length) continue;
            
            if(map[nextY][nextX].equals("X") || visited[nextY][nextX]) continue;
            
            dfs(nextY, nextX , map, visited);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
