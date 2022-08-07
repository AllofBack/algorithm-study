package BOJ;

// 요세푸스 순열 (큐 사용)
// 맨 처음에 ArrayList형으로 결과값을 반환하니 출력문이 [] 괄호로 묶여 있어 오답결과 처리가 되었다.
// replace 메서드를 통해 문제에서 요구하는 화살표 <> 괄호로 대체해서 출력해서 성공했다.
// getJosephusPermutation를 반환형을 ArrayList로 유지하고 싶다면 BufferedWriter나 StringBuilder로 해결 가능.
// 큐에서 count에 해당하는 데이터를 우선 삭제하고 해당 데이터의 위치가 K번째에 해당될 때 결과 result에 추가한다.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class b_1158 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        getJosephusPermutation(N,K);

        br.close();
    }

    public static void getJosephusPermutation(int N, int K) {
        Queue queue = new LinkedList();
        ArrayList result = new ArrayList();

        IntStream.range(1, N+1).forEach(x -> queue.add(x));

        int cnt = 0;
        while (!queue.isEmpty()) {
            int data = (int)queue.remove();
            cnt += 1;
            if (cnt % K == 0) {
                result.add(data);
            } else {
                queue.add(data);
            }
        }
        System.out.println(result.toString().replace('[','<').replace(']','>'));
    }
}
