// Improvements
import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] a, int[] b) {
        Stack<Integer> stack = new Stack<>(); // 더하고 난 결과 스택 저장
        int maxLen = Math.max(a.length, b.length); // 더 긴 양수 기준
        int offsetA = maxLen - a.length; // 빈자리
        int offsetB = maxLen - b.length;

        if (a.length == 0) {
            return b; // 입력 조건 고려해주어야함
        }

        if (b.length == 0) { // 엣지 케이스 고려하기
            return a;
        }

        int overflow = 0; // 자릿수 올림
        for (int i = maxLen - 1; i >= 0; i--) {
            int aVal = (i - offsetA < 0) ? 0 : a[i - offsetA]; // 삼항연산자
            int bVal = (i - offsetB < 0) ? 0 : b[i - offsetB]; // 배열밖으로 나갈 경우, 0으로 처리
            int cVal = aVal + bVal + overflow;
            if (cVal >= 10) {
                overflow = 1;
                stack.push(cVal - 10);
            } else {
                overflow = 0;
                stack.push(cVal);
            }
        }

        int resLen = maxLen;
        if (overflow == 1) { // 마지막 자릿수 올림
            resLen++;
            stack.push(1);
        }

        int[] result = new int[resLen];
        for (int i = 0; i < resLen; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
