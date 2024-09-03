package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedTransferQueue;

public class Bj2468{
	static int maxResult;
	static int[] dr = new int[]{-1,0,1,0};
	static int[] dc = new int[]{0,1,0,-1};
	static boolean[][] visited;
	static int[][] graph;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];



		for (int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++){
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		maxResult = 0;

		for (int depth = 0; depth <= 100; depth++){ // 높이는 1이상 100 이하의 정수
			visited = new boolean[N][N];
			int result = 0;

			for (int i=0; i<N; i++){
				for (int j=0; j<N; j++){
					if (!visited[i][j] && depth < graph[i][j]){		// 방문되지 읺았고 웅덩이보다 크다면
						dfs(i,j, depth);	// 이어서 방문
						result+=1;
					}
				}
			}

			maxResult = Math.max(maxResult, result);
		}

		bw.write(String.valueOf(maxResult));
		bw.flush();
		bw.close();
		br.close();


	}
	public static void dfs(int row, int col, int depth) {
		visited[row][col] = true;
		for (int i=0; i<4; i++){
			int nRow =  row + dr[i];
			int nCol = col +dc[i];
			if ((nRow >= 0 && nRow<N) &&(nCol>=0 && nCol <N) && !visited[nRow][nCol] && depth < graph[nRow][nCol]){
				// 다음번째 방문할 것이 방문되지 않았고 웅덩이보다 크다면
				dfs(nRow, nCol,depth);
			}
		}


	}
}
