// My Code
class Solution { // 디귿자 배치. 2차원 내 4개의 부분 배열 생성
    public int solution(int n, int i, int j) {
        int answer = 0;
        return answer;
    }
}

// Improvements
class Solution { // 재귀적으로 해결하기 (너비 최적화)
    public int solution (int n, int i, int j) {
        return recursion(0, n, i, j);
    }

    private int recursion(int count, int n, int i, int j) {
        // n = 2인 경우 (2x2) 탈출 조건건        if (n == 2) {
            if (i == 0 & j == 1) {
                return count + 1;
            } else if (i == 0 & j == 0) {
                return count + 2;
            } else if (i == 1 & j == 0) {
                return count + 3;
            } else {
                return count + 4;
            }
        }

        // 4개 영역으로 나누어 count offset 계산, 해당 영역 내의 부분 i,j로 변환
        // count offset 이미 숫자가 꽉 차는 곳임을 알기 때문에 계산 필요 없음.
        int m = n / 2;
        if (i < m & j >= m) { // 우측 상단
            return recursion(count, m, i, j - m);
        } else if (i < m & j < m) { // 좌측 상단
            count += m * m; // 우측 상단만큼 카운트 오프셋
            return recursion(count, m, i, j);
        } else if (i >= m & j < m) { // 좌측 하단
            count += m * m * 2; // 우측 + 좌측 상단 오프셋
            return recursion(count, m, i - m, j);
        } else { // 우측하단
            count += m * m * 3; // 우측 + 좌측 상단 + 좌측 하단 오프셋
            return recursion(count, m, i - m, j - m);
        }
    }
}