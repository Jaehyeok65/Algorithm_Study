package Day_20230705;

import java.util.*;

public class Pro_Level2_27 {
	
	
    boolean solution(String s) {
        boolean answer = true;
        boolean flag = false;
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i,i+1);
            if(tmp.equals("(")) {
                stack.push(tmp);
            }
            else if(tmp.equals(")")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    flag = true;
                    break;
                }
            }
        }
        
        if(!stack.isEmpty() || flag) {
            answer = false;
        }

        return answer;
    }
}