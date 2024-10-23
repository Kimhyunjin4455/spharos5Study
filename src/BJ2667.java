import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ2667 {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static class Node {
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int bfs(int[][] map, int x, int y) {
		int cnt = 0;
		Deque<Node> deque = new ArrayDeque<>();
		deque.offer(new Node(x, y));
		map[x][y] = 0;
		while (!deque.isEmpty()) {
			Node current = deque.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				if (nx < 0 || nx >= map.length || ny < 0 || ny >= map.length) {
					continue;
				}
				if (map[nx][ny] == 1) {
					map[nx][ny] = 0;
					deque.offer(new Node(nx, ny));
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String row = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(row.charAt(j)+"");
			}
		}
		List<Integer> answer = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					answer.add(bfs(map, i, j));
				}
			}
		}
		System.out.println(answer.size());
		Collections.sort(answer);
		for (Integer i : answer) {
			System.out.println(i);
		}
	}
}
