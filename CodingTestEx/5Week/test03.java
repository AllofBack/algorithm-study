// My Code - 재귀
class Solution {
    int totalAme = 1;
    int currTime = 0;
    int betweenTime = 0;

    public int solution(int delay, int N) {
        int answer = 0;

        recursiveAme(delay, N, currTime, 1);
        answer = totalAme;
        return answer;
    }

    public void recursiveAme(int delay, int N, int currTime, int newAme) {
        if ( currTime == N ) {
            return;
        }
        newAme *= 2;
        totalAme += newAme;
        currTime++;
        betweenTime = currTime + delay;

        if ( betweenTime <= N) {
            recursiveAme(delay, N, betweenTime, 1);
        }
        recursiveAme(delay, N, currTime, 1);
    }
}

// Improvements - BFS (Queue)_Tree
import java.util.LinkedList;
        import java.util.Queue;

class Solution {
    public int solution(int delay, int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // 앞으로 분열하기까지 얼마나 남았는가
        int count = 1;
        for (int i = 1; i <= N; i++) {
            Queue<Integer> newQueue = new LinkedList<>(); // i번째 큐와 i+1번째 큐 분리
            while (!queue.isEmpty()) {
                int d = queue.remove();
                if (d == 0) { // 0인 경우 분열. 곧바로 분열
                    newQueue.add(0); // 바로 분열열
                   newQueue.add(delay); // delay 해야하는 경우
                    count += 2;
                } else {
                    newQueue.add(d - 1); // 휴식 한번 했기 때문에 1 빼줌.
                }
            }
            queue = newQueue; // 교체
        }
        return count;
    }
}