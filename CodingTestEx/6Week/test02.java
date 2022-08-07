// Improvements - Trie
// DFS 사용 가능
import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        // Trie 2개로 분류!!! - 비용 부담? -> O(2m) O(m) 크게 부담되지 않는다.
        Trie trie = new Trie();
        Trie invTrie = new Trie(); // 단어 뒤집어 넣기

        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            trie.addWord(word);
            invTrie.addWord(sb.reverse().toString());
        }

        List<Integer> resultList = new ArrayList<>();
        for (String query: queries) {
            if (query.charAt(0) != '*') { // 정방향
                resultList.add(trie.getResult(query));
            } else { // 역방향
                StringBuilder sb = new StringBuilder(query);
                resultList.add(invTrie.getResult(sb.reverse().toString()));
            }
        }
        return resultList.stream(). // mapToInt ( boxed -> primitive )
                mapToInt(Integer::intValue).toArray(); // list -> array로 바꿔주기
    }
}

class Node {
    char val;
    Map<Character, Node> children = new HashMap<>();
    int words = 0; // 단어 몇 개 포함?

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    Node head = new Node('\n');

    public void addWord(String word) {
        Node curr = head;

        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
            curr.words++; // hello랑 hell의 경우, 겹침
        }
    }

    public int getResult(String query) {
        Node curr = head;

        for (char c: query.toCharArray()) {
            if (c == '*') {
                return curr.words;
            }
            if (!curr.children.containsKey(c)) {
                return 0;
            }
            curr = curr.children.get(c);
        }
        return curr.words;
    }
}