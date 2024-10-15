package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Bj14889 {
	static int N;
	static int[][] graph;
	static boolean[] visited;
	static int minDifference = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);


		bw.write(String.valueOf(minDifference));
		bw.flush();
		bw.close();
		br.close();
	}

	// startTeamAbility: 선택된 선수의 능력치
	// linkTeamAbility: 선택되지 않은 선수의 능력치
	public static void dfs(int index, int count) {
		if (count == N / 2) {
			int startTeamAbility = 0;
			int linkTeamAbility = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j]) {
						startTeamAbility += graph[i][j];
					} else if (!visited[i] && !visited[j]) { // i와 j가 다를 때만
						linkTeamAbility += graph[i][j];
					}
				}
			}

			int difference = Math.abs(startTeamAbility - linkTeamAbility);
			minDifference = Math.min(minDifference, difference);
			return;
		}

		for (int i = index; i < N; i++) {
			if (!visited[i]) { // 선수 i가 선택되지 않은 경우에만 선택
				visited[i] = true; // 선수 i 선택
				dfs(i + 1, count + 1);
				visited[i] = false; // 선수 i 선택 해제
			}
		}
	}
}
