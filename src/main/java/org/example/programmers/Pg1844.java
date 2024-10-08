package org.example.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Pg1844 {
	public static void main(String[] args) {
		int[][] arr1 = new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		int[][] arr2 = new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};

		Solution sol = new Solution();
		System.out.println(sol.solution(arr1));
		System.out.println(sol.solution(arr2));
	}

	static class Solution {
		static int[][] graph;
		static int[] dr = {-1,0,1,0};
		static int[] dc = {0,1,0,-1};

		public int solution(int[][] maps) {
			int answer = 0;
			int n = maps.length;
			int m = maps[0].length;
			graph = new int[n][m];

			for (int i=0; i<n; i++){
				for (int j=0; j<m; j++){
					graph[i][j] = maps[i][j];
				}
			}

			answer = bfs(0,0, n, m);

			return answer;
		}

		private int bfs(int row, int col, int n, int m) {
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{row, col});
			graph[row][col] = 1;


			while (!queue.isEmpty()){
				int[] res = queue.poll();
				int nowRow = res[0];
				int nowCol = res[1];

				if (nowRow == n-1 && nowCol == m-1){
					return graph[nowRow][nowCol];
				}

				for (int i=0; i<4; i++){
					int newRow = nowRow + dr[i];
					int newCol = nowCol + dc[i];

					if ((0 <=newRow && newRow <n) && (0 <=newCol && newCol <m)){
						if (graph[newRow][newCol] ==1){
							graph[newRow][newCol] = graph[nowRow][nowCol] +1;
							queue.offer(new int[]{newRow, newCol});
						}
					}
				}
			}

			return -1;
		}
	}
}
