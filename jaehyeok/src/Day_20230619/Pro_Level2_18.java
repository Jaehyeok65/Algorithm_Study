package Day_20230619;

import java.util.*;

class Pro_Level2_18 {
    
    static ArrayList<String> list = new ArrayList<>();
    
    static String words[] = {"A", "E" , "I", "O", "U"};
    
    public int solution(String word) {
        int answer = 0;
     
        dfs("",0);
        
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    
    static void dfs(String word, int depth) {
        if(depth > 5) {
            return;
        }
        
        list.add(word);
        
        for(int i = 0; i < words.length; i++) {
            dfs(word + words[i], depth + 1);
        }
    }
        
        
        
    }

