package problem;

import java.util.Arrays;

public class Programmers_258711 {

    public enum GraphType {
        DONUT,
        STICK,
        EIGHT
    }

    public static int[] solution(int[][] edges) {
        // 정점의 개수 구하기
        int size = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);

        // 그래프 선언
        boolean[][] graph = new boolean[size][size];

        // 그래프 초기화
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from][to] = true;
        }

        // 추가된 정점 찾기
        int vertex = getVertex(size, graph);
        for (int i = 0; i < size; i++) {
            if (graph[vertex][i]) {

            }
        }

        int[] answer = {};
        return answer;
    }

    private static int getVertex(int size, boolean[][] graph) {
        int vertex = 0;
        for (int i = 0; i < size; i++) {
            boolean innerCheck = false;
            for (int j = 0; j < size; j++) {
                if (graph[j][i]) {
                    innerCheck = true;
                    continue;
                }
            }

            int outerCnt = 0;
            if (!innerCheck) {
                for (int j = 0; j < size; j++) {
                    if (graph[i][j]) {
                        outerCnt++;
                    }
                }
            }

            if (!innerCheck && outerCnt >= 2) {
                vertex = i;
                break;
            }
        }
        return vertex;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[][]{
                {2, 3}, {4, 3}, {1, 1}, {2, 1}
        })));
        System.out.println(Arrays.toString(solution(new int[][]{
                {4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6},
                {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}
        })));
    }
}