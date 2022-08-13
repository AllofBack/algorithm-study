// Improvements
import java.util.stream.IntStream;

class Solution {
    public int solution(int N, int M, int[] fry, int[] clean) {
        int left = 0; // 최소시간
        int right = M * IntStream.range(0, fry.length)
                .map(x -> fry[x] + clean[x]) // 더한 것 중 가장 오래걸리는 시간 * M
                .max().getAsInt(); // 최대시간

        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int val = 0;
            for (int i = 0; i < fry.length; i++) {
                val += (mid + clean[i]) / (fry[i] + clean[i]);
            }

            if (val >= M) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}