package algorithm;

import java.io.*;
import java.util.*;

public class BJ_1325 {
    static List<Integer>[] tree;
    static int[] res;

    // BFS 탐색 함수
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[tree.length];
        int count = 0;

        queue.add(start);
        visited[start] = true;
        count++;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : tree[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        res = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[b].add(a);
        }

        for (int i = 1; i <= n; i++) {
            res[i] = bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, res[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (res[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
