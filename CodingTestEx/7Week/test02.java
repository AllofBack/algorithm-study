// My Code
import java.util.*;

class Solution {

    public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;

        List<String> list = new ArrayList<>();

        for (int n : numbers) {
            list.add(String.valueOf(n));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (String s : list) {
            answer += s;
        }
        return answer;
    }
}

// Improvements
// 정렬하려면 Comperator 필요 <Generic>
class Solution {
    public String solution(int[] numbers) { // int - primitive Type은 Generic에 사용 불가
        StringBuilder sb = new StringBuilder(); // 꼭 사용하기 !! 효율적으로 하기 위해
        Arrays.stream(numbers)
                .boxed() // Integer Class로 wrapping 먼저 해주기
                .sorted((x, y) -> { // sorting 기준
                    // x가 9, y가 95일 경우, a = 995 / b = 959
                    int a = Integer.parseInt(String.valueOf(x) + String.valueOf(y));
                    int b = Integer.parseInt(String.valueOf(y) + String.valueOf(x));
                    return b - a; // 내림차순
                })
                .forEach(sb::append); // stringbuilder 추가하기
        String result = sb.toString(); // 모두 0일 경우,,!!
        return result.charAt(0) == '0' ? "0" : result;
    }
}