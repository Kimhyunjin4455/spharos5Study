package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1937 {
	// n × n의 크기의 대나무 숲
	// 어떤 지역에서 대나무 먹방함
	// 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동
	// 그 후 대나무 먹방
	// 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 함
	// 첫째 줄에는 판다가 이동할 수 있는 칸의 수의 최댓값을
	static int[][] graph;
	static int[][] dp;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0,1,0,-1};
	static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		dp = new int[N][N];


		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		int result = 0;
		for (int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				result = Math.max(result, dfs(i,j));
			}
		}

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();

		// 출력 태스트
		// for(int[] nums:graph){
		// 	for (int num: nums){
		// 		System.out.print(num + " ");
		// 	}
		// 	System.out.println();
		// }

	}

	public static int dfs(int row, int col){

		if (dp[row][col] != 0){
			return dp[row][col];
		}

		dp[row][col] = 1;

		for (int dir=0; dir<4; dir++){
			int nr = dr[dir] + row;
			int nc = dc[dir] + col;

			if (nr >=0 && nr <N && nc >=0 && nc <N) {
				if (graph[nr][nc] > graph[row][col]){
					dp[row][col] = Math.max(dp[row][col], dfs(nr,nc)+1);
				}
			}
		}



		return dp[row][col];
	}

	// public static void bfs(int row, int col, int start, int depth){
	// 	Queue<int[]> queue = new LinkedList<>();
	// 	queue.add(new int[]{row, col, depth});
	//
	// 	while(!queue.isEmpty()){
	// 		int[] info = queue.poll();
	// 		int r = info[0];
	// 		int c = info[1];
	// 		int d = info[2];
	//
	// 		for (int dir = 0; dir<N; dir++){
	// 			int nr = r +dr[dir];
	// 			int nc = c +dc[dir];
	//
	// 			if (nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && graph[nr][nc]>start){
	// 				visited[nr][nc] = true;
	// 				queue.offer(new int[]{nr,nc,d+1});
	// 				depth = Math.max(d+1, depth);
	// 			}
	// 		}
	//
	// 		// depth = d;
	// 	}
	//
	// 	result = Math.max(result, depth);
	// }
}
