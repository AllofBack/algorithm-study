// My Code
class Solution {
    public int solution(int N) {
        int answer = 0;
        int count = 0; // 2로 몇 번 나뉘어지는가
        int left = N;

        count = N / 2;

        for ( int i = count; i >= 0; i--) {
            left = N - (i * 2);
            System.out.println(left);
            answer += getCombination(i+left, i);
        }
        return answer;
    }

    private int getCombination(int n, int r){
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