package Day_20230717;

import java.util.*;

class Pro_Level3_2 {
    
    static HashSet<HashSet<String>> hash = new HashSet<>();
    static String user[];
    static String ban[];
    
    public int solution(String[] user_id, String[] banned_id) {
        user = user_id;
        ban = banned_id;
        
        dfs(new HashSet<>(),0);
        
        return hash.size();
        
    
    }
    
    
    public void dfs(HashSet<String> set, int depth) {
        if(depth == ban.length) { 
            hash.add(set);
            return;
        }
        
        for(int i = 0; i < user.length; i++) {
            if(set.contains(user[i])) continue;
            
            if(check(ban[depth], user[i])) {
                set.add(user[i]);
                dfs(new HashSet<>(set), depth + 1);
                set.remove(user[i]);
            }
        }
        
        
    }
    
    boolean check(String tmp1, String tmp2) {
        if(tmp1.length() != tmp2.length()) {
            return false;
        }
        
        for(int i = 0; i < tmp1.length(); i++) {
            if(tmp1.charAt(i) != '*' && tmp1.charAt(i) != tmp2.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}
