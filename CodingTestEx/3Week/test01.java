// My Code
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n ; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if ( i % j == 0 ) {
                    count++;
                }
            }
            if (count == 2) answer++;
        }
        return answer;
    }
}

// Improvements
class Solution {
    public int solution(int n) {
        // 에라토스테네스의 체
        // 소수가 아닌 수들을 배제하는 방식
        int[] intArray = new int[n];

        for (int i = 2; i < n; i++) { // 1로 초기화 (0,1제외) 소수아님
            intArray[i] = 1;
        }

        for (int i = 2; i <= (int)Math.sqrt(n); i++) {
            // 일정 숫자를 넘어가서는 배수를 넘어가는 작업을 할 필요가 없다.
            int num = i * 2;
            while (num < n) {
                intArray[num] = 0;
                num += i;
            }
        }
        return Arrays.stream(intArray).sum();
    }
}
