package BOJ;

/*
[MY TIL]
1. DEQUE 활용법에 익숙해지기
2. StringTokenizer 사용하지 않고, String 배열에 split을 통해 저장하는 방법이 더 효율 높음
3. 배열이나 ArrayList로도 구현 가능함
*/

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 명령 수
        Deque dq = new ArrayDeque();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            switch (s[0]) {
                case "push_front" : {
                    dq.addFirst(Integer.parseInt(s[1]));
                    break;
                }

                case "push_back" : {
                    dq.addLast(Integer.parseInt(s[1]));
                    break;
                }

                case "pop_front" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.pollFirst()).append('\n');
                    }
                    break;
                }

                case "pop_back" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.pollLast()).append('\n');
                    }
                    break;
                }

                case "size": {
                    sb.append(dq.size()).append('\n');
                    break;
                }

                case "empty": {
                    if (dq.isEmpty()) {
                        sb.append(1).append('\n');
                    }
                    else {
                        sb.append(0).append('\n');
                    }
                    break;
                }

                case "front": {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.peekFirst()).append('\n');
                    }
                    break;
                }

                case "back": {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                    }
                    else {
                        sb.append(dq.peekLast()).append('\n');
                    }
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}