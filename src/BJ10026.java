import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ10026 {

	public static void dfs(char[][] grid, int[][] visited, int x, int y) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid.length) {
				continue;
			}
			if (visited[nx][ny] == 0 && grid[nx][ny] == grid[x][y]) {//방문하지 않았고 같은 구역이면
				visited[nx][ny] = 1; //방문처리
				dfs(grid, visited, nx, ny);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[][] grid = new char[n][n];
		int[][] visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		int count1 = 0; //적록색약이 아닌 경우
		int count2 = 0; //적록색약인 경우
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) { //아직 방문하지 않았으면
					dfs(grid, visited, i, j);
					count1++;
				}

				if (grid[i][j] == 'G') { //적록색약인 경우 초록색을 빨간색으로
					grid[i][j] = 'R';
				}
			}
		}
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					dfs(grid, visited, i, j);
					count2++;
				}

			}
		}
		System.out.println(count1 + " " + count2);
	}
}
