/*
[MY TIL]
1. 간단한 문제이지만 숫자 범위 확인하기
2. BigInteger은 java.math안에 있다.
3. 특이한 점은 BigInteger을 초기화하기 위해서는 문자열을 인자 값으로 넘겨주어야 한다는 점입니다. BigInteger가 문자열로 되어 있기 때문입니다. -> 범위 제한이 없음
4. add를 통해 덧셈 가능 활용하기!
5. BufferedWriter을 사용할 경우, 숫자를 출력하고 싶다면 string으로 만들어줘야한다. " " 붙이기
 */

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class b_11382 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger a = new BigInteger(st.nextToken());
        BigInteger b = new BigInteger(st.nextToken());
        BigInteger c = new BigInteger(st.nextToken());

        bw.write(a.add(b.add(c)) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
