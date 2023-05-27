package Day_20230527;

import java.util.*;

class Pro_Level2_4 {
    
    public int solution(String[][] book_time) {
        //최소한의 객실만을 사용
        
        Arrays.sort(book_time, (o1,o2) -> {
            return o1[0].compareTo(o2[0]);
        }); //대실 시작시간 기준으로 정렬 수행
        
        int[][] time = new int[book_time.length][2]; //정수형으로 변환
        
		for (int i = 0; i < book_time.length; i++) {
				int start_time = Integer.parseInt(book_time[i][0].replace(":", ""));
				int end_time = Integer.parseInt(book_time[i][1].replace(":", ""));
				
				end_time += 10;
	            if(end_time%100 >= 60){
	                end_time+=40;
	            }
	            
	            time[i][0] = start_time;
	            time[i][1] = end_time;
		}
        
        
        // 예약 시간별로 객실 할당하기
		ArrayList<Integer> room = new ArrayList<>();
		for (int i = 0; i < time.length; i++) {
			Collections.sort(room);

			boolean roomcheck = false; // 객실이 할당되었는가

			for (int j = 0; j < room.size(); j++) { // 이미 할당된 객실 중에 현재 사용 가능한 객실이 있다면, 할당
				if (time[i][0] >= room.get(j)) {
					room.set(j, time[i][1]);
					roomcheck = true;
					break;
				}
			}

			if (!roomcheck) { 
				room.add(time[i][1]);
			}
		}

		return room.size();
    }
}