// My Code
class Solution {
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 1;
        int sum = 0;

        for (int j = 0 ; j < capacity.length; j++) {
            sum += capacity[j];
        }

        if ( sum > N ) {
            int newCase = getCombination(M, 1);

            for( int k = 0; k < newCase; k++) {
                answer *= getCombination(N, capacity[k]);
                System.out.println(answer);
            }
            answer *= newCase;

        } else {
            for (int i = 0; i < capacity.length; i++ ) {
                answer *= getCombination(N, capacity[i]);
                N -= capacity[i];
            }
        }
        answer *= getViewer(K, M);
        return answer;
    }

    private int getViewer(int n, int r) { // 감독관
        int result = 1;
        for (int i = n; i >= n-r+1; i--){
            result *= i;
        }
        return result;
    }

    private int getCombination(int n, int r){ // 교실별 배치 조합
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }
        return pResult / fResult;
    }
}

// Improvements
import java.util.Arrays;

class Solution {
    public long solution (int N, int M, int K, int[] capacity) {
        int capacitySum = Arrays.stream(capacity).sum();

        long studentCases = 1;
        if (capacitySum == N) { // 학생수와 공간이 맞는 경우
            int studentLeft = N;
            for (int cap: capacity) {
                studentCases *= nChooseK(studentLeft, cap);
                studentLeft -= cap;
            }
        } else { // 학생수보다 공간이 더 많은 경우
            studentCases = 0;
            // 전체 경우의 수로 확장하기
            long capacityMult = Arrays.stream(capacity).asLongStream().
                    reduce(1, (x, y) -> x*(y+1)); // 숫자를 하나씩 줄여나가는 방법

            indexLoop:
            for (int i = 0; i < capacityMult; i++) { // 자릿수 올리기
                int[] caps = new int[M];
                long denominator = capacityMult;
                long numerator = i;
                int currentSum = 0;
                for (int j = 0; j < M; j++) {
                    denominator /= capacity[j] + 1;
                    caps[j] = (int)(numerator / denominator);
                    numerator %= denominator;

                    currentSum += caps[j];
                    if (currentSum > N) { // 학생 수보다 많은 경우라면 넘김
                        continue indexLoop;
                    }
                }

                long currentCase = 1;
                if (Arrays.stream(caps).sum() == N) { // 학생 수와 일치하는 경우를 계산
                    int studentLeft = N;
                    for (int cap: caps) {
                        currentCase *= nChooseK(studentLeft, cap);
                        studentLeft -= cap;
                    }
                    studentCases += currentCase;
                }
            }
        }

        long kPm = 1;
        for (int i = K-M+1; i <= K; i++) {
            kPm *= i;
        }

        return studentCases * kPm;
    }

    private long nChooseK (int n, int k) {
        long numerator = 1;
        long denominator = 1;
        for (int i = 0; i < k; i++) {
            numerator *= n - i;
            denominator *= i + 1;
        }
        return numerator / denominator;
    }
}