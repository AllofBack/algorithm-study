package BOJ;

/*
[MY TIL]
1. Scanner는 느리기 때문에 되도록 BufferedReader 사용하기
3. BufferedReader는 문자열을 한 줄로 읽기 때문에 공백 기준 분리 위해 StringTokenizer을 사용한다.
4. 단순히 string+string을 하면 메모리 할당과 배치 다시 하기 때문에 시간이 더 걸린다.
   -> StringBuilder을 사용해서 String 문자열을 더할 때 새로운 객체를 생성하지 않고 기존의 데이터를 더하는 방식을 이용하기
5. 처음 실행했을 때, nextToken에서 에러 발생 !! 해당 메서드 사용하기 위해서는 다음 토큰이 있는지 확인 먼저 하고 사용해야하기
   때문에 hasMoreTokens() 통해 확인.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_10828 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            if (st.hasMoreTokens()) { // nextToken 메서드 사용하기 위해서는 hasMoreTokens로 검증 필요
                switch (st.nextToken()) { // nextToken()은 다음 토큰을 불러오는 메서드
                    case "push":
                        push(Integer.parseInt(st.nextToken()));
                        break;

                    case "pop":
                        sb.append(pop()).append('\n');
                        break;

                    case "size":
                        sb.append(size()).append('\n');
                        break;

                    case "empty":
                        sb.append(empty()).append('\n');
                        break;

                    case "top":
                        sb.append(top()).append('\n');
                        break;
                }
            }
        }
        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        } else {
            int res = stack[size - 1];
            stack[size - 1] = 0;
            size--;
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int top() {
        if (size == 0) {
            return -1;
        } else {
            return stack[size-1];
        }
    }
}
