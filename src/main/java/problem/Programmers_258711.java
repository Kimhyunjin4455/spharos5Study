import java.util.Arrays;

class Solution {
    static int vertexCnt = 0;
    static int edgeCnt = 0;

    public int[] solution(int[][] edges) {
        // 정점의 개수 구하기
        int size = Arrays.stream(edges)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);

        // 그래프 선언
        boolean[][] graph = new boolean[size + 1][size + 1];
        boolean[] visited = new boolean[size + 1];

        // 그래프 초기화
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph[from][to] = true;
        }

        // 추가된 정점 찾기
        int vertex = getVertex(size, graph);
        int doughnut = 0;
        int stick = 0;
        int eight = 0;

        for (int i = 0; i < size; i++) {
            if (graph[vertex][i]) {
                vertexCnt = 0;
                edgeCnt = 0;

                dfs(graph, vertex, i, visited);

                if (vertexCnt - edgeCnt == 1) {
                    stick++;
                } else if (vertexCnt - edgeCnt == 0) {
                    doughnut++;
                } else {
                    eight++;
                }
            }
        }

        int[] answer = {vertex, doughnut, stick, eight};
        return answer;
    }

    private static int getVertex(int size, boolean[][] graph) {
        int vertex = 0;

        for (int i = 0; i < size; i++) {
            boolean innerCheck = false;
            for (int j = 0; j < size; j++) {
                if (graph[j][i]) {
                    innerCheck = true;
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

    private static void dfs(boolean[][] graph, int vertex, int curPos, boolean[] visited) {
        graph[vertex][curPos] = false;
        if (!visited[curPos]) {
            visited[curPos] = true;
            vertexCnt++;
        }

        for (int nextPos = 0; nextPos < graph.length; nextPos++) {
            if (graph[curPos][nextPos]) {
                edgeCnt++;
                dfs(graph, curPos, nextPos, visited);
            }
        }
    }
}