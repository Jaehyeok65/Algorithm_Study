package Day_20230710;

import java.util.*;

class Pro_Level2_31 {
	
    public int solution(String str1, String str2) {
        int answer = 0;
        //자카드 유사도 == J(A,B); == 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값
        
        String s1 = str1.toUpperCase();
        String s2 = str2.toUpperCase();
        
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> andlist;
        ArrayList<String> orlist;
        //범위 == 17부터 42
        for(int i = 1; i < s1.length(); i++) {
            int prev = s1.charAt(i-1);
            int current = s1.charAt(i);
            if((prev - '0' < 17 || prev - '0' > 42) || (current - '0' < 17) || current - '0' > 42) continue; //영어 대문자가 아니라면 continue
            
            String tmp = s1.substring(i-1,i+1);
            list1.add(tmp);
        }
        
            for(int i = 1; i < s2.length(); i++) {
            int prev = s2.charAt(i-1);
            int current = s2.charAt(i);
            if((prev - '0' < 17 || prev - '0' > 42) || (current - '0' < 17) || current - '0' > 42) continue; //영어 대문자가 아니라면 continue
            
            String tmp = s2.substring(i-1,i+1);
            list2.add(tmp);
        }
        
        //집합 분리완료
        
        andlist = andsolution(list1,list2);
        
        orlist = orsolution(list1,list2,andlist);
        
        double andsize = (double)andlist.size();
        double orsize = (double)orlist.size();
        
        double result = (andsize == 0 && orsize == 0) ? 1.0 : (andsize / orsize);
        
        double result2 = Math.floor(result * 65536);
        
        String result3 = String.format("%.0f", result2);
        
        answer = Integer.parseInt(result3);
        
        
        return answer;
    }
    
    static ArrayList<String> andsolution(ArrayList<String> list1, ArrayList<String> list2) {
        
        ArrayList<String> copy1 = new ArrayList<>();
        ArrayList<String> copy2 = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        
        for(int i = 0; i < list1.size(); i++) {
            copy1.add(list1.get(i));
        };
        
        for(int i = 0; i < list2.size(); i++) {
            copy2.add(list2.get(i));
        };
        
        for(int i = 0; i < copy1.size(); i++) {
            String tmp1 = copy1.get(i);
            for(int j = 0; j < copy2.size(); j++) {
                String tmp2 = copy2.get(j);
                if(tmp1.equals(tmp2)) {
                    result.add(tmp1);
                    copy1.remove(i--); //remove를 하면 인덱스가 하나씩 당겨지므로 후위연산자 
                    copy2.remove(j--); //사용함
                    break;
                }
            }
        }

        
        return result;
    }
    
    static ArrayList<String> orsolution(ArrayList<String> list1, ArrayList<String> list2, ArrayList<String> andlist) {
        
        ArrayList<String> orlist = new ArrayList<>();
        ArrayList<String> copyand = new ArrayList<>();
        
        for(int i = 0; i < andlist.size(); i++) {
            copyand.add(andlist.get(i));
        }
        
        for(int i = 0; i < list1.size(); i++) {
            orlist.add(list1.get(i));
        };
        
        for(int i = 0; i < list2.size(); i++) {
            orlist.add(list2.get(i));
        };
        
        for(int i = 0; i < orlist.size(); i++) {
            String tmp1 = orlist.get(i);
            for(int j = 0; j < copyand.size(); j++) {
                String tmp2 = copyand.get(j);
                if(tmp1.equals(tmp2)) {
                    orlist.remove(i--);
                    copyand.remove(j--);
                    break;
                }
            }
        }
        
        return orlist;
    }
}
