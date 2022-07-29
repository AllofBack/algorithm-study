// Improvements - DFS (재귀)
class Solution {
    public int solution(int[] reward, int[] health, int[] optional) {
        return recursive(1, 0, reward, health, optional);
    }

    int recursive(int attack, int current, int[] reward, int[] health, int[] optional) {
        if (current == reward.length) {
            return 0;
        }

        int time = (health[current] + attack - 1) / attack; // 내림이 아닌 올림이 되기 위한 최적화
        int pathA = time + recursive( // 무조건 계산
                attack + reward[current],
                current + 1,
                reward, health, optional);

        if (optional[current] == 0) {
            return pathA; // 필수보스
        } else {
            int pathB = recursive( // 옵션 보스
                    attack,
                    current + 1,
                    reward, health, optional); // 현재보스 물리치지 않을 경우
            return Math.min(pathA, pathB); // 최소값으로 리턴
        }
    }
}
