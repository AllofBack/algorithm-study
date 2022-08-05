// 비선형 자료구조 - 이진 탐색 트리

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int key;
    Node left;
    Node right;

    Node(int key, Node left, Node right) {
        this.key = key;
        this.left = left;
        this.right = right;
    }
}

class BinarySearchTree {
    Node head;

    BinarySearchTree(int key) {
        this.head = new Node(key, null, null);
    }

    public void addNode(int key) {
        if (this.head == null) {
            this.head = new Node(key, null, null);
        } else {
            Node cur = this.head;

            while (true) {
                Node pre = cur; // cur을 쫓아갈 pre 노드

                if (key < cur.key) { // cur.key는 부모
                    cur = cur.left;

                    if (cur == null) {
                        pre.left = new Node(key, null, null);
                        break;
                    }
                } else {
                    cur = cur.right;

                    if (cur == null) {
                        pre.right = new Node(key, null, null);
                        break;
                    }
                }
            }
        }
    }

    public void removeNode(int key) {
        Node parent = null; // 부모 노드
        Node successor = null; // 후계자
        Node predecessor = null; // 부모 노드 가리킬 노드
        Node child = null; // 자식노드 있는지 없는지

        Node cur = this.head;

        while (cur != null) {
            if (key == cur.key) {
                break;
            }
            parent = cur; // cur을 쫒아다님.
            if (key < cur.key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if (cur == null) {
            System.out.println("key에 해당하는 노드가 없습니다.");
            return;
        }

        if (cur.left == null && cur.right == null) { // Leaf 노드인 경우
            if (parent == null) { // 트리에 노드 1개인 케이스
                this.head = null;
            } else {
                if (parent.left == cur) { 
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
        } else if (cur.left != null && cur.right == null || cur.left == null && cur.right != null) { // 자식노드가 하나인 경우
            if (cur.left != null) {
                child = cur.left;
            } else {
                child = cur.right;
            }

            if (parent == null) {
                this.head = child;
            } else {
                if (parent.left == cur) {
                    parent.left = child; // 삭제 후 재할당
                } else {
                    parent.right = child;
                }
            }
        } else {    // 자식이 둘인 경우
            predecessor = cur;
            successor = cur.left; // 좌측 서브트리 중 가장 큰 값 찾기

            while (successor.right != null) {
                predecessor = successor;
                successor = successor.right;
            }

            // 중요 코드 successor이 head가 됨. 그림 그리기!!
            predecessor.right = successor.left;
            successor.left = cur.left; // success 왼쪽 값에 기존 cur의 왼쪽 값
            successor.right = cur.right; // 삭제 대상 노드의 right

            if (parent == null) {
                this.head = successor;
            } else {
                if (parent.left == cur) {
                    parent.left = successor;
                } else {
                    parent.right = successor;
                }
            }
        }
    }

    public void levelOrder(Node node) { // 출력이 제대로 잘 되는지 확인
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            System.out.print(cur.key + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }

            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        System.out.println();
    }

}


public class Main {
    public static void main(String[] args) {
        // Test code
        // 노드 삽입
        BinarySearchTree bst = new BinarySearchTree(20);
        bst.addNode(10);
        bst.addNode(30);
        bst.addNode(1);
        bst.addNode(15);
        bst.addNode(25);
        bst.addNode(13);
        bst.addNode(35);
        bst.addNode(27);
        bst.addNode(40);
        bst.levelOrder(bst.head);

        // 노드 삭제
        bst.removeNode(40);
        bst.levelOrder(bst.head);
        bst.removeNode(25);
        bst.levelOrder(bst.head);
        bst.removeNode(20);
        bst.levelOrder(bst.head);
    }
}
