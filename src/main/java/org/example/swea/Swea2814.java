package org.example.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea2814 {
	// N개의 정점과 M개의 간선
	// 가중치가 없는 무방향 그래프에서의 최장 경로의 길이 <- dfs 백트래킹
	// 정점의 번호는 1번부터 N번까지 순서대로
	// 경로에는 같은 정점의 번호가 2번 이상 등장할 수 없으며, 경로 상의 인접한 점들 사이에는 반드시 두 정점을 연결하는 간선이 존재
	// 경로의 길이는 경로 상에 등장하는 정점의 개수
	static int N,M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int maxLength;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int tc=1; tc < T+1; tc++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N+1]; // 1부터 시작하기에 +1
			visited = new boolean[N+1];
			maxLength = Integer.MIN_VALUE;

			for(int i=1; i<=N; i++){ // 아래의 for 문에서 graph의 값을 담기 위함
				graph[i] = new ArrayList<>();
			}

			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[x].add(y);
				graph[y].add(x);
			}

			for (int i=1; i<=N; i++){
				visited[i] = true;
				dfs(i,1); // 시작 점도 1개로 치기에 초기값 1설정
				visited[i] = false; 	// 백트래킹, 1번 시작이 최장 경로가 아닐 수도 있기 때문, 시작 노드에 방문처리에 대한 원복
			}


			bw.write("#"+tc+" "+maxLength);
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();


	}

	public static void dfs(int node, int depth){
		maxLength = Integer.max(maxLength, depth);
		for (int next:graph[node]){
			if (!visited[next]){
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false; // 그 노드와 이어진 노드에 대한 원복
			}
		}
	}
}
