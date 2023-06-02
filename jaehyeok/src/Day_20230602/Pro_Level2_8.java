package Day_20230602;

import java.util.*;

class Pro_Level2_8 {
    
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1}; //상하좌우
    static char map[][];
    static boolean visited[][];
    static int levery = 0;
    static int leverx = 0; //레버위치
    static int ylen = 0;
    static int xlen = 0;
    
    
    public int solution(String[] maps) {
        
        ylen = maps.length;
        xlen = maps[0].length();
        
        map = new char[ylen][xlen];
        visited = new boolean[ylen][xlen];
        
        int result1 = 0;
        int result2 = 0;
        int answer = 0;
        
        for(int i = 0; i < ylen; i++) {
            for(int j = 0; j < xlen; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i = 0; i < ylen; i++) {
            for(int j = 0; j < xlen; j++) {
                if(map[i][j] == 'S') {
                    result1 = start(i,j);
                }
            }
        }
        
        visited = new boolean[ylen][xlen];
        
        if(result1 > 0) {
            result2 = finish(levery,leverx);
            if(result2 > 0) {
                answer = result1 + result2;
            }
            else {
                answer = -1;
            }
        }
        else {
            answer = -1;
        }
       
        
        return answer;
    }
    
    static int start(int y, int x) {
        int count = 0;
        boolean flag = false;
        Queue<Node> que = new LinkedList<>();
        
        que.add(new Node(y,x,0));
        
        visited[y][x] = true; //방문
        
        while(!que.isEmpty()) {
            
            Node n = que.poll(); //꺼낸 후
            
            if(map[n.y][n.x] == 'L') { //레버라면
                levery = n.y;
                leverx = n.x;
                count = n.count;
                flag = true;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextY = n.y + dy[i];
                int nextX = n.x + dx[i];
                
                if(nextY < 0 || nextX < 0 || nextY >= ylen || nextX >= xlen ) continue;
                
                if(visited[nextY][nextX] || map[nextY][nextX] == 'X') continue;
                
                que.add(new Node(nextY,nextX, n.count + 1));
                visited[nextY][nextX] = true;
            }
        }
        
        if(flag) {
            return count;
        }
        else {
            return -1;
        }
    }
    
    static int finish(int y, int x) {
        int count = 0;
        boolean flag = false;
        Queue<Node> que = new LinkedList<>();
        
        que.add(new Node(y,x,0));
        
        visited[y][x] = true; //방문
        
        while(!que.isEmpty()) {
            
            Node n = que.poll(); //꺼낸 후
        
            if(map[n.y][n.x] == 'E') { //도착지점이라면
                count = n.count;
                flag = true;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int nextY = n.y + dy[i];
                int nextX = n.x + dx[i];
                
                if(nextY < 0 || nextX < 0 || nextY >= ylen || nextX >= xlen ) continue;
                
                if(visited[nextY][nextX] || map[nextY][nextX] == 'X') continue;
                
                que.add(new Node(nextY,nextX, n.count + 1));
                visited[nextY][nextX] = true;
            }
        }
        
        if(flag) {
            return count;
        }
        else {
            return -1;
        }
    }
    
  
}

class Node {
    int y;
    int x;
    int count;
    
    public Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}