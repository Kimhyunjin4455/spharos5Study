package org.example.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pg84021 {
	public static void main(String[] args) {
		int[][] game_board1 = {
			{1,1,0,0,1,0},
			{1,0,0,0,1,0},
			{0,0,0,0,0,0},
			{1,0,0,0,1,1},
			{1,1,0,0,1,1},
			{1,1,1,0,1,1}
		};

		int[][] table1 = {
			{1,0,0,1,1,0},
			{1,0,1,0,1,0},
			{0,1,1,0,1,1},
			{0,0,1,0,0,0},
			{1,1,0,1,1,0},
			{0,1,0,0,0,0}
		};

		int[][] game_board2 = {
			{0,0,0},
			{1,1,0},
			{1,1,1}
		};

		int[][] table2 = {
			{1,1,1},
			{1,0,0},
			{0,0,0}
		};

		Solution solution = new Solution();

		// 테스트 케이스 1 실행
		System.out.println("테스트 케이스 1 결과: " + solution.solution(game_board1, table1));
		// 예상 출력: 14

		// 테스트 케이스 2 실행
		System.out.println("테스트 케이스 2 결과: " + solution.solution(game_board2, table2));
		// 예상 출력: 0
	}

	static class Solution{
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		boolean[][] visited;

		public int solution(int[][] game_board, int[][] table){
			int n = game_board.length;
			int answer = 0;

			// 1-2. 게임보드의 빈공간 찾기
			List<List<int[]>> emptySpaces = findPieces(game_board, 0);

			// 1-3. 테이블의 퍼즐 조각 찾기
			List<List<int[]>> puzzlePieces = findPieces(table, 1);

			boolean[] usedPieces = new boolean[puzzlePieces.size()];

			// 5. 빈공간에 대해 맞는 퍼즐 찾기
			for (List<int[]> space : emptySpaces){
				for (int i=0; i< puzzlePieces.size(); i++){
					if (usedPieces[i]) continue;

					List<int[]> piece = puzzlePieces.get(i);
					if(space.size() != piece.size()) continue;

					// 4방향 회전 시도
					boolean matched = false;
					List<int[]> rotatedPiece = new ArrayList<>(piece);

					for(int rot = 0; rot < 4; rot++) {
						if(isPieceMatch(space, rotatedPiece)) {
							matched = true;
							usedPieces[i] = true;
							answer += space.size();
							break;
						}
						rotatedPiece = rotatePiece(rotatedPiece);
					}

					if(matched) break;
				}
			}

			return answer;

		}

		// 1. 빈 공간이나 퍼즐 조각을 찾아 좌표 리스트로 반환
		private List<List<int[]>> findPieces(int[][] board, int value){
			int n = board.length;
			visited = new boolean[n][n];
			List<List<int[]>> pieces = new ArrayList<>();

			for (int i=0; i<n; i++){
				for (int j=0; j<n; j++){
					if (board[i][j] == value && !visited[i][j]){
						List<int[]> piece = new ArrayList<>();
						bfs(i,j,board,value,piece);
						normalizePiece(piece);
						pieces.add(piece);
					}
				}
			}
			return pieces;
		}

		// 2. bfs
		private void bfs(int x, int y, int[][] board, int value, List<int[]> piece){
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[]{x,y});
			visited[x][y] = true;
			piece.add(new int[]{x,y});

			while (!queue.isEmpty()){
				int[] current = queue.poll();

				for (int i=0; i<4; i++){
					int nr = current[0] + dr[i];
					int nc = current[1] + dc[i];

					if (nr>=0 && nr<board.length && nc>=0 && nc<board.length && !visited[nr][nc] && board[nr][nc]==value){
						queue.offer(new int[]{nr, nc});
						visited[nr][nc] = true;
						piece.add(new int[]{nr, nc});
					}
				}

			}
		}

		// 3. 조각을 (0,0)으로 이동
		private void normalizePiece(List<int[]> piece){
			int minR = piece.stream().mapToInt(p -> p[0]).min().getAsInt();
			int minC = piece.stream().mapToInt(p -> p[1]).min().getAsInt();

			for (int[] p : piece){
				p[0] -= minR;
				p[1] -= minC;
			}

			piece.sort((a,b) -> {
				if (a[0] == b[0]) return a[1] - b[1];
				return a[0] - b[0];
			});
			//

		}

		// 4. 조각 회전
		private List<int[]> rotatePiece(List<int[]> piece) {
			List<int[]> rotated = new ArrayList<>();
			for(int[] p : piece) {
				rotated.add(new int[]{-p[1], p[0]});
			}
			normalizePiece(rotated);
			return rotated;
		}


		// 5. 두 조각 일치하는지 확인
		private boolean isPieceMatch(List<int[]> space, List<int[]> piece) {
			for(int i = 0; i < space.size(); i++) {
				if(space.get(i)[0] != piece.get(i)[0] ||
					space.get(i)[1] != piece.get(i)[1]) {
					return false;
				}
			}
			return true;
		}
	}

}
