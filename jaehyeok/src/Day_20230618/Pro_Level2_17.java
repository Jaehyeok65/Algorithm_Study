package Day_20230618;

import java.util.*;

class Pro_Level2_17 {
    
    static boolean isGood(String s) {
        if(s.length() % 2 == 1) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i,i+1);
            if(isLeft(tmp)) { //문자열이 왼쪽 괄호라면
                stack.push(tmp); //스택에 집어넣음
            }
            else { //문자열이 오른쪽 괄호라면 왼쪽과 매치되는지 확인
                if(!stack.isEmpty()) { //스택이 비어있지 않으면
                    String tmp1 = stack.peek();
                    if(!isRight(tmp1,tmp)) { //tmp와 tmp1이 다르다면 false리턴
                        return false;
                    }
                    stack.pop(); //같다면 pop을 해서 다음 괄호 비교
                }
                else { //오른쪽 괄호 차례에서 왼쪽이 스택에 비어있다면
                    return false;
                }
            }
        }
        
        return true; //다음을 모두 만족하면 올바른 괄호 문자열
    }
    
    static boolean isLeft(String s) {
        if(s.equals("(") || s.equals("[") || s.equals("{")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    static boolean isRight(String s1, String s2) {
        if(s1.equals("(")) {
            if(s2.equals(")")) {
                return true;
            }
        }
        else if(s1.equals("{")) {
            if(s2.equals("}")) {
                return true;
            }
        }
        else if(s1.equals("[")) {
            if(s2.equals("]")) {
                return true;
            }
        }
        
        return false;
    }
    
    static String isRotate(String s, int i) { //왼쪽으로 i만큼 회전을 시킨 후 리턴
        char[] newString = s.toCharArray();
        
        for(int j = 0; j < i; j++) {
            char c = newString[0]; //덮어씌워지면 안되므로 변수에 보존
            for(int k = 0; k < s.length(); k++) {
                if(k == s.length() - 1) { //마지막 인덱스라면
                    newString[k] = c;
                }
                else {
                    newString[k] = newString[k+1];
                }
            }
        }
        
        String result = new String(newString);
        return result;
    }
    
    
    public int solution(String s) {
        
        int answer = 0;
        int cnt = s.length() - 1;
        for(int i = 0; i < cnt; i++) { //회전은 length - 1만큼 시킴
            String tmp = isRotate(s,i);
            if(isGood(tmp)) {
                answer++;
            }
        }
        return answer;
    }
}