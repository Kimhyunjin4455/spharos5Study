package org.example.programmers;


import java.util.LinkedList;
import java.util.Queue;

public class Pg87694 {
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[][] rectangle1 = new int[][] {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
		int characterX1 = 1;
		int characterY1 = 3;
		int itemX1 = 7;
		int itemY1 = 8;

		int[][] rectangle2 = new int[][] {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}};
		int characterX2 = 9;
		int characterY2 = 7;
		int itemX2 = 6;
		int itemY2 = 1;

		int[][] rectangle3 = new int[][] {{1, 1, 5, 7}};
		int characterX3 = 1;
		int characterY3 = 1;
		int itemX3 = 4;
		int itemY3 = 7;

		System.out.println(sol.solution(rectangle1, characterX1, characterY1, itemX1, itemY1)); // 17
		System.out.println(sol.solution(rectangle2, characterX2, characterY2, itemX2, itemY2)); // 11
		System.out.println(sol.solution(rectangle3, characterX3, characterY3, itemX3, itemY3)); // 9

	}

	static class Solution {
		static int[][] board; // 전체 영역
		static boolean[][] visited; // 방문한 좌표인지 확인을 위한 2차원 boolean 배열
		static int answer;
		static int[] dirX = {-1, 0, 1, 0}; // 시계 방향
		static int[] dirY = {0, 1, 0, -1};

		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

			board = new int[101][101]; // 크기의 최대가 50 -> 문제의 힌트로 인해 2배 처리가 필요하기에 50*2+1 처리
			visited = new boolean[101][101]; // 방문한 좌표인지 확인을 위한 2차원 boolean 배열

			// STEP 1. 모든 사각형의 모서리 영역과 내부 영역을 1로 채운다.
			for (int i = 0; i < rectangle.length; i++) {

				int[] eachRectangle = rectangle[i]; // 하나의 사각형 꼭지점 정보가 담긴 배열

				// 그림1의 문제를 해결하기 위해 모든 좌표 값의 크기를 2배로 해준다.
				for (int x = eachRectangle[0] * 2; x <= eachRectangle[2] * 2; x++) {
					for (int y = eachRectangle[1] * 2; y <= eachRectangle[3] * 2; y++) {
						board[x][y] = 1;
					}
				}
			}

			// STEP 2. 모서리 영역을 제외한 내부 영역을 0으로 채운다.
			for (int i = 0; i < rectangle.length; i++) {
				int[] eachRectangle = rectangle[i]; // 하나의 사각형 꼭지점 정보가 담긴 배열

				// 시작 꼭지점 좌표 + 1 ~ 마지막 꼭지점 좌표 - 1까지 0으로 채우면 사각형 내부 영역이 0으로 채워지게 된다.
				for (int x = eachRectangle[0] * 2 + 1; x <= eachRectangle[2] * 2 - 1; x++) {

					for (int y = eachRectangle[1] * 2 + 1; y <= eachRectangle[3] * 2 - 1; y++) {
						board[x][y] = 0;
					}
				}
			}

			answer = Integer.MAX_VALUE;
			bfs(characterX*2, characterY*2, itemX*2, itemY*2);

			return answer / 2;
		}

		public void bfs(int startX, int startY, int targetX, int targetY) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] {startX, startY, 0});
			visited[startX][startY] = true;

			while (!queue.isEmpty()) {
				int[] info = queue.poll();
				int charX = info[0];
				int charY = info[1];
				int nowDistance = info[2];

				if (charX == targetX && charY == targetY) {
					answer = Math.min(nowDistance, answer);
					continue; // 불필요한 추가 탐색 방지
				}

				for (int dir = 0; dir < Solution.dirX.length; dir++) {
					int nx = charX + dirX[dir];
					int ny = charY + dirY[dir];

					if (0 <= nx && nx < visited.length && 0 <= ny && ny < visited[0].length) {
						if (board[nx][ny] == 1 && !visited[nx][ny]) {
							visited[nx][ny] = true;
							queue.add(new int[] {nx, ny, nowDistance + 1});
						}
					}

				}

			}
		}
	}



}
