package Siver3;

import java.util.LinkedList;
import java.util.Queue;

public class Test11 {
	
	public static int[][] map;
	
	public static void main(String[] args) {
		int rows=6;
		int columns=6;
		int[][] queries;
		
		 int[] answer = {};
	        
	        map = new int[rows+1][columns+1];
	        
	        for(int i=1; i<=rows; i++){
	            for(int j=1; j<=columns; j++){
	                map[i][j] = (i-1) * columns  + j;
	            }
	        }
	        
	        // for(int i=0; i<queries.length; i++){
	        //     tona(queries[i]);
	        // }
	        
	        int[] test = {2,2,5,4};
	        tona(test);
	        
	         
	        for(int i=1; i<=rows; i++){
	            for(int j=1; j<=columns; j++){
	                System.out.print(map[i][j]);
	            }
	            System.out.println("");
	        }
	        
	}
	 public static void tona(int[] qu){
	        int a = qu[0];
	        int b = qu[1];
	        int c = qu[2];
	        int d = qu[3];
	        Queue<Integer> q = new LinkedList<>();
	        
	        q.add(map[a][b]);
	        // i=a
	        for(int j=b; j<d; j++){
	            q.add(map[a][j+1]);
	            map[a][j+1] = q.poll();
	        }
	        // j=d
	        for(int i=a; i<c; i++){
	            q.add(map[i+1][d]);
	            map[i+1][d] = q.poll();
	        }
	        System.out.println(q.peek());
	        // i=c
	        for(int j=d; j>b; j--){
	            q.add(map[c][j-1]);
	            map[c][j-1] = q.poll();
	        }
	        System.out.println(map[5][4]);
	        System.out.println(map[5][3]);
	        System.out.println(map[5][2]);
	        // j=b
	        for(int i=c; i>a; i--){
	            q.add(map[i-1][b]);
	            map[i-1][b] = q.poll();
	        }
	        
	    }
}
