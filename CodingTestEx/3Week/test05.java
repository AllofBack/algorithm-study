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