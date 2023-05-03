package Day_20230503;

import java.util.*;

public class Baek14499 {
	
	static int n,m,x,y,k;
	static int[][] map;
	static Map<String, Integer> dice = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dice.put("front", 0);
		dice.put("top", 0);
		dice.put("back", 0);
		dice.put("bot", map[x][y]);
		dice.put("west", 0);
		dice.put("east", 0);
		int[] answer = new int[k];
		for(int i=0; i<k; i++) {
			int order = sc.nextInt();
			answer[i] = command(order);
		}
		
		for(int i=0; i<k; i++) {
			if(answer[i] != -1) {
				System.out.println(answer[i]);
			}
		}
	}
	
	public static int command(int order) {
		int front = dice.get("front");
		int top = dice.get("top");
		int back = dice.get("back");
		int bot = dice.get("bot");
		int west = dice.get("west");
		int east = dice.get("east");
		
		if(order == 1) { // 동쪽
			y = y + 1;
			if(y<0 || y>=m) {
				y = y - 1;
				return -1;
			}

			dice.put("top", east);
			dice.put("bot", west);
			dice.put("west", top);
			dice.put("east", bot);
			
		}
		if(order == 2) { // 서쪽
			y = y - 1;
			if(y<0 || y>=m) {
				y = y + 1;
				return -1;
			}
			dice.put("top", west);
			dice.put("bot", east);
			dice.put("west", bot);
			dice.put("east", top);
			
		}
		if(order == 3) { // 북쪽
			x = x - 1;
			if(x<0 || x >= n) {
				x = x + 1;
				return -1;
			}
			dice.put("front", top);
			dice.put("top", back);
			dice.put("back", bot);
			dice.put("bot", front);
			
		}
		if(order == 4) { // 남쪽
			x = x + 1;
			if(x<0 || x >= n) {
				x = x - 1;
				return -1;
			}
			dice.put("front", bot);
			dice.put("top", front);
			dice.put("back", top);
			dice.put("bot", back);
			
		}
		if(map[x][y] == 0) {
			map[x][y] = dice.get("bot");
		} else {
			dice.put("bot", map[x][y]);
			map[x][y] = 0;
		}
		return dice.get("top");
	}
}
