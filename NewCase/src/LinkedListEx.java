/*
        1번부터 N번까지 N개의 풍선이 원형으로 놓여 있고. i번 풍선의 오른쪽에는 i+1번 풍선이 있고, 왼쪽에는 i-1번 풍선이 있다.
        단, 1번 풍선의 왼쪽에 N번 풍선이 있고, N번 풍선의 오른쪽에 1번 풍선이 있다.
        각 풍선 안에는 종이가 하나 들어있고, 종이에는 -N보다 크거나 같고, N보다 작거나 같은 정수가 하나 적혀있다.
        이 풍선들을 다음과 같은 규칙으로 터뜨린다.

        우선, 제일 처음에는 1번 풍선을 터뜨린다.
        다음에는 풍선 안에 있는 종이를 꺼내어 그 종이에 적혀있는 값만큼 이동하여 다음 풍선을 터뜨린다.
        양수가 적혀 있을 경우에는 오른쪽으로, 음수가 적혀 있을 때는 왼쪽으로 이동한다.
        이동할 때에는 이미 터진 풍선은 빼고 이동한다.

        예를 들어 다섯 개의 풍선 안에 차례로 3, 2, 1, -3, -1이 적혀 있었다고 하자.
        이 경우 3이 적혀 있는 1번 풍선, -3이 적혀 있는 4번 풍선, -1이 적혀 있는 5번 풍선, 1이 적혀 있는 3번 풍선, 2가 적혀 있는 2번 풍선의 순서대로 터지게 된다.
 */

class Node { // 원형연결리스트
    int data; // 몇 번째 풍선인지
    int cmd; // 풍선 안 이동 숫자
    boolean visited; // 풍선 터졌는가
    Node next;
    Node prev;

    public Node(int data, int cmd, boolean visited, Node next, Node prev) {
        this.data = data;
        this.cmd = cmd;
        this.visited = visited;
        this.next = next;
        this.prev = prev;
    }
}

class LinkedListC {
    Node head;
    
    public void add(int data, int cmd){
        if (this.head == null){ // head가 없을 경우
            this.head = new Node(data, cmd, false, null, null);
            this.head.next = this.head; // 다음 자기 자신
            this.head.prev = this.head; // 이전도 자기 자신
        } else {
            Node cur = this.head;
            while(cur != this.head) {
                cur = cur.next;
            }
            cur.next = new Node(data,cmd, false, cur.next, cur);
            this.head.prev = cur.next; // 마지막 추가 값과 head 연결
        }
    }
}

public class LinkedListEx {
    public static void solution(int[] data) {
        LinkedListC linkedList = new LinkedListC();
        for (int i = 0; i < data.length; i++) {
            linkedList.add(i + 1, data[i]);
        }

        Node cur = linkedList.head;
        
        int visitCnt = 0;
        int cmd = 0;
        while (visitCnt != data.length){
            int cnt = 0;
            while (cnt != Math.abs(cmd)){
                if (cmd > 0 ) {
                    cur = cur.next;
                } else {
                    cur = cur.prev;
                }
                if (cur.visited == false) {
                    cnt++;
                }
            }
            System.out.print(cur.data+ " ");
            cur.visited = true;
            visitCnt++;
            cmd = cur.cmd;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] balloon = {3, 2, 1, -3, -1};
        solution(balloon);

        System.out.println();
        balloon = new int[]{3, 2, -1, -2};
        solution(balloon);
    }
}