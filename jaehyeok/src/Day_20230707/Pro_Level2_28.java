package Day_20230707;

import java.util.*;


class Pro_Level2_28
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        int size = A.length;
        int ArrayB[] = new int[size];
        
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < size; i++) {
            ArrayB[B.length-i-1] = B[i];
        }
        
        for(int i = 0; i < size; i++){
            answer += A[i] * ArrayB[i];
        }
       
        return answer;
    }
}