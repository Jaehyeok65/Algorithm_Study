package Day_20230623;

import java.util.*;

class Pro_Level2_19 {
    
    static void getList(int[] array, ArrayList<Integer> list) {
        Arrays.sort(array);
        
        for(int i = 2; i <= array[0]; i++) { //A를 나눌 수 있는 모든 수를 구함
            boolean flag = true;
            for(int j = 0; j < array.length; j++) {
                if(array[j] % i != 0) { //i로 나눠지지 않는다면
                    flag = false; //false 리턴
                    break;
                }
            }
            if(flag) {
                list.add(i);
            }
            
        }
    }
    
    static int resolve(int[] array, ArrayList<Integer> list) {
        //리스트로부터 배열에 나눌 수 없는 수를 구함
        for(int i = list.size() - 1; i >= 0; i--) {
            boolean flag = true;
            for(int j = 0; j < array.length; j++) {
                if(array[j] % list.get(i) == 0) { // 모두나눌 수 없는 수를 찾아야하므로
                    flag = false; //나눌 수 있다면 false 후 break
                    break;
                }
            }
            if(flag) { //모두 나눌 수 없다면 해당 수를 리턴함
                return list.get(i);
            }
        }
        
        return 0; //둘 다 없다면 0을 리턴
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        getList(arrayA, listA);
        getList(arrayB, listB); //A와 B의 공약수들을 구함
        int tmp1 = resolve(arrayB, listA); //철수 나눔o 영희 나눔x
        int tmp2 = resolve(arrayA, listB); //철수 나눔x 영희 나눔o
        
        answer = Math.max(tmp1,tmp2);
        
        return answer;
    }
}