package problem;

public class Programmers_1884_DFS {

    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static boolean visited[][];
    static boolean isEnd;

    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        isEnd = false;

        dfs(0, 0, maps);

        if(!isEnd) {
            return -1;
        }
        return maps[maps.length - 1][maps[0].length - 1];
    }

    private static void dfs(int s, int e, int[][] maps) {
        visited[s][e] = true;

        if (s == maps.length - 1 && e == maps[0].length - 1) {
            isEnd = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = s + dx[i];
            int ny = e + dy[i];

            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length || visited[nx][ny]) {
                continue;
            }

            if (maps[nx][ny] == 1) {
                maps[nx][ny] = maps[s][e] + 1;
                dfs(nx, ny, maps);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}}));
        System.out.println(solution(new int[][]{
                {1},
                {1},
                {0},
                {1},
                {1}}));
    }
}