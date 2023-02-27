package Siver3;

import java.util.Scanner;

public class Test11 {
	// 우하좌상
	 	static int[] dx = {0,1,0,-1};
	    static int[] dy = {1,0,-1,0};
	    public static boolean[][] visited;
	    public static int[][] map;
	    public static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[][] boards = {{"00111","00111","21001","11001","11111"},{"00000","00100","01210","00100","00000"}};
		 int[] answer = new int[boards.length];
	        
	        int test_case = boards.length;
	        for(int tc=0; tc<test_case; tc++){
	            answer[tc] = 1;
	            n = boards[tc].length;
	            visited = new boolean[n][n];
	            map = new int[n][n];

	            for(int i=0; i<n; i++){
	                for(int j=0; j<n; j++){
	                    map[i][j] = boards[tc][i].charAt(j) - '0';
	                    if(map[i][j] == 0){
	                        visited[i][j] = true;
	                    }
	                }
	            }

	            for(int i=0; i<n; i++){
	                for(int j=0; j<n; j++){
	                    if(map[i][j] == 2){
	                        dfs(i,j);
	                    }
	                }
	            }

	            for(int i=0; i<n; i++){
	                for(int j=0; j<n; j++){
	                   if(visited[i][j] == false){
	                       answer[tc] = 0;
	                   } 
	                }
	            }

	            for(int i=0; i<n; i++){
	                for(int j=0; j<n; j++){
	                   System.out.print(visited[i][j]);
	                }
	                System.out.println("");
	            }
	            System.out.println("");
	        }
	       
	}
	
	public static void dfs(int a, int b){
        visited[a][b] = true;
        int cnt =0;
        for(int k=0; k<4; k++){
            int nextX = a + dx[k];
            int nextY = b + dy[k];
            if(nextX <0 || nextY <0 || nextX >= n || nextY >= n){
            	cnt++;
                continue;
            }
            if(visited[nextX][nextY]){
                cnt++;
                if(cnt == 4) {
                	visited[a][b] = false;
                }
                continue;
            }
            System.out.println(a + " " + b);
            dfs(nextX,nextY);
        }
    }
}
