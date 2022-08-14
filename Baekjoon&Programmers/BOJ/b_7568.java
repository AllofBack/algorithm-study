package BOJ;

/*
[MY TIL]
1. 이차원 배열을 생성해서 비교하는 간단한 문제
2. 효율을 높이기 위해서는 StringBuilder와 StringTokenizer 활용하기
*/

import java.io.*;

public class b_7568 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        String[] sp;

        for (int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(sp[0]);
            arr[i][1] = Integer.parseInt(sp[1]);
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}