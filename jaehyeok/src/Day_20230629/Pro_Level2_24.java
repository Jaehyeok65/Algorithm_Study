package Day_20230629;

import java.util.*;

class Pro_Level2_24 {
    
    static long answer = Long.MIN_VALUE;
    static ArrayList<String> list = new ArrayList<>();
    static String[][] oper = {{"*","-","+"},{"*","+","-"},{"+","*","-"},{"+","-","*"},{"-","*","+"},{"-","+","*"}}; //연산자 우선순위 경우의 수
    
    static void sol() {
        
        for(int i = 0; i < oper.length; i++) { //연산자 우선순위를 다 돌려야 하므로
            ArrayList<String> copy = new ArrayList<>(list); //배열을 조작하기위한 카피
            
            for(int j = 0; j < 3; j++) { //배열에서 각각의 연산자를 가져오기 위한 인덱스
                
                for(int k = 0; k < copy.size(); k++) {
                    String tmp = copy.get(k);
                    if(tmp.equals(oper[i][j])) {
                        copy.set(k - 1, cal(copy.get(k - 1), copy.get(k), copy.get(k + 1)));
                        copy.remove(k);
                        copy.remove(k);
                        k--;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(Long.parseLong(copy.get(0))));
            
        }
        
    }
    
    static String cal(String tmp1, String tmp2, String oper) {
        
        long l1 = Long.parseLong(tmp1);
        long l2 = Long.parseLong(tmp2);
        String result = "";
        if(oper.equals("*")) {
            result = l1 * l2 + "";
        }
        else if(oper.equals("-")) {
            result = l1 - l2 + "";
        }
        else if(oper.equals("+")) {
            result = l1 + l2 + "";
        }
        
        return result;
        
    }
    
    
    
    
    
    
    public long solution(String expression) {
        
        String ans = "";
        
        for(int i = 0; i < expression.length(); i++) {
            String tmp = expression.substring(i,i+1);
            if(tmp.equals("*") || tmp.equals("+") || tmp.equals("-")) {
                list.add(ans);
                list.add(tmp);
                ans = "";
            }
            else {
                ans += tmp;
            }
        }
        list.add(ans);
        
        sol();
        
        return answer;
    }
}