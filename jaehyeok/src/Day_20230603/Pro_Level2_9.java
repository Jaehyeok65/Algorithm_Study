package Day_20230603;

class Pro_Level2_9 {
    
    
    public int solution(int storey) {
        
        String st = String.valueOf(storey);
        char[] ch = st.toCharArray();
        int ans = 0;
        
        for(int i = ch.length - 1; i >= 0; i--) {
            
            if(ch[i] - '0' > 5) { //5보다 크다면 10의자리수로 올라가는게 이득임
                ans += (10 - (ch[i] - '0'));
                if(i == 0) ans++; //예외처리를 해줘야함
                else {
                    ch[i-1]++;
                }
            }
            else if(ch[i] - '0' == 5) {
                if(i > 0 && ch[i-1] - '0' >= 5) {
                    ans += (10 - (ch[i] - '0'));
                    ch[i-1]++;
                }
                else {
                    ans += ch[i] - '0';
                }
            }
            else {
                ans += ch[i] - '0';
            }
        }
        
        return ans;
    }
}