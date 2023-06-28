package Day_20230628;

import java.util.*;

class Pro_Level2_23 {
	
    public ArrayList<Integer> solution(String s) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        list.add(new ArrayList<>());
        
        int j = 0; //배열의 인덱스를 컨트롤할 변수들
        String ans = ""; //빈 스트링을 선언 == 배열에 추가하기 위한 지역변수 선언
        
        
        for(int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i,i+1); //하나씩 짤라서
            if(tmp.equals("}")) { // }가 나온다면 숫자를 추가해야함
                if(!ans.equals("")) { //빈문자열이 아니라면 숫자임
                    int ans1 = Integer.parseInt(ans);
                    list.get(j).add(ans1);
                    ans = ""; //값을 추가했기 때문에 다시 빈스트링으로 초기화해줌
                }
            }
            else if(tmp.equals(",")) { //,가 나온다면 이전 문자열이 }인지 확인해야함
                String tmp1 = s.substring(i-1,i);
                if(tmp1.equals("}")) { //이전 문자열이 }라면
                    j++; //j의 인덱스를 증가시켜 다음 배열로 넘어가야함
                    list.add(new ArrayList<>()); //다음 공간을 확보해야 하므로 add
                }
                else { //이전 문자열이 }가 아니라면 숫자임
                    if(!ans.equals("")) { //ans가 빈 문자열이 아니라면
                        int ans1 = Integer.parseInt(ans);
                        list.get(j).add(ans1);
                        ans = "";
                    }
                }
            }
            else { //else라면 tmp는 {나 숫자
                if(tmp.equals("{")) continue; // {라면 continue
                ans += tmp; //숫자라면 ans에 더함
            }
        }
        
        Collections.sort(list, (o1,o2)->o1.size()-o2.size()); //길이에 맞게 정렬 후
        
        for(int i = 0; i < list.size(); i++) {
            for(int m = 0; m < list.get(i).size(); m++) {
                int result = list.get(i).get(m); //하나씩 루프를 돌면서
                if(!answer.contains(result)) { //리스트에 없다면 추가함
                    answer.add(result);
                }
            }
        }
        
        return answer;
    }
}