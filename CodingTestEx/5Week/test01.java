// My Code
class Solution {
    public int solution(int N, int[][] trust) {
        if (trust.length == 0) {
            return 0;
        }

        int[] count = new int[N+1];
        int answer = -1;

        for ( int i = 0; i < trust.length; i++){
            count[trust[i][1]]++;

            if (count[trust[i][1]] >= N-1) {
                answer = trust[i][1];
                break;
            }
        }

        for ( int i = 0; i < trust.length; i++) {
            if(trust[i][0] == answer) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}

// Improvements - Directed Graph (유향 그래프 문제)
// 시간복잡도 O(N*M) = O(N^2)
import java.util.Arrays;

class Solution {
    public int solution (int N, int[][] trust) {
        if (trust.length == 0) {
            return -1; // 이걸 해주지 않으면 Stream 사용 시 에러 발생 가능!
        }

        for (int i = 1; i <= N; i++) { // Stream 활용하기 (데이터 활용도 높이기)
            int finalI = i; // finalValue
            if (Arrays.stream(trust).
                    noneMatch(x -> x[0] == finalI) && // 조건에 해당하는게 하나도 없으면 True!
                    Arrays.stream(trust).
                            filter(x -> x[1] == finalI). // 조건 해당하는 경우만 남기기 filter
                            count() == (N - 1)) { // 본인을 제외한 모든 사람 N - 1
                return finalI;
            }
        }
        return -1;
    }
}

// Improvements 2
// 메모리 제한 없을 경우, 더 좋음.
class Solution {
    public int solution (int N, int[][] trust) {
        boolean[] give = new boolean[N+1];
        int[] receive = new int[N+1];

        for (int[] ints : trust){
            give[ints[0]] = true;
            receive[ints[1]]++;
        }

        for (int i = 1; i < give.length; i++) {
            if (!give[i] && receive[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}