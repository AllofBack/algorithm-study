// Improvements - 우선순위큐(힙)
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] start, int[] time) {
        // 배열을 합쳐서 Task 리스트로 변경
        // 시작 시간을 기준으로 정렬 (오름차순)

        // IntStream.range : 0부터 start.length-1까지 증가하는 배열 스트림 생성
        List<Task> tasks = new LinkedList<>(IntStream.range(0, start.length)
                .mapToObj(i -> new Task(start[i], time[i], i)) // 입력을 Task Stream으로 바꿔주기
                .collect(Collectors.toList()));
        tasks.sort((a, b) -> {
            if (a.startTime == b.startTime) {
                return a.index - b.index;
            }
            return a.startTime - b.startTime;
        });

        // 시작 시간이 되면 Task가 저장되는 우선순위큐
        // 작업 수행이 가능할 때 하나씩 뽑아서 작업 수행
        // 작업 시간이 짧은 것 우선, 작업 시간이 같은 경우 인덱스 낮은 것 우선
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();
        int[] result = new int[tasks.size()];
        int currentIndex = 0;
        int currentTime = 0;
        while (currentIndex < result.length) {
            // 시작 시간이 된 Task를 모두 우선순위 큐에 삽입
            while (!tasks.isEmpty() && currentTime >= tasks.get(0).startTime) {
                priorityQueue.offer(tasks.remove(0));
            }

            if (!priorityQueue.isEmpty()) {
                // 처리할 작업이 우선순위큐에 있으면 하나 꺼내서 처리
                // 작업을 처리한 만큼 시간 지나감
                // 작업을 처리했으므로, 해당 작업 인덱스를 결과에 저장
                Task currentTask = priorityQueue.remove();
                currentTime += currentTask.periodTime;
                result[currentIndex++] = currentTask.index;
            } else {
                // 처리할 작업이 우선순위큐에 없으면 다음 작업까지 시간 진행
                // 시작 시간이 같은 작업이 여러 건 있을 수 있으므로 모든 건 삽입
                currentTime = tasks.get(0).startTime;
                while (!tasks.isEmpty() && currentTime >= tasks.get(0).startTime) {
                    priorityQueue.offer(tasks.remove(0));
                }
            }
        }
        return result;
    }
}

class Task implements Comparable<Task> { // Comparable 구현 - task끼리 정렬비교할 때, compareTo 사용
    int startTime;
    int periodTime;
    int index;

    public Task(int startTime, int periodTime, int index) {
        this.startTime = startTime;
        this.periodTime = periodTime;
        this.index = index;
    }
    // 정렬 순서를 "처리 시간 순"으로 하되, "처리 시간"이 같으면 "인덱스 순"으로 한다.
    @Override
    public int compareTo(Task o) {
        if (this.periodTime == o.periodTime) {
            return this.index - o.index; // 인덱스 순
        }
        return this.periodTime - o.periodTime; // 처리시간 순
    }
}