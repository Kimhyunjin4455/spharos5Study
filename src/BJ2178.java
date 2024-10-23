import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ2178 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	private static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] length = br.readLine().split(" ");

		int n = Integer.parseInt(length[0]);
		int m = Integer.parseInt(length[1]);

		int[][] maze = new int[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = Integer.parseInt(temp.charAt(j) + "");
			}
		}

		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(new Node(0, 0));
		while (!deque.isEmpty()) {
			Node current = deque.poll();
			for (int i = 0; i < 4; i++) {
				int x = current.x + dx[i];
				int y = current.y + dy[i];
				if (x < 0 || x >= n || y < 0 || y >= m) {
					continue;
				}
				if (maze[x][y] == 1) {
					Node node = new Node(x, y);
					deque.offer(node);
					maze[x][y] = maze[current.x][current.y] + 1;
				}
			}
		}

		System.out.println(maze[n-1][m-1]);
	}
}