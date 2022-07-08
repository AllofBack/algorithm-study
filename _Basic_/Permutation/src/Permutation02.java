// 순열 - 방법2 (visited 사용)
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오

import java.util.Arrays;

public class Permutation02 {
    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return; // 탈출 조건
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[4];
        int[] out = new int[3];

        Permutation02 p = new Permutation02();
        p.permutation(arr, 0, 4, 3, visited, out);
    }
}