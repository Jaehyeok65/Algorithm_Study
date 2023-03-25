package Day_20230325;


import java.io.*;

public class Baek_1644 {
	
	static int N;
	static int start = 2;
	static int count = 0;
	static int end = 2; //소수는 2부터 시작이므로 2부터 
	static int sum = 0; //누적합
	static int tmp = 0; //중간 계산할 변수
	static boolean isPrime[];
	
	static void solve() { //연속된 소수들의 합으로 
		
		
		while(true) {
			
			if(start == end) { //start 포인터와 end 포인터가 같다면
				tmp = start;
			}
			else { //start 포인터와 end 포인터가 같지 않다면
				tmp = getSum(start, end);
			}
			if(tmp == N) { //연속합이 N과 같다면 카운트를 증가시키며
				if(isPrime[start] && isPrime[end]) {
					count++;
				}
				start++;
			}
			else if(tmp < N) { //구간의 연속합이 N보다 작다면 end포인터를 증가시킨다.
				end++;
				if(end > N) break;
			}
			else { //연속합이 N보다 크다면 start 포인터를 증가시킨다.
				start++;
			}
			
		}
		
		System.out.print(count);
		
	}
	
	static int getSum(int start, int end) {
		int tmpsum = 0;
		for(int i = start; i <= end; i++) {
			if(isPrime[i]) {
				tmpsum += i;
			}
		}
		return tmpsum;
	}
	
	 // 소수 리스트 반환 함수
    static void getPrimes(int n) {
        isPrime = new boolean[n + 1];
        
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        } 
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        getPrimes(N); // 소수 리스트

        solve();

     
    }

   
}