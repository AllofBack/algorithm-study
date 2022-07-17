// 응용 2 - 양방향 연결 리스트 (Doubly Linked List) 구현
// LinkedList01.java의 LinkedList 클래스 상속

class NodeBi {
    int data;
    NodeBi next;
    NodeBi prev;

    NodeBi(int data, NodeBi next, NodeBi prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class DoublyLinkedList extends LinkedList {
    NodeBi head;
    NodeBi tail;

    DoublyLinkedList(NodeBi node) {
        this.head = node;
        this.tail = node;
    }

    //  연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결 리스트에 데이터 추가
    // before_data 가 null 인 경우, 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가
    public void addData(int data, Integer beforeData) {
        if (this.head == null) {
            this.head = new NodeBi(data, null, null);
            this.tail = this.head;
        } else if (beforeData == null) {
            this.tail.next = new NodeBi(data, null, this.tail);
            this.tail = this.tail.next;
        } else {
            NodeBi cur = this.head;
            NodeBi pre = cur;
            while (cur != null) {
                if (cur.data == beforeData) {
                    if (cur == this.head) {
                        this.head = new NodeBi(data, this.head, null);
                        this.head.next.prev = this.head;
                    } else {
                        pre.next = new NodeBi(data, cur, pre);
                        cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    //  연결 리스트에서 특정 값을 가진 노드 삭제
    public void removeData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = this.head;
        NodeBi pre = cur;

        while (cur != null) {
            if (cur.data == data) {
                if (cur == this.head && cur == this.tail) {
                    this.head = null;
                    this.tail = null;
                } else if (cur == this.head) {
                    this.head = cur.next;
                    this.head.prev = null;
                } else if (cur == this.tail) {
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                } else {
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }

            pre = cur;
            cur = cur.next;
        }
    }

    //  연결 리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        NodeBi cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //  연결 리스트의 모든 데이터 출력 (tail 부터)
    public void showDataFromTail() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        NodeBi cur = this.tail;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.prev;
        }
        System.out.println();
    }

}

public class LinkedList03 {
    public static void main(String[] args) {

        //      Test code
        DoublyLinkedList myList = new DoublyLinkedList(new NodeBi(1, null, null));
        myList.showData();          // 1
    }
}