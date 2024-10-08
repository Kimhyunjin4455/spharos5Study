package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {

	// static int N,M;
	//
	// static int[][] graph;
	// static int[][] distance;
	//
	// static int[] dr = {-1,0,1,0};
	// static int[] dc = {0,1,0,-1};
	//
	//
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	String str = br.readLine();
	//
	// 	StringTokenizer st = new StringTokenizer(str, " ");
	//
	// 	N = Integer.parseInt(st.nextToken());
	// 	M = Integer.parseInt(st.nextToken());
	//
	// 	graph = new int[N][M];
	// 	distance = new int[N][M];
	//
	//
	// 	for (int i=0; i<N; i++){
	// 		String numStr = br.readLine();
	// 		for (int j=0; j<M; j++){
	// 			graph[i][j] = Integer.parseInt(String.valueOf(numStr.charAt(j)));
	// 		}
	// 	}
	// 	// for(int[] nums: graph) {
	// 	// 	for (int num: nums){
	// 	// 		System.out.print(num + " ");
	// 	// 	}
	// 	// 	System.out.println();
	// 	// }
	//
	// 	bw.write(String.valueOf(bfs(0,0)));
	// 	bw.flush();
	// 	bw.close();
	// 	br.close();
	//
	//
	// }
	//
	// private static int bfs(int row, int col) {
	//
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	queue.offer(new int[]{row, col});
	// 	distance[row][col] = 1;
	//
	// 	while (!queue.isEmpty()){
	// 		int[] current = queue.poll();
	// 		int nowRow = current[0];
	// 		int nowCol = current[1];
	//
	// 		if (nowRow == N-1 && nowCol == M-1){
	// 			return distance[nowRow][nowCol];
	// 		}
	//
	// 		for (int dir=0; dir<4; dir++){
	// 			int newRow = nowRow + dr[dir];
	// 			int newCol = nowCol +dc[dir];
	//
	// 			if ((0 <=newRow && newRow <N) && (0 <=newCol && newCol <M)){
	// 				if (graph[newRow][newCol] == 1 && distance[newRow][newCol] == 0){
	// 					distance[newRow][newCol] = distance[nowRow][nowCol] +1;
	// 					queue.offer(new int[]{newRow, newCol});
	// 				}
	// 			}
	// 		}
	// 	}
	// 	return 0;
	// }

	static int N, M;
	static int[][] graph; // 미로 배열

	static int[] dr = {-1, 0, 1, 0}; // 상하좌우 이동
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][M];

		for (int i = 0; i < N; i++) {
			String numStr = br.readLine();
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(String.valueOf(numStr.charAt(j)));
			}
		}

		// BFS 탐색 시작
		bw.write(String.valueOf(bfs(0, 0))); // (0, 0)에서 시작
		bw.flush();
		bw.close();
		br.close();
	}

	private static int bfs(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{row, col});
		graph[row][col] = 1; // 시작점의 거리 초기화

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int nowRow = current[0];
			int nowCol = current[1];

			// 목표 지점에 도달한 경우
			if (nowRow == N - 1 && nowCol == M - 1) {
				return graph[nowRow][nowCol]; // 최단 경로의 길이 반환
			}

			// 상하좌우 이동
			for (int dir = 0; dir < 4; dir++) {
				int newRow = nowRow + dr[dir];
				int newCol = nowCol + dc[dir];

				// 유효한 위치인지 확인
				if (0 <= newRow && newRow < N && 0 <= newCol && newCol < M) {
					if (graph[newRow][newCol] == 1) {
						graph[newRow][newCol] = graph[nowRow][nowCol] + 1; // 거리 업데이트
						queue.offer(new int[]{newRow, newCol}); // 큐에 추가
					}
				}
			}
		}

		return -1; // 이 줄은 사실 필요 없습니다.
	}
}
