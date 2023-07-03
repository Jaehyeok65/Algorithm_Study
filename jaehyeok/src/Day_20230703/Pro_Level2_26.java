package Day_20230703;

class Pro_Level2_26 {
    public static String solution(String s) {
        String answer = "";
        
        String tmp[] = s.split(" ");
        
        System.out.println(tmp.length);
        
        for(int i = 0; i < tmp.length; i++) {
            String tmp1 = ""; //문자열을 담을 임시변수 초기화
            for(int j = 0; j < tmp[i].length(); j++) {
                int target = tmp[i].charAt(j) - '0';
                if(j == 0) { //j가 0이라면 첫문자 == 즉 대 문자
                    if(target >= 49 && target <= 74) { //알파벳 소문자라면 대문자로 바꿈
                        tmp1 += tmp[i].substring(j,j+1).toUpperCase();
                    }
                    else { //알파벳 소문자가 아니라면 그대로 씀
                        tmp1 += tmp[i].substring(j,j+1);
                    }
                }
                else { //j가 0이 아니라면 첫문자가 아님 == 즉 소문자
                    if(!(target >= 49 && target <= 74)) { //알파벳 소문자가 아니라면
                        tmp1 += tmp[i].substring(j,j+1).toLowerCase();
                    }
                    else { //알파벳 소문자라면 그대로 씀
                        tmp1 += tmp[i].substring(j,j+1);
                    }
                }
            }
        
            if(i == tmp.length - 1) { //마지막 문자라면 공백을 추가하지 않음
            	System.out.println(tmp[i]);
                answer += tmp1;
            }
            else { //마지막 문자가 아니라면 공백을 추가
                answer += tmp1 + " ";
            }
        }
        
        if(s.substring(s.length()-1).equals(" ")) { //마지막 문자가 공백일 경우도 포함해야함
        	answer += " ";
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	
    	String s = solution("Abc EFG ED");
    	
    	System.out.print(s);
		// TODO Auto-generated method stub

	}
}