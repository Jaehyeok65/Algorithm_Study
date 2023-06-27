package Day_20230627;

public class Pro_Level2_22 {
	
	static int divide(String s, int n) { //문자열을 입력받아 압축한 후 길이를 리턴
        
        String result = ""; //결과를 리턴할 변수
        String tmp = s.substring(0,n); //압축할 타겟
        int count = 1; //압축한 숫자
        
        for(int i = n; i <= s.length(); i += n) {
            int index = Math.min(i+n, s.length()); //문자열 범위를 넘어가면 안되므로
            String tmp2 = s.substring(i, index);
            if(tmp.equals(tmp2)) { //압축한 문자가 같다면
                count++; //카운트를 증가
            }
            else { //압축한 문자가 다르다면
                if(count == 1) {
                    result = result + tmp;
                }
                else {
                    result = result + count + tmp;
                }
                tmp = tmp2;
                count = 1;
            }
        }
        
        result = result + tmp;
        
        
        return result.length();
    }
    static int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length()/2; i++) {
            
            answer = Math.min(divide(s,i),answer);
        }
        
        return answer;
    }

}


