// 선형 자료구조 - 큐
// 인터페이스 구조이기 때문에, 추상클래스들 모두 오버라이딩 해줘야하기 때문에
// LinkedList 다형성 활용하기

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {
    public static void main(String[] args) {
        Queue queue = new LinkedList();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.poll());
        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        queue.clear();
        System.out.println(queue);
        System.out.println(queue.poll());
    }
}
