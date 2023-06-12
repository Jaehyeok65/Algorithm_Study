package Day_20230612;

import java.util.*;


class Pro_Level2_13 {
    
    static int cal(String s1, String s2) { //들어온 시간과 나간 시간을 비교해서 분으로 리턴
        String s11[] = s1.split(":");
        String s22[] = s2.split(":");
        
        int first1 = Integer.parseInt(s11[0]);
        int second1 = Integer.parseInt(s11[1]);
        int first2 = Integer.parseInt(s22[0]);
        int second2 = Integer.parseInt(s22[1]);
        
        int in = first1 * 60 + second1;
        int out = first2 * 60 + second2;
        
        return out - in;
        
    }
    
    static int bill(int time, int[] fees) {
        
        int defaulttime = fees[0]; 
        int defaultmoney = fees[1];
        int unittime = fees[2];
        int unitmoney = fees[3];
       
        int overtime = time - defaulttime; //초과시간
        
        if(overtime < 0) { //초과시간이 음수라면 0으로 초기화
            overtime = 0;
        }
        double tmp = ((double)overtime / (double)unittime);
        
        int overbill = (int)Math.ceil(tmp) * unitmoney;
        return defaultmoney + overbill;
        
        
    }
    
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<String> slist = new ArrayList<>();
        
        ArrayList<String[][]> in = new ArrayList<>();
        ArrayList<String[][]> out = new ArrayList<>();
        HashMap<String, Integer> hash = new HashMap<>();
        
        for(String s : records) {
            String s1[] = s.split(" ");
            if(s1[2].equals("IN")) { //들어간 차량 저장
                String tmp[][] = new String[1][2];
                tmp[0][0] = s1[0];
                tmp[0][1] = s1[1];
                in.add(tmp);
            }
            else if(s1[2].equals("OUT")) { //나간 차량 저장
                String tmp[][] = new String[1][2];
                tmp[0][0] = s1[0];
                tmp[0][1] = s1[1];
                out.add(tmp);
            }
        }
        
        
        boolean flag[] = new boolean[in.size()];
        boolean flag2[] = new boolean[out.size()];
        for(int i = 0; i < in.size(); i++) {
            String tmp1[][] = in.get(i);
            String intime = tmp1[0][0];
            String innumber = tmp1[0][1];
            for(int j = 0; j < out.size(); j++) {
                if(flag2[j]) continue; //이미 출차된 차량은 살펴볼 필요없음
                String tmp2[][] = out.get(j);
                String outtime = tmp2[0][0];
                String outnumber = tmp2[0][1];
                if(innumber.equals(outnumber)) { //들어온 차량이 나간 기록이 있다면
                    int time = cal(intime, outtime);
                    if(hash.containsKey(innumber)) { //이미 있다면
                        int currenttime = hash.get(innumber);
                        int nexttime = currenttime + time;
                        hash.put(innumber,nexttime);
                    }
                    else { //없다면 새로 추가
                        hash.put(innumber,time);
                    }
                    flag[i] = true;
                    flag2[j] = true; //입차, 출차 내역 처리
                    break; //다음 중복 제거용으로 루프를 중단함
                }  
            }
        }
        for(int i = 0; i < flag.length; i++) {
            if(!flag[i]) { //입차 기록은 있지만 출차 기록은 없는 경우
                String tmp[][] = in.get(i);
                String number = tmp[0][1];
                String time = tmp[0][0];
                int ttime = cal(time, "23:59");
                if(hash.containsKey(number)) {
                    int currenttime = hash.get(number);
                    int nexttime = ttime + currenttime;
                    hash.put(number,nexttime);
                }
                else {
                    hash.put(number,ttime);
                }
            }
        }
        
        for(String s : hash.keySet()) {
            slist.add(s);
        };
        
        Collections.sort(slist);
        
        for(String s : slist) {
            int time = hash.get(s);
            int result = bill(time, fees);
            list.add(result);
        }
        
        return list;
    }
}