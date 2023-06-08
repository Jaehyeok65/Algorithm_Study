package Day_20230608;

import java.util.*;

class Pro_Level2_11 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (o1,o2) -> {
            if(o1[col-1] == o2[col-1]) { //같을 경우 기본값 내림차순 정렬
                return o2[0] - o1[0];
            }
            return o1[col-1] - o2[col-1]; //주어진 컬럼에 따라 오름차순 정렬
        });
        
        for(int i = row_begin-1; i < row_end; i++) {
            
            int total = 0;
            for(int j = 0; j < data[i].length; j++) {
                total += (data[i][j] % (i+1));
            };
            
            answer = answer ^ total;
        }
        
        
        return answer;
    }
}