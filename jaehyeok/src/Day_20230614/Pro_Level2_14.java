package Day_20230614;

import java.util.*;

class Pro_Level2_14 {
    public int solution(int[] order) {
        int answer = 0;
        //스택 
        Stack<Integer> stack = new Stack<>(); //보조컨테이너
       
        int current = 1; //현재 박스 번호
        int index = 0; //인덱스번호
        
        while(true) {
            
            if(current < order[index]) {
                //현재 박스가 넣어야할 박스보다 작다면
                //보조컨테이너에 넣고 다음 박스를 살펴봄
                stack.push(current++);
            }
            else if(current == order[index]) {
                //현재 박스가 넣어야할 박스와 같다면 넣음
                answer++;
                current++;
                index++;
            }
            else {
                //현재 박스가 넣어야할 박스보다 크다면
                //보조 컨테이너 박스에서 살펴봐야함
                while(stack.size() > 0  && stack.peek() == order[index]) {
                    //보조 컨테이너에 상자가 있고 해당 상자가 넣어야할 상자와 같다면
                    stack.pop(); //해당 상자를 빼서
                    answer++; //넣고
                    index++; //다음 넣어야할 상자를 살핌
                }
                //종료조건
                //모두 다 실었거나 다음 실어야하는 상자 번호보다 현재 상자번호가 크다면
                if(index >= order.length || order[index] < current) break;
            }
        }
        
        return answer;
    }
}