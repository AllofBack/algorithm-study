// Improvements - HashTable
import java.util.*;
import java.util.stream.Collectors;

class Solution { // 사용가능한 숫자 늘려가면서 숫자 조합 계산하기
    public int solution(int[] numbers, int target) {
        Map<Integer, Set<Integer>> dp = new HashMap();
        Set<Integer> set = Arrays.stream(numbers). // 중복하지 않기 위해 set 사용
                boxed().collect(Collectors.toSet()); // int -> Integer로 Wrapped 완료 + set 형태로 변경

        dp.out(1, set);

        if (set.contains(target)) { // set에 target이 포함되어 있을 경우
            return 1;
        }

        for (int i = 2; i <= 10000; i++) { // 숫자 2개 이상 사용
            set = new HashSet<>(); // 숫자 2개로 만들 수 있는 숫자 담기

            for (int j = 1; j < i / 2; j++) {
                Set<Integer> set1 = dp.get(j);
                Set<Integer> set2 = dp.get(i - j);

                for (int x : set1) {
                    for (int y : set2) {
                        int addVal = x + y;
                        int multVal = x * y;

                        if (addVal == target || multVal == target) {
                            return i;
                        }

                        if (addVal < target) {
                            set.add(addVal);
                        }
                        if (multVal < target) {
                            set.add(multVal);
                        }
                    }
                }
            }
            dp.put(i, set); // map에 추가. i개로 나올 수 있는 숫자들.
        }
        return -1;
    }
}