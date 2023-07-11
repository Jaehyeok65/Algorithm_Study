package Day_20230711;

import java.util.*;

class Pro_Level2_32 {
	
    public ArrayList<Integer> solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        HashMap<String,Integer> map = new HashMap<>();
        
        int last = 27; //사전에 등록하기 위한 포인터 선언
        
        char a = 'A';
        
        for(int i = 1; i <= 26; i++) {
            map.put(String.valueOf(a++),i);
        };
        
        int i = 0;
        
        while(i < msg.length()) {
            
            if(i == msg.length() - 1) { //마지막 문자라면 다음 글자가 없는 것
                answer.add(map.get(msg.substring(i))); //색인을 추가하고 반복문 종료
                break;
            }
            
            //마지막 문자가 아니라면
            
            String current = msg.substring(i,i+1); //현재 문자를 가져온후
            i++; //i를 1증가시킴
            while(true) { //현재 문자에서 계속 붙여가면서 사전에 있는지 확인한다.
                if(i >= msg.length()) break; //에러핸들링
                
                String next = msg.substring(i,i+1); //다음 문자를 가져와서
                if(map.containsKey(current + next)) { //둘을 붙인게 사전에 있다면
                    current = current + next; //현재 문자열을 갱신한 후
                    i++; //포인터를 증가시킨다.
                }
                else { //사전에 없다면
                    map.put(current + next,last++); //사전에 등록한 후
                    break;
                }
            }
            
            //반복문을 나왔다면 current가 갱신되어있을 것
            answer.add(map.get(current)); //즉 answer에 current의 색인을 추가한다
        
        }
        
       
        
        
        
        
        return answer;
    }
}



