package Day_20230526;

import java.util.*;


public class Pro_Level2_3 {
	
	    static int hourToint(String hour) {
	        String[] spl = hour.split(":");
	        int first = Integer.parseInt(spl[0]);
	        int second = Integer.parseInt(spl[1]);
	        return first * 60 + second;
	    }
	    
	    public List<String> solution(String[][] plans) {
	        
	        Stack<plan> stack = new Stack<>(); //멈춘과제
	        ArrayList<String> finish = new ArrayList<>(); //끝난 과제
	        
	        Arrays.sort(plans, (o1,o2) -> {
	            return o1[1].compareTo(o2[1]);
	        }); //일단 시작시간 순으로 정렬 수행
	        
	        for(int i = 0; i < plans.length - 1; i++) {
	            int prevstart = hourToint(plans[i][1]) + Integer.parseInt(plans[i][2]);
	            int nextstart = hourToint(plans[i+1][1]);
	            
	            if(prevstart <= nextstart) { //정상적으로 마칠 수 있을 경우
	                finish.add(plans[i][0]); //과제를 끝냈으므로 finish에 추가
	                
	                int time = nextstart - prevstart; //과제를 끝내고 남은 시간
	                
	                while(time > 0 && stack.size() > 0) { //중간에 멈춘 과제 수행
	                    int del = stack.peek().time - time;
	                    stack.peek().time = Math.max(0, del);
	                    if(del <= 0) {
	                        time = -1 * del;
	                        finish.add(stack.pop().name);
	                    }else{
	                        time = 0;
	                    }
	                }
	            }
	            else { //정상적으로 마칠 수 없는 경우
	                int remaintime = prevstart - nextstart; //과제를 최대한 수행하고 남은 시간
	                stack.push(new plan(plans[i][0], remaintime)); //남은 과제를 스택에 추가
	            }
	        }
	        
	        finish.add(plans[plans.length-1][0]);
	        
	        while(stack.size() > 0) { //아직 못한 과제가 남아있는 경우
	            finish.add(stack.pop().name); //제한시간이 없으므로 차례대로 수행함
	        }
	        
	        return finish;
	    }
	    
	

	class plan {
	    String name;
	    int time;
	    
	    public plan(String name, int time) {
	        this.name = name;
	        this.time = time;
	    }
	}
}
