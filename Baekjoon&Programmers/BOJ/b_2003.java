package BOJ;

/*
[MY TIL]
1. 투포인터 문제 - forLoop & 투포인터로 둘 다 풀 수 있지만 투포인터 활용하면 효율성 증가
2. 런타임 에러 발생 -> StringTokenizer 한 번더 선언해주기
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b_2003 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int hap = Integer.parseInt(st.nextToken());

        int[] arr = new int[num];
        st= new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int p1 = 0;
        int p2 = 0;
        int sum = 0;

        while(true) {
            if (sum > hap) {
                sum -= arr[p1++];
            } else if (p2 == arr.length) break;
            else {
                sum += arr[p2++];
            }
            if (sum == hap) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
