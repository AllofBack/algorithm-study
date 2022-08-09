package BOJ;

/*
[MY TIL]
1. 체스판 문제. 2차원 배열 구현 시, 배열 인덱스 범위 잘 확인하기
2. Math min 기능 자주 쓰임. 굳이 if 문으로 비교하지말고 함수들 활용하기
*/

import java.io.*;
import java.util.StringTokenizer;

public class b_1018 {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        arr = new boolean[N][M];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true; // W일 때 TRUE
                } else {
                    arr[i][j] = false; // B일 때 FALSE
                }
            }
        }

        int N_row = N - 7;
        int M_col = M - 7;

        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i,j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean first = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                if (arr[i][j] != first){
                    count++;
                }
                first = !first;
            }
            first = !first;
        }
        // 첫 번재 칸을 기준으로 할 때의 색칠 할 개수와 첫번째 칸의 색의 반대되는 색 기준으로 할때의
        // 색칠 할 개수 중 최솟값을 count에 저장!
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}