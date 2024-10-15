package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj15686 {
	static int N, M;
	static int[][] graph;
	static boolean[] visited;
	static List<int[]> homeList = new ArrayList<>();
	static List<int[]> chickenList = new ArrayList<>();
	static int chickenDistance = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new int[N][N];

		for (int i=0; i<N; i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for (int j=0; j<N; j++){
				graph[i][j] = Integer.parseInt(st2.nextToken());
				if (graph[i][j] == 1){
					homeList.add(new int[]{i,j});
				} else if (graph[i][j] == 2) {
					chickenList.add(new int[]{i, j});
				}
			}
		}

		visited = new boolean[chickenList.size()];

		dfs(0,0);

		bw.write(String.valueOf(chickenDistance));
		bw.flush();
		bw.close();
		br.close();


	}

	private static void dfs(int index, int count) {
		if (count == M){
			int res = 0;

			for (int i=0; i<homeList.size(); i++){
				int minDistance = Integer.MAX_VALUE;
				for (int j=0; j<chickenList.size(); j++){
					if (visited[j]){
						// 어떠한 집에 대해 그 집에서 최소거리의 치킨가게를 구함
						int distance = Math.abs(homeList.get(i)[0] - chickenList.get(j)[0])
							+ Math.abs(homeList.get(i)[1] - chickenList.get(j)[1]);
						minDistance = Math.min(minDistance, distance);
					}
				}
				// 하나의 집에 대하여 그 집은 어떤 치킨 가게의 거리가 가장 가까운지 더해나감
				res += minDistance;  // 결과에 대해 각 집에서의 최소 치킨 거리를 더해나감 -> 도시의 치킨거리에 대해 모든 경우에 대해 찾아나감
			}

			// 치킨 가게가 조건에 만족하는 수가 되었을 때, 어떠한 M개의 거리의 합이 최소일지
			chickenDistance = Math.min(chickenDistance,res);

		}
		for (int i=index; i<chickenList.size(); i++){ // 어떠한 치킨가게를 백트래킹할지 처리
			visited[i] = true;
			dfs(i+1, count +1);
			visited[i] = false; // M 조건 처리 후 앞으로의 백트래킹을 위한 처리

		}
	}
}
