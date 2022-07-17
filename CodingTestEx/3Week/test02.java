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