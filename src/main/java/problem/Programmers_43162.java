package problem;

public class Programmers_43162 {

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static boolean visited[];

    static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    private static void dfs(int vertex, int[][] computers, boolean[] visited) {
        visited[vertex] = true;

        for (int i = 0; i < computers.length; i++) {
            if (computers[vertex][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
}