package Day_20230630;

import java.util.*;

class Pro_Level2_25 {
    
    
    static String divide(String p) {
        
        if(p.length() == 0) {
            return p;
        }
        
        String[] tmp = second(p); //2번째 작업을 함
        
        String u = tmp[0];
        String v = tmp[1];
        
        if(isTrue(u)) { //올바른 문자열이라면
            return u + divide(v);
        }
        else {
            String tmp1 = "";
            tmp1 += "(";
            tmp1 += divide(v);
            tmp1 += ")";
            u = u.substring(1,u.length()-1);
            
            for(int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') {
                    tmp1 += ")";
                }
                else {
                    tmp1 += "(";
                }
            }
            
            return tmp1;
        }
        
        
        
    }
    
    static String[] second(String p) { //입력을 균형잡힌 두 문자열로 분리함
        
        int f = 0;
        int s = 0;
        int index = 0;
        for(int i = 0; i < p.length(); i++) {
            String tmp = p.substring(i,i+1);
            if(tmp.equals("(")) {
                f++;
            }
            else if(tmp.equals(")")) {
                s++;
            }
            if(f == s) {
                index = i;
                break;
            }
        }
        
        String[] result = {p.substring(0,index+1),p.substring(index+1)};
        
        return result;
    }
    
    static boolean isTrue(String p) { //올바른 괄호 문자열이라면 true리턴
        Stack<String> stack = new Stack<>(); //
        
        for(int i = 0; i < p.length(); i++) {
            String tmp = p.substring(i,i+1);
            if(tmp.equals("(")) {
                stack.push(tmp);
            }
            else { //tmp는 )
                if(!stack.isEmpty()) { //스택이 비어있지 않다면
                    stack.pop();
                }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    static String sol(String p) {
        if(isTrue(p)) {
            return p;
        }
        else {
            return divide(p);
        }
    }
    

    public String solution(String p) {
        String answer = "";
        answer = sol(p);
        return answer;
    }
}