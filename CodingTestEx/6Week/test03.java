// Improvements - Trie
// 단어 길이 별로 Trie 만들기
import java.util.*;

class Solution {
    public String[][] solution(String[] words, String[] queries) {
        // Integer -> 트라이 길이
        Map<Integer, Trie> trieHashMap = new HashMap<>(); // 트라이를 여러개 만들어주어야함

        for (int i = 0; i < words.length; i++) {
            int n = words[i].length();
            if (!trieHashMap.containsKey(n)) {
                trieHashMap.put(n, new Trie());
            }
            Trie trie = trieHashMap.get(n); // 길이 별로 트라이 만들기
            trie.addWord(words[i], i); // 트라이에 값 넣어주기
        }

        List<String[]> resultList = new ArrayList<>();
        for (String query: queries) {
            int n = query.length(); // 검색하고자하는 단어의 길이
            if (!trieHashMap.containsKey(n)) { // 해당 조건 없으면 RuntimeError 발생할 수 있음
                resultList.add(new String[0]);
            } else {
                String[] result = trieHashMap.get(n) // Trie
                        .getResult(query) // List<Integer>
                        .stream() // Stream<Integer>
                        .map(x -> words[x]) // Stream<String>
                        .toArray(String[]::new); // Array 생성자 넣어주기 'new'
                resultList.add(result);
            }
        }
        return resultList.toArray(new String[0][0]);
    }
}

class Node {
    char val;
    Map<Character, Node> children = new HashMap<>();
    List<Integer> words = new ArrayList<>(); // 갯수가 아닌 단어를 반환하기. 인덱스 저장

    public Node(char val) {
        this.val = val;
    }
}

class Trie {
    Node head = new Node('\n');
    public void addWord(String word, int idx) { // 몇 번째 단어인지 같이 넣어주기
        Node curr = head;
        curr.words.add(idx);

        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new Node(c));
            }
            curr = curr.children.get(c);
            curr.words.add(idx);
        }
    }

    public List<Integer> getResult(String query) {
        Node curr = head;

        for (char c: query.toCharArray()) {
            if (c == '?') {
                return curr.words;
            }
            if (!curr.children.containsKey(c)) {
                return new ArrayList<>(); // 비어있는 리스트 반환
            }
            curr = curr.children.get(c); // 일치하는 단어 쫓아가기
        }
        return curr.words;
    }
}