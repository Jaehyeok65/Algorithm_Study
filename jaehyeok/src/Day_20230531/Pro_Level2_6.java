package Day_20230531;

import java.util.*;

public class Pro_Level2_6 {
	
	    public int solution(int[] picks, String[] minerals) {
	        
	        //각 곡괭이는 종류에 상관없이 광물 5개를 캔 후 더 이상 사용할 수 없음
	        
	        //picks는 다이아, 철, 돌 곡괭이 인덱스 순서와 값은 개수
	        
	        int answer = 0;
	        
	        ArrayList<Integer> dialist = new ArrayList<>(); //피로도 배열
	        ArrayList<Integer> irlist = new ArrayList<>(); //피로도 배열
	        ArrayList<Integer> stlist = new ArrayList<>(); //피로도 배열
	        
	        int len = (int)Math.ceil(minerals.length / 5.0);
	        
	        int gok = picks[0]+picks[1]+picks[2];
	        
	            for(int j = 0; j < minerals.length; j = j + 5) {
	                if(gok == 0) break;
	                int diapiro = 0;
	                int irpiro = 0;
	                int stpiro = 0;
	                gok--;
	                for(int k = j; k < j + 5; k++) {
	                    if(k >= minerals.length) {
	                        break;
	                    }
	                    else {
	                        if(minerals[k].equals("diamond")) {
	                            diapiro += 1;
	                            irpiro += 5;
	                            stpiro += 25;
	                        }
	                        else if(minerals[k].equals("iron")) {
	                            diapiro += 1;
	                            irpiro += 1;
	                            stpiro += 5;
	                        }
	                        else {
	                            diapiro += 1;
	                            irpiro += 1;
	                            stpiro += 1;
	                        }
	                    }
	                }
	                dialist.add(diapiro);
	                irlist.add(irpiro);
	                stlist.add(stpiro);
	            }
	        int count = 0;
	        while(picks[0] > 0 || picks[1] > 0 || picks[2] > 0) {
	            if(count == len) {
	                break;
	            }
	            int max = 0;
	            int maxindex = 0;
	            for(int i = 0; i < stlist.size(); i++) {
	                if(max < stlist.get(i)) {
	                    max = stlist.get(i);
	                    maxindex = i;
	                }
	            }
	            if(picks[0] > 0) {
	                answer += dialist.get(maxindex); //다이아리스트에 있던 피로도를 더하고
	                picks[0]--;
	            }
	            else if(picks[1] > 0) {
	                answer += irlist.get(maxindex);
	                picks[1]--;
	            }
	            else if(picks[2] > 0){
	                answer += stlist.get(maxindex);
	                picks[2]--;
	            }
	            else {
	                break;
	            }
	            count++; //공통부분
	            dialist.remove(maxindex);
	            irlist.remove(maxindex);
	            stlist.remove(maxindex);
	        } 
	        return answer;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
