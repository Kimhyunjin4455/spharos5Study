package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Bj2583 {
	static boolean[][] visited;
	static boolean[][] graph;
	static ArrayList<Integer> result = new ArrayList<>();
	static int M,N,K;
	static int currentSize;


	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		graph = new boolean[N][M];
		visited = new boolean[N][M];

		// 영역 설정
		for (int i=0; i<K; i++){
			String positionInfo = br.readLine();
			StringTokenizer st2 = new StringTokenizer(positionInfo, " ");
			int startX = Integer.parseInt(st2.nextToken());
			int startY = Integer.parseInt(st2.nextToken());
			int endX = Integer.parseInt(st2.nextToken());
			int endY = Integer.parseInt(st2.nextToken());



			for (int x = startX; x<endX; x++){
				for (int y = startY; y<endY; y++){
					graph[x][y] = true;
				}
			}


		}


		// for (boolean[] booleans:graph){
		// 	for (boolean b: booleans){
		// 		System.out.print(b+" ");
		// 	}
		// 	System.out.println();
		// }




		for (int x=0; x<N; x++){
			for (int y=0; y<M; y++){
				if (!graph[x][y] && !visited[x][y]){ // 방문 되지 않은 곳의 사이즈가 문제의 질문!
					currentSize = 0; // 현재 영역 크기 초기화
					dfs(x, y);
					result.add(currentSize);
				}
			}
		}

		Collections.sort(result);



		bw.write(String.valueOf(result.size()) + "\n");
		bw.flush();
		for (int res: result){
			bw.write(String.valueOf(res + " "));
			bw.flush();
		}
		bw.close();
		br.close();





	}

	private static void dfs(int x, int y) {

		if (visited[x][y]){
			return;
		}

		visited[x][y] = true;
		currentSize++;


		for (int i=0; i<4; i++){
			int newX = x + dx[i];
			int newY = y + dy[i];

			if ((0<=newX && newX<N) && (0<=newY && newY<M)){
				if (!graph[newX][newY] && !visited[newX][newY]){
					dfs(newX, newY);
				}
			}
		}
	}
}
