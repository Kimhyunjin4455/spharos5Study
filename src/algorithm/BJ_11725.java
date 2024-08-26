package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11725 {
    static List<Integer>[] t;  // 리스트 트리 생성
    static int[] p;  // 부모 노드
    static boolean[] v;  // 방문 여부

    public static void dfs(int node) {  // 깊이 우선 탐색
        v[node] = true;  // 방문한 노드는 true로 변경
        for (int i = 0; i < t[node].size(); i++) {  // 노드의 자식 노드만큼 반복
            int N_n = t[node].get(i);  // 노드의 자식 노드
            if (!v[N_n]) {  // 자식 노드가 방문하지 않은 노드라면
                p[N_n] = node;  // 부모 노드를 저장
                dfs(N_n);  // 재귀적으로 자식 노드로 이동
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        t = new ArrayList[n + 1];  // 트리 생성
        p = new int[n + 1];  // 부모 노드 생성
        v = new boolean[n + 1];  // 방문 여부 생성

        for (int i = 1; i <= n; i++) {
            t[i] = new ArrayList<>();  // 트리에 노드 추가를 위한 리스트 생성
        }

        for (int i = 0; i < n - 1; i++) {  // 트리 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 트리에 노드 추가
            t[a].add(b);
            t[b].add(a);
        }

        dfs(1);  // 깊이 우선 탐색

        for (int i = 2; i < n + 1; i++) {  // 두 번째 노드부터 부모 노드 출력
            System.out.println(p[i]);
        }

        br.close();




//        static int[][] m;
//        static int[] p;
//        static boolean[] v;
//
//        public static void dfs(int node, int n) {
//            v[node] = true;
//            for (int i = 1; i <= n; i++) {
//                if (m[node][i] == 1 && !v[i]) {
//                    p[i] = node;
//                    dfs(i, n);
//                }
//            }
//        }
//
//        public static void main(String[] args) throws IOException {
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            int n = Integer.parseInt(br.readLine());
//
//            m = new int[n + 1][n + 1];
//            p = new int[n + 1];
//            v = new boolean[n + 1];
//
//            for (int i = 0; i < n - 1; i++) {
//                StringTokenizer st = new StringTokenizer(br.readLine());
//                int a = Integer.parseInt(st.nextToken());
//                int b = Integer.parseInt(st.nextToken());
//
//                m[a][b] = 1;
//                m[b][a] = 1;
//            }
//
//            dfs(1, n);
//
//            for (int i = 2; i <= n; i++) {
//                System.out.println(p[i]);
//            }
//        }
//    }

    }
}