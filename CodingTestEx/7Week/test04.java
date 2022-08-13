// My Code
class Solution {
    public long solution(int N, int[] branches) {
        long answer = -1;
        long left = 1;
        long right = 0;

        // left에는 가장 만들 수 있는 최소 길이 1
        // right에는 배열 내 가장 짧은 길이

        for ( int len : branches) {
            right = Math.min(len, 10000);
        }

        while ( left <= right) {
            long mid = (left + right) / 2;
            int cnt = 0; // N개 채우는 지 확인용

            // 길이 순으로 빼보면서 branch 하나 만들면 +1
            for ( int len : branches) {
                cnt += (int) (len / mid);
            }

            if (cnt >= N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (cnt >= N)  {answer = mid;}
        }
        return answer;
    }
}

// Improvements
import java.util.Arrays;

class Solution {
    public int solution(int N, int[] branches) {
        int left = 1;
        int right = Arrays.stream(branches).min().getAsInt();
        int best = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int total = 0;
            for (int branch: branches) {
                total += branch / mid;
            }

            if (total >= N) {
                best = Math.max(best, mid);
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return best;
    }
}