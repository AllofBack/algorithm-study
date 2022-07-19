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

    private int getCombination(int n, int r){ // 반복형 사용
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
class Solution { // 재귀는 가독성만 좋고, 반복이 속도가 빠르고 메모리도 더 적게 사용!

    // f(n) = f(n-1) + f(n-2)
    // f(1) = 1, f(2) = 2
    public int solution (int N) {
        int a = 1, b = 2;

        if (N == 1) {
            return a;
        }

        // a <- f(n-1)
        // b <- f(n)
        for (int i = 3; i <= N; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}