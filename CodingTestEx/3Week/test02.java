// My Code
import java.util.*;

class Solution {
    public int solution(String[] names) {
        int answer = 0;
        int whoNames = names.length;
        int getResult = 4;

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < whoNames; i++) {
            set.add(names[i]);
        }
        answer = getCombination(set.size(), getResult);
        return answer;
    }
    private int getCombination(int n, int r) {
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
class Solution {
    public int solution(String[] names) {
        // 중복제거 때는 set 사용하기
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size(); // 중복제거하면 사람 수 알 수 있음.
        int m = 4;

        int numerator = 1;
        int denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= n - i;
            denominator *= (i + 1);
        }

        return numerator / denominator; // 뽑기는 순서가 상관없기 때문에 나눠줌.
    }
}
