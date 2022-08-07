// Improvements - 우선순위큐
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[][] solution(int[][] buildings) {
        // 양 끝점을 각각 Point로 생성하여 순서대로 정렬
        // direction -1 : 시작점(위로 솟는 방향)
        // direction +1 : 끝점(아래로 내려오는 방향)
        List<Point> points
                = Arrays.stream(buildings)
                .map(x -> List.of( // x는 Integer 배열, 빌딩하나하나 좌측점/우측점 1개씩 나옴
                        new Point(x[0], x[2], -1), // x[0] : left, x[2] : height
                        new Point(x[1], x[2], +1))) // x[1] : right -> 형태 : [O, O], [O, O], [O, O]
                .flatMap(Collection::stream) // Stream<Point> 배열 펼쳐주기 [ ] 괄호 삭제
                .sorted() // X가 증가하는 방향으로 정렬
                .collect(Collectors.toList()); // List로 반환!

        // 항상 최대값이 가장 위에 있는 우선순위 큐
        // 각 건물의 시작/끝점에서 해당 건물의 높이를 삽입/삭제
        PriorityQueue<Integer> priorityQueue
                = new PriorityQueue<>(
                Collections.reverseOrder()); // 수가 큰거부터 나오게 설정

        int currentHeight = 0;
        priorityQueue.offer(currentHeight);

        List<List<Integer>> resultList = new ArrayList<>(); // 이중리스트 주의
        for (Point point: points) {
            // 시작점이면 높이를 삽입, 끝점이면 높이를 제거거
           if (point.direction == -1) {
                priorityQueue.offer(point.y);
            } else {
                priorityQueue.remove(point.y);
            }
           // 현재 위치에 존재하는 건물 중 가장 높은 건물의 높이
            int mostHeight = priorityQueue.peek();
            // 기존 높이에서 차이가 있으면 (올라가거나 내려가거나 둘다)
            // 키포인트에 내용 추가
            if (currentHeight != mostHeight) {
                resultList.add(List.of( // 길이가 2인 리스트 만들어서 추가
                        point.x,
                        mostHeight
                ));
                currentHeight = mostHeight;
            }
        }
        // 2중 리스트를 2-D 배열로 변환
        return resultList.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }
}

class Point implements Comparable<Point> {
    int x;
    int y;
    int direction; // 건물의 시작?끝? : -1(시작), +1(끝)

    public Point(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    // 시작점이 작은 순으로 정렬하기 위한 compareTo 메소드
    @Override
    public int compareTo(Point o) {
        if (x == o.x) return direction - o.direction;
        return x - o.x; // 시작점 작은 순
    }
}
