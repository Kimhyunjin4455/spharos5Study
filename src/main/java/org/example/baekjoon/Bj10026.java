package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Bj10026 {
	static int N;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	static int ans, grAns;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());

		String[][] graph = new String[N][N]; // Not 색약의 구역
		String[][] grGraph = new String[N][N]; // 적록색약의 구역

		for (int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<N; j++){
				graph[i][j] = String.valueOf(str.charAt(j));
				grGraph[i][j] = String.valueOf(str.charAt(j));
				if(graph[i][j].equals("G")){
					grGraph[i][j] = "R"; 	// 적록 색약은 적/녹에 대해 같은 값으로 처리 임의로 초록색을 붉은색으로 처리
				}
			}
		}

		String startStr = graph[0][0]; // 문제에 제한이 없기에 시작은 0,0 부터 순서대로 처리

		visited = new boolean[N][N];
		ans = 0;
		for(int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				if (visited[i][j] == false){
					dfs(startStr, i,j, graph);
					ans += 1;
				}
			}
		} // Not 색약의 기준으로 구역 갯수 판단됨

		visited = new boolean[N][N];
		grAns = 0;
		for(int i=0; i<N; i++){
			for (int j=0; j<N; j++){
				if (visited[i][j] == false){
					dfs(startStr, i,j, grGraph);
					grAns += 1;
				}
			}
		} // 색약 기준으로 구역이 판단됨

		bw.write(ans +" "+grAns);
		bw.flush();
		bw.close();
		br.close();

	}

	public static void dfs(String startStr, int nowRow, int nowCol, String[][] graph){
		visited[nowRow][nowCol] = true;

		for(int i=0; i<4; i++){
			int nextRow = nowRow + dr[i];
			int nextCol = nowCol + dc[i];
			if ((0<=nextRow && nextRow<N) && (0<=nextCol && nextCol<N)){
				if (visited[nextRow][nextCol] == false && graph[nowRow][nowCol].equals(graph[nextRow][nextCol])){
					// 미방문 && 같은 색상
					startStr = graph[nextRow][nextCol]; // 다음 지점에서 부터
					dfs(startStr, nextRow, nextCol, graph);
				}
			}
		}

	}

}
