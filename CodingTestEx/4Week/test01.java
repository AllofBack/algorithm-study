// My Code
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        int min = numbers[0];
        int noNum = -1;

        for (int i = 1; i < numbers.length; i++) {
            if ( min > numbers[i] ) {
                min = numbers[i];
            }
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if ( numbers[i] == min) {
                min++;
            } else {
                {
                    noNum = min;
                    break;
                }
            }
        }
        answer = noNum;
        return answer;
    }
}

// Improvements
import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i + 1]) {
                return numbers[i] + 1;
            }
        }
        return -1; // 습관처럼 구현하기
    }
}