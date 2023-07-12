package Day_20230712;

import java.util.*;

class Pro_Level2_33 {
	
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length - 1; i++){
            String current = phone_book[i];
            String next = phone_book[i+1];
            
            if(current.length() > next.length()) {
                continue;
            }
            
            if(current.equals(next.substring(0,current.length()))) {
                return false;
            }
        }
        
        return true;
    }
}