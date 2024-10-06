package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bj1926 {
	static int N,M;

	static boolean[][] visited;
	static int[][] graph;
	static int count;
	static int extent=0;

	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N][M];
		graph = new int[N][M];

		for (int i=0; i<N; i++){
			String numStr = br.readLine();
			StringTokenizer st2 = new StringTokenizer(numStr, " ");
			for (int j=0; j<M; j++){
				graph[i][j] = Integer.parseInt(st2.nextToken());
			}
		}

		for (int i=0; i<N; i++){
			for (int j=0; j<M; j++){
				if (graph[i][j] == 1 && !visited[i][j]){
					int size = 0;
					int nowSize = dfs(i, j, size);
					if (nowSize > extent){
						extent = nowSize;
					}
					count++;
				}
			}
		}


		bw.write(String.valueOf(count));
		bw.flush();
		System.out.println();
		bw.write(String.valueOf(extent));
		bw.flush();
		bw.close();
		br.close();

	}

	public static int dfs(int row, int col, int size){
		if (visited[row][col]){
			return 0;
		} //


		visited[row][col] = true;
		size = 1;

		for (int i=0; i<4; i++){
			int newR = row+dr[i];
			int newC = col+dc[i];

			if ((0<=newR && newR<N) && (0<=newC && newC<M)){
				if (graph[newR][newC] == 1 && !visited[newR][newC]){
					size += dfs(newR, newC, size);
				}
			}

		}

		return size;

	}

}
