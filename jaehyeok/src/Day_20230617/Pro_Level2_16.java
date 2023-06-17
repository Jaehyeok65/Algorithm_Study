package Day_20230617;

import java.util.*;

class Pro_Level2_16 {
    public int[] solution(int[] numbers) {
        
        int answer[] = new int[numbers.length]; //정답 배열
        Stack<Integer> stack = new Stack<>(); //스택을 이용해서 품
        for(int i = numbers.length - 1; i >= 0; i--) { //뒤에서부터
            while(!stack.isEmpty()) { //스택 최상단 값이 현재값보다 크다면 뒷큰수 
                if(stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                }
                else {
                    stack.pop();
                }
            }
            
            if(stack.isEmpty()) { //스택이 비어잇다면 뒷큰수가 없다는 뜻
                answer[i] = -1;
            }
            stack.push(numbers[i]); //비교를 위해 매 수를 스택에 넣어줌
    }
        
        return answer;
}
}