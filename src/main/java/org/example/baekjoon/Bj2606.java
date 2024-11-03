package org.example.baekjoon;

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

public class Bj2606 {
	// 1 2 3 5 6
	// 4 7
	static List<Integer>[] graph;
	static boolean[] visited;
	static int res;
	// public static void main(String[] args) throws IOException {
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	// 	int computers = Integer.parseInt(br.readLine());
	// 	int edges = Integer.parseInt(br.readLine());
	//
	// 	visited = new boolean[computers+1];
	// 	graph = new ArrayList[computers+1];
	//
	// 	for (int i=0; i<graph.length; i++){
	// 		graph[i] = new ArrayList<>();
	// 	}
	//
	// 	for (int i=0; i<edges; i++){
	// 		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	// 		int pairLeft = Integer.parseInt(st.nextToken());
	// 		int pairRight = Integer.parseInt(st.nextToken());
	//
	// 		graph[pairLeft].add(pairRight);
	// 		graph[pairRight].add(pairLeft);
	// 	}
	//
	// 	res = 0;
	// 	dfs(1);
	//
	// 	bw.write(String.valueOf(res-1));
	// 	bw.flush();
	// 	bw.close();
	// 	br.close();
	//
	// }
	// public static void dfs(int start){
	// 	visited[start] = true;
	// 	res++;
	// 	for (int i=0; i<graph[start].size(); i++){
	// 		if(!visited[graph[start].get(i)]) dfs(graph[start].get(i));
	// 	}
	// }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int computers = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());

		graph = new ArrayList[computers+1];
		visited = new boolean[computers+1];

		for (int i=0; i<graph.length; i++){
			graph[i] = new ArrayList<>();
		}

		for (int i=0; i<edges; i++){
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int pairLeft = Integer.parseInt(st.nextToken());
			int pairRight = Integer.parseInt(st.nextToken());

			graph[pairLeft].add(pairRight);
			graph[pairRight].add(pairLeft);
		}

		res = 0;
		bfs(1);

		bw.write(String.valueOf(res-1));
		bw.flush();
		bw.close();
		br.close();

	}

	public static void bfs(int start){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		res++;
		
		while (!queue.isEmpty()){
			int current = queue.poll();
			for (int i=0; i<graph[current].size(); i++){
				int next = graph[current].get(i);
				if (!visited[next]){
					visited[next] = true;
					res++;
					queue.offer(next);
				}
			}
		}




	}
}
