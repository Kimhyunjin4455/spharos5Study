package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1325 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] res;

    public static void dfs(int node){
        visited[node] = true; // 방문한 노드는 true로 변경

        for (int i = 0; i < graph[node].size(); i++) { // 노드와 연결된 노드들 탐색
            int n_node = graph[node].get(i); // 연결된 노드 가져오기
            if (!visited[n_node]) { // 방문하지 않은 경우
                res[n_node]++; // 해당 노드에서 해킹 가능한 수 증가
                dfs(n_node);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        res = new int[n + 1];

        graph = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
        }

        for (int i = 1; i < n + 1; i++){
            visited = new boolean[n + 1];
            dfs(i);
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++){
            max = Math.max(max, res[i]); // 가장큰 해킹 가능한 값 찾기
        }

        for (int i = 1; i < n + 1; i++){
            if (res[i] == max){
                System.out.print(i + " ");
            }
        }

    }
}
