// 선형 자료구조 - 연결 리스트
// 단순 연결 리스트 (simple ver.) 기본 구조 구현

// 노드
class Node {
    int data;
    Node next;

    Node() {}

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {

    Node head;

    LinkedList() {}

    LinkedList(Node node) {this.head = head;}

    // 연결 리스트 비어있는지 확인
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    // 연결리스트 맨 뒤에 데이터 추가
    public void addData(int data) {
        if (this.head == null) {
            this.head = new Node(data, null); // 새로운 노드가 헤드 됨
        } else {
            Node cur = this. head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }

    // 연결리스트의 맨 뒤의 데이터 삭제
    public void removeData() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while (cur.next != null) {
            prev = cur;
            cur = cur.next;
        }
        if (cur == this.head) {
            this.head = null;
        } else {
            prev.next = null;
        }
    }

    // 연결리슽츠에서 데이터 찾기
    public void findData(int data) {
        if (this.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            if (cur.data == data) {
                System.out.println("Data Exist !");
                return;
            }
            cur = cur.next;
        }
        System.out.println("Data not Found!");
    }

    // 연결리스트의 모든 데이터 출력
    public void showData() {
        if (this.isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

public class LinkedList01 {
    public static void main(String[] args) {

        // Test Code
        LinkedList myList = new LinkedList(new Node(1, null));
        myList.showData();

        myList.addData(2);
        myList.addData(3);

        myList.findData(3);
    }
}