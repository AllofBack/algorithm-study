// 알고리즘 - 최소 신장 트리
// 크루스칼 알고리즘

import java.util.Arrays;

public class Main {

    static int parents[];

    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;

        // 간선 가중치 오름차순 정렬
        Arrays.sort(data, (x, y) -> (x[2] - y[2]));

        // union-find 배열 초기화
        parents = new int[v + 1];
        for (int i = 1; i < v; i++) {
            parents[i] = i; // 자기자신으로 초기화
        }

        for (int i = 0; i < e; i++) {
            // 사이클 발생하지 않으면 연결하고 weight 업데이트
            if (find(data[i][0]) != find(data[i][1])) {
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }

        return weightSum;
    }

    public static void union(int a, int b) { // 두 개의 노드를 같은 집합으로 만들기
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) { // 부모가 같지 않으면
            parents[aP] = bP; // 같은 곳으로 연결되도록 연결하기
        }
    }

    public static int find(int a) { // a라는 노드가 최종적으로 어디에 연결되어있는지
        if (a == parents[a]) {
            return a;
        }
        // 사이클 체크용
        return parents[a] = find(parents[a]); // parents 안에 담고 있는 값
    }


    public static void main(String[] args) {
        // Test code
        int v = 7;
        int e = 10;
        int[][] graph = {{1, 3, 1}, {1, 2, 9}, {1, 6, 8}, {2, 4, 13}, {2, 5, 2}, {2, 6, 7}, {3, 4, 12}, {4, 7, 17}, {5, 6, 5}, {5, 7, 20}};

        System.out.println(kruskal(graph, v, e));
    }
}
