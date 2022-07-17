// 배열을 이용한 기본 큐 직접 구현 (원형 큐)

class MyQueue2 {
    int[] arr;
    int front = 0;
    int rear = 0;

    MyQueue2(int size) { // front 값을 처음에 비워두기 때문에 하나 더 크게 만들기
        arr = new int[size + 1];
    }

    public boolean isEmpty() { // 배열이 비어있을 때, rear와 front가 같은 곳을 가리킨다.
        return this.rear == this.front;
    }

    public boolean isFull() { // rear가 끝인데 길이로 나누었을 때, front 위치일경우
        return (this.rear + 1) % this.arr.length == this.front;
    }

    public void enqueue(int data) { // 원형큐 관리를 위해 front는 비워둘 것
                                    // rear을 왼쪽으로 하나씩 옮기면서 값 넣기
        if (this.isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }

    public Integer dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        front = (front + 1) % this.arr.length;
        return this.arr[front];
    }

    public void printQueue() {
        int start = (this.front + 1) % this.arr.length; // 조심하기
        int end = (this.rear + 1) % this.arr.length;

        for (int i = start; i != end; i = (i + 1) % this.arr.length) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

}

public class Queue03 {
    public static void main(String[] args) {
        // Test code
        MyQueue2 myQueue = new MyQueue2(5);
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());
        myQueue.printQueue();

        myQueue.enqueue(6);
        myQueue.enqueue(7);
        myQueue.printQueue();

        System.out.println(myQueue.dequeue());  // 3
        System.out.println(myQueue.dequeue());  // 4
    }
}