// My Code
import java.util.*;

class Solution {
    public boolean solution(String s, String t) {

        boolean answer = true;

        if( s.length() != t.length()) {
            return false;
        }

        int[] s_list = checkVisited(s);
        int[] t_list = checkVisited(t);

        for (int i = 0; i < 26 ; i++) {
            if (s_list[i] != t_list[i]) {
                return false;
            } return true;
        }
        return answer;
    }

    public static int[] checkVisited(String s) {
        int[] visited = new int[26];

        for (int i = 0; i < s.length(); i++ ) {
            visited[s.charAt(i) - 97] += 1;
        }
        return visited;
    }
}

// Improvements
// 정렬의 시간 복잡도 - O(NlogN)
class Solution {
    public boolean solution(String s, String t) {
        if (s.length() != t.length()) { // testcase 모든 경우 확인하기
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for (int i = 0; i < s.length(); i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}