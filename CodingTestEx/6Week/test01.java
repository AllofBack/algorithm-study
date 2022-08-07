// Improvements - Trie
import java.util.*;

class Solution {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        Trie trie = new Trie();
        for (int i = 0; i < titles.length; i++) {
            trie.addLyric(titles[i], lyrics[i]);
        }
        
        // 가능하면 자료형 Interface 사용하기
        List<String[]> resultList = new ArrayList<>();
        for (String query: problems) {
            resultList.add(trie.getResult(query)); // list안 string 배열
        }
        return resultList.toArray(new String[0][0]); // 최적화된 list - Array
    }
}

class Node {
    char val; // 어떤 문자를 갖는지? (없어도 됨)
    Map<Character, Node> children = new HashMap<>();
    List<String> songs = new ArrayList<>(); // 노드를 거쳐간 가사들이 어떤 노래인지 저장

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    Node head = new Node('\n'); // 헤드 노드 표시 ( 안 중요함 )

    public void addLyric(String songName, String lyric) { // 가사 등록
        Node curr = head;

        for (char c: lyric.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
            curr.songs.add(songName);
        }
    }

    public String[] getResult(String query) { // 정답 얻기
        Node curr = head;

        for (char c: query.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return new String[]{}; // 비어있는 배열 출력
            }
            curr = curr.children.get(c);
        }
        // list를 Array로 변환
        return curr.songs.toArray(new String[0]); // toArray 배열 인스턴스 넣어야 배열 변환
    }
}