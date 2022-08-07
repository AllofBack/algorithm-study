package BOJ;

/*
[MY TIL]
1. 다리 놓는 경우의 수 구하기 (겹치면 안 됨)
2. 조합 사용! => 순서 상관 없음 ( 다리가 겹치는 상황 고려하지 않아도 알아서 조합)
3. int로 하면 범위를 넘어서기 때문에 BigInteger or long 사용하기 ( 자료형 중요 !!)
4. 인텔리제이에서 BufferedReader nextToken에서 계속해서 오류 발생,,,해결 중,,,, (백준은 문제없이 정답처리 됨)
   -> hasMoreToken으로 일시적인 해결 가능, 마지막 인덱스 부분 변경 필요.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long M = Long.parseLong(st.nextToken());
            long result = 1;

            // 조합 구현
            for(int j = 0; j < N; j++) {
                result *= (M - j);
                result /= (j + 1);
            }
            System.out.println(result);
        }
    }
}